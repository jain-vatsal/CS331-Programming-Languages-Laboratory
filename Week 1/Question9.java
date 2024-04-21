// this is the Question9

// commands to run
// javac Question9.java
// java Question9

// importing the necessary libraries
import java.util.concurrent.atomic.AtomicLong;
import java.util.Scanner;

// PrimeCalculator class that checks the prime numbers and calculates the sum
class PrimeSumCalculator extends Thread {

    // declaring the local variables
    private final long start;
    private final long end;
    private final AtomicLong sum;

    // assigning the values
    public PrimeSumCalculator(long start, long end, AtomicLong sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }

    @Override

    // run function to calculate the sum
    public void run() {
        long threadSum = 0;
        for (long num = start; num <= end; num++) {
            if (isPrime(num)) {
                threadSum += num;
            }
        }
        sum.addAndGet(threadSum);
    }

    // function to check whether a number is prime or not
    private boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        for (long i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        System.out.println(number + "  ==>  " + Thread.currentThread().getName());
        return true;
    }
}

public class Question9 {
    public static void main(String[] args) {

        // taking the limit as input from the user
        Scanner vatsal = new Scanner(System.in);
        System.out.print("Enter the limit = ");
        long limit = vatsal.nextLong();
        
        int numThreads; // number of threads
        System.out.print("Enter the number of threads = ");
        numThreads = vatsal.nextInt();

        System.out.println("\nThe prime numbers and the respective threads are (prime number ==> threadName) :- ");

        // thread array to store the number of threads
        Thread[] threads = new Thread[numThreads];

        // storing the totalSum of all the prime numbers
        AtomicLong totalSum = new AtomicLong(0);

        // dividing the range into batches of different sizes
        long batchSize = limit / numThreads;

        // Creating and starting the threads
        for (int i = 0; i < numThreads; i++) {
            long start = i * batchSize + 1;
            long end = (i == numThreads - 1) ? limit : (i + 1) * batchSize;

            threads[i] = new PrimeSumCalculator(start, end, totalSum);
            threads[i].start();
        }

        // Waiting for all threads to finish
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing the result
        System.out.println("\n\nSum of prime numbers up to " + limit + ": " + totalSum.get());
    }
}
