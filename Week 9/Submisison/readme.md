Functions of the program :- 

*** THIS PROGRAM JUST IGNORES PUNCTUATIONS AND SPACES, NOT NUMBERS ***
*** THIS PROGRAM SEPERATES BY PUNCTUATIONS ALSO ***

Explanation:

1. cleanAndTokenize:
        This function takes a string as input and returns a list of words.
        It first cleans the input string by converting it to lowercase and removing non-alphanumeric characters using isAlphaNum and toLower.
        Then, it splits the cleaned string into words using the words function.

 2. wordFrequency:
        This function takes a string as input and returns a list of tuples.
        Each tuple contains a unique word and its frequency in the input string.
        It uses the cleanAndTokenize function to tokenize the input string.
        Then, it sorts the list of words alphabetically using sort.
        Next, it groups identical words together using group.
        Finally, it maps each group of identical words to a tuple containing the word and its frequency using a combination of map and list comprehension.

3. main:
        This is the main function of the program.
        It prompts the user to enter a string.
        It reads the input string from the user.
        It calculates the word frequencies using the wordFrequency function.
        It prints each word along with its frequency using mapM_.

Running commands :-
ghci main.hs - to load the environment
main - to enable the user to enter inputs

examples :-


Enter a string:
vatsal is Vatsal Is Jain jian Jain jain
Word frequencies:
is: 2
jain: 3
jian: 1
vatsal: 2


Enter a string:
vatsal1234 vsta
Word frequencies:
vatsal1234: 1
vsta: 1

Enter a string:
vat@jain
Word frequencies:
jain: 1
vat: 1