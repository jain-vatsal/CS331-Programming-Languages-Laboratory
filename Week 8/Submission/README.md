# Prolog 8 Queens Problem

## Overview
This utility provides a Prolog predicate for generating all the possible positions of queens columnwise such that no two queens attack each other, they cannot share the same row, same column, or diagonal.

## Usage Instructions

### Predicates
- `rangeQuery/3`: generates a list of numbers from 1 to N in increasing order.
- `permutation/2`: generates permutationtation of numbers from 1 to N.
- `delFirstEle/3`: deletes the first element of the list.
- `testing/4`: checks whether the queens placement is attacking or not.
- `queens_1/2`: generates all the possible permutations.

### How to Use
1. **Define the Predicates**: Ensure all provided predicates are defined in your Prolog environment.
2. **Call `queens_1/2`**: Use the `queens_1/2` predicate to generate all the different permutations. Pass the number of queens and the variable L to print the possible permutations.

## Assumptions
- The user should input as queens_1(N,L), where n is the number of the queens on the board.
- To get all the possible permutations, press semicolon to guide through all the permutations after running the command
    `queens_1(N,L).`

## Directions to run the program
- Run swipl -s n_queen.pl
- The prolog terminal will open and then type queens_1(N,L).and keep traversing throguh all the permutationatations.

## Running Commands


swipl => to load the environment

[eightqueen]. => to load the executable

sample inputs :-
1. queens_1(4,L).
L = [2, 4, 1, 3] ;
L = [3, 1, 4, 2] ;

2. queens_1(5,L).
L = [1, 3, 5, 2, 4] ;
L = [1, 4, 2, 5, 3] ;
L = [2, 4, 1, 3, 5] ;
L = [2, 5, 3, 1, 4] ;
L = [3, 1, 4, 2, 5] ;
L = [3, 5, 2, 4, 1] ;
L = [4, 1, 3, 5, 2] ;
L = [4, 2, 5, 3, 1] ;
L = [5, 2, 4, 1, 3] ;
L = [5, 3, 1, 4, 2] ;