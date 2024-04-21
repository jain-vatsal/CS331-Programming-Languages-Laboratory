
// commands to run

// javac PrintServiceSimulation.java
// java PrintServiceSimulation

// importing the necessary libraries
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

// class representing the print queue with synchronization mechanisms
// this class manages the print queue
class PrintQueue 
{
    // this stores the max capacity of the print queue
    private final int MAX_CAPACITY;

    // this is the actual print queue
    private final Queue<String> queue;

    // Constructor to initialize the print queue with a maximum capacity
    public PrintQueue(int maxCapacity) 
    {
        this.MAX_CAPACITY = maxCapacity;

        // initializing an empty linked list as the print queue
        this.queue = new LinkedList<>();
    }

    // this is a method to add a job to the print queue, synchronized for thread safety
    public synchronized void addToQueue(String job) throws InterruptedException 
    {
        // if the queue is full, the programs waits for space to become available
        while (queue.size() == MAX_CAPACITY) 
        {
            System.out.println("\nQUEUE IS FULL.\nClient is waiting to add job: " + job);
            wait();
        }
        // add the job to the queue and notify other threads
        queue.add(job);

        // updating the user about the addition of job
        System.out.println("\nJob added to the queue: " + job);

        // notifying other threads about the addition of the job
        notifyAll();
    }

    // this is a method to remove and return a job from the print queue, synchronized for thread safety
    public synchronized String removeFromQueue() throws InterruptedException 
    {
        // While the queue is empty, wait for a job to be added
        while (queue.isEmpty()) 
        {
            System.out.println("\nQUEUE IS EMPTY.\nPrinting service waiting for a job.");
            wait();
        }


        // Remove and return a job from the queue and notify other threads
        String job = queue.poll();
        System.out.println("\nPRINTING SERVICE processing job: " + job);
        notifyAll();
        return job;
    }
}

// Class representing a client that generates print jobs
class Client extends Thread 
{
    private final PrintQueue printQueue;

    // Constructor to initialize the client with a print queue
    public Client(PrintQueue printQueue) 
    {
        this.printQueue = printQueue;
    }

    // Run method simulating continuous job generation and addition to the print
    // queue
    @Override
    public void run() 
    {
        while (true) 
        {
            try 
            {
                String job = "Job-" + Thread.currentThread().getId() + "-" + System.currentTimeMillis();
                printQueue.addToQueue(job);
                sleep(2000); // Simulate time to generate a new job

            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}

// Class representing the printing service that retrieves and processes print
// jobs
class PrintingService extends Thread 
{
    private final PrintQueue printQueue;

    // Constructor to initialize the printing service with a print queue
    public PrintingService(PrintQueue printQueue) 
    {
        this.printQueue = printQueue;
    }

    // Run method simulating continuous processing of print jobs
    @Override
    public void run() 
    {
        while (true) 
        {
            try 
            {
                String job = printQueue.removeFromQueue();
                // Simulate processing the job
                sleep(2000);
            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}

// Main class for running the print service simulation
public class PrintServiceSimulation 
{
    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        int capacity, numberOfThreads;

        System.out.print("Enter max capacity of printing queue = ");
        capacity = sc.nextInt();

        System.out.print("Enter number of threads(clients) = ");
        numberOfThreads = sc.nextInt();


        // Create a print queue with a maximum capacity of 5
        PrintQueue printQueue = new PrintQueue(capacity);

        // Create multiple client threads
        for (int i = 0; i < numberOfThreads; i++) 
        {
            new Client(printQueue).start();
        }

        // Create printing service thread
        new PrintingService(printQueue).start();
    }
}
