Blocking Queue


I have implemented a Blocking queue, which is a simple producer-consumer scenario using the BlockingQueue Interface in Java.

FUNCTIONS and CLASS-WISE Descriptions :-

1. class Producer

    We declare a blockingqueue of integer type which is shared between producer and consumer, with a constructor to initialize the shared blockingqueue

    run() - this method is overridden from the runnable interface, which has a while loop to iteratively generate elements from 1 to 10.

    We also add a sentinel value(-1) which signals the consumer to stop(when all the items from 1 to 10 are produced).

    We also set the interrupt flag using Thread.currentThread().interrupt() to handle interruption.


2. class Consumer

    We declare a private BlockingQueue of Integer type to be shared between producer and consumer, with a constructor to intitalise this

    run() - this method is overridden from the runnable interface, which has a while loop to iteratively consume elements from 1 to 10.


    The loop is exited when the senitel value(-1) is received.

    We also set the interrupt flag using Thread.currentThread().interrupt() to handle interruption.


3. class MasterBlockingQueue

    this is the MAIN class.

    We create a BlockingQueue of Integer type with a maximum capacity of 5, and the producer and the consumer threads.

    Then we start both the threads, and wait for both of them to finish. This ensures all the items are produced and consumed before the termination of the program.



commands to run

javac MasterBlockingQueue.java
java MasterBlockingQueue