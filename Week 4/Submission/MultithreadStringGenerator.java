import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

class CharacterThread extends Thread {
   private final int threadId;
   private final int N;
   private final CountDownLatch latch;
   private final StringBuilder currentString;

   public CharacterThread(int threadId, int N, CountDownLatch latch, StringBuilder currentString) {
       this.threadId = threadId;
       this.N = N;
       this.latch = latch;
       this.currentString = currentString;
   }

   @Override
   public void run() {
       try {
           generateStrings(threadId, N, latch, currentString);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }

   private void generateStrings(int threadId, int N, CountDownLatch latch, StringBuilder currentString) throws InterruptedException {
       if (threadId < N - 1) {
           for (int i = 0; i <= 9; i++) {
               currentString.setCharAt(threadId, (char) ('0' + i));
               latch.countDown(); // Signal that the character is generated
               latch.await(); // Wait for the next character to be generated
           }
       } else {
           for (int i = 0; i <= 9; i++) {
               currentString.setCharAt(threadId, (char) ('0' + i));
               latch.countDown(); // Signal that the string is generated
               latch.await(); // Wait for digit counters to finish
           }
       }
   }
}

class CounterThread extends Thread {
   private final StringBuilder currentString;
   private final int[] digitCount;
   private final int start;
   private final int end;

   public CounterThread(StringBuilder currentString, int[] digitCount, int start, int end) {
       this.currentString = currentString;
       this.digitCount = digitCount;
       this.start = start;
       this.end = end;
   }

   @Override
   public void run() {
       countDigits();
   }

   private void countDigits() {
       for (int i = start; i < end; i++) {
           int digit = currentString.charAt(i) - '0';
           digitCount[digit]++;
       }
   }
}

public class MultithreadedStringGenerator {
   public static void main(String[] args) {
       int N = getUserInput();
       CountDownLatch latch = new CountDownLatch(N);

       try (FileWriter writer = new FileWriter("output.txt")) {
           for (int i = 0; i <= 9; i++) {
               StringBuilder currentString = new StringBuilder("0".repeat(N));
               currentString.setCharAt(0, (char) ('0' + i));

               int[] digitCount = new int[10];

               Thread charThread = new CharacterThread(1, N, latch, currentString);
               Thread forwardCounterThread = new CounterThread(currentString, digitCount, 0, N / 2);
               Thread backwardCounterThread = new CounterThread(currentString, digitCount, N / 2, N);

               charThread.start();
               forwardCounterThread.start();
               backwardCounterThread.start();

               charThread.join();
               forwardCounterThread.join();
               backwardCounterThread.join();

               writer.write("String: " + currentString.toString() + "\n");
               writer.write("Digit Frequencies: ");
               for (int j = 0; j <= 9; j++) {
                   writer.write(j + ": " + digitCount[j] + " ");
               }
               writer.write("\n\n");
           }
       } catch (IOException | InterruptedException e) {
           e.printStackTrace();
       }
   }

   private static int getUserInput() {
       Scanner scanner = new Scanner(System.in);

       System.out.print("Enter the length N for the strings: ");
       while (!scanner.hasNextInt()) {
           System.out.println("Invalid input. Please enter a valid integer.");
           System.out.print("Enter the length N for the strings: ");
           scanner.next(); // consume invalid input
       }

       int N = scanner.nextInt();
       scanner.close();

       return N;
   }
}
