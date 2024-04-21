I have created a Haskell program that calculates the number of reverse pairs in a list of integers provided by the user. A reverse pair is a pair of indices (i, j) in the list where the element at index i is greater than twice the element at index j.


How the Program Works

    Import Statement:
        I import the tails function from the Data.List module. This function generates all the suffixes of a list.
        tails is used to generate all possible pairs of elements in the list for comparison.

    Reverse Pairs Count Function (reversePairsCount):
        This function takes a list of integers as input and calculates the number of reverse pairs in the list.
        It uses a list comprehension to generate pairs of elements from the tails of the input list.
        For each pair (x, y), it checks if x is greater than 2 times y. If so, it adds 1 to the count.
        Finally, it sums up all the counts to get the total number of reverse pairs.

    Main Function (main):
        The main function is the entry point of the program.
        It prompts the user to enter the elements of the list separated by spaces.
        It reads the input from the user and converts it into a list of integers.
        It calculates the number of reverse pairs in the list using the reversePairsCount function.
        It then prints the result, showing the number of reverse pairs found in the input list.

Running the Program

To run the program,write in the terminal:

    ghc reversepairs.hs 
    ./reversepairs


Example inputs:


1.
Enter the elements of the list separated by spaces:
3 1 5 2 6 1
Number of reverse pairs: 5

2.
Enter the elements of the list separated by spaces:
1
Number of reverse pairs: 0