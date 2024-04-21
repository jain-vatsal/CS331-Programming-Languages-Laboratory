# String Generator with Multithreading

This Java program generates all strings of a specified length N in sorted order using numbers from 0 to 9. It utilizes multithreading to concurrently form each character of the string and count the frequency of each digit, both forward and backward. The results are printed to the console and written to a file named `output.txt`.

## Usage

### Running the Program

To run the program, compile the `StringGenerator.java` file and execute the compiled class:

```bash
javac MultithreadStringGenerator.java
java MultithreadStringGenerator
