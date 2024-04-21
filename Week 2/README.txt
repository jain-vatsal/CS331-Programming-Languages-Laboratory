------------ PRINTING SERVICE in JAVA ----------

I have implemented a JAVA program that simulates a printing service with multiple print jobs. The system consists of a print queue shared between multiple clients who submit print jobs.

Format of each job =>   Job - (client_id/thread_id) - timestamp

Clients can add jobs to the print queue, and wait if the queue has already reached it's max capacity.

The removal and addition of jobs from and to the print queue is notified to all the other threads.


FUNCTION AND CLASS WISE DESCRIPTIONS :- 

1. class PrintServiceSimulation

    The maxCapacity of the queue and the number of threads/clients are taken as input from the user.
    Then the multiple thread clients and the printing service thread are create.

2. class PrintQueue

    The parameterized constructor initialises the maxCapacity and the print queue represented as a LinkedList.

    addToQueue() -> this function is used by different threads/clients to add jobs to the print queue. The clients wait if the queue is full, and add them if the space is available. The addition of jobs is notified to all other threads.

    removeFromQueue() -> this function handles removal of jobs from the queue. The system waits if the queue is empty, else processes and removes the jobs from the front of the queue. The removal of jobs is notified to all the other threads.

3. class Client

    run() -> the client creates a new job, tries to add it to the print queue and sleeps for some time to simulate time for creating a new job

4. class PrintingService

    run() -> this handles the removal of jobs from the print queue


Commands to run :- 
javac PrintServiceSimulation.java
java PrintServiceSimulation



