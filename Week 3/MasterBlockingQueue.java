// Importing the necessary Java utilities for concurrent programming
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

// Define a producer class implementing the Runnable interface
class Producer implements Runnable {

    // Declare a private BlockingQueue of Integer type to be shared between producer and consumer
    private BlockingQueue<Integer> queue;

    // Constructor for the Producer class, initializing the shared BlockingQueue
    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    // Override the run method from the Runnable interface
    @Override
    public void run() {
        try {

            Integer i = 1;
            while(i<=10)
            {
                // Produce item and put it into the queue
                System.out.println("The item number being produced is : " + i+"\n-----------------------------");

                // this method add an item to the queue if space is available, else waits for the space to be available
                queue.put(i);

                // Simulate some work before producing (e.g., time delay)
                Thread.sleep(500);

                // incrementing the value of i
                i++;
            }
            
            // Adding a sentinel value to signal the consumer to stop
            queue.put(-1);



        } catch (InterruptedException e) {

            // Handle interruption by setting the interrupted flag
            Thread.currentThread().interrupt();
        }
    }
}


// Define a consumer class implementing the Runnable interface
class Consumer implements Runnable {

    // Declare a private BlockingQueue of Integer type to be shared between producer and consumer
    private BlockingQueue<Integer> queue;


    // Constructor for the Consumer class, initializing the shared BlockingQueue
    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }


    // Override the run method from the Runnable interface
    @Override
    public void run() {
        try {

            // Infinite loop to continuously consume items
            while (true) {

                // Consume item from the queue
                // if the queue is empty, this method waits for an item to be available for removal in the queue.
                Integer value = queue.take();


                if (value == -1) {
                    // Received sentinel value, exit the loop
                    break;
                }
                System.out.println("The item number being consumed is : " + value+"\n-----------------------------");

                // Simulate some work before consuming (e.g., time delay)
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

            // Handle interruption by setting the interrupted flag
            Thread.currentThread().interrupt();
        }
    }
}


// Main class to demonstrate the usage of the BlockingQueue with producer and consumer threads
public class MasterBlockingQueue {
    public static void main(String[] args) {


        // Create a BlockingQueue of Integer type with a maximum capacity of 5
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Create producer and consumer threads
        Thread producerThread = new Thread(new Producer(queue)), consumerThread = new Thread(new Consumer(queue));

        // Start the threads
        producerThread.start();
        consumerThread.start();

        try {
            // Wait for the producer to finish producing
            producerThread.join();



            // Signal the consumer to stop by putting a sentinel value
            queue.put(-1);


            // Wait for the consumer to finish consuming
            consumerThread.join();


        } catch (InterruptedException e) {


            // Handle interruption by setting the interrupted flag
            Thread.currentThread().interrupt();
        }
    }
}
