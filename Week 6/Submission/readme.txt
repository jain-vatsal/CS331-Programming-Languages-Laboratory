Goldbach's Conjecture Prolog Implementation

Goldbach's conjecture posits that every even integer greater than 2 can be expressed as the sum of two prime numbers. For instance, an example of Goldbach's conjecture is 30, which can be written as the sum of two primes: 7 and 23 (7 + 23 = 30).


Here is the complete explanation of the code I have implemented :- 

1. s_prime/1 Predicate :-

    is_prime(2). and is_prime(3).: Specifies that 2 and 3 are prime numbers.
    is_prime(P) :- P > 3, P mod 2 =\= 0, \+ has_factor(P, 3).: Defines a rule to check if a number P is prime:
        It's prime if P is greater than 3, odd (not divisible by 2), and has no factors other than 1 and itself.

2. has_factor/2 Predicate :-

    has_factor(N, L) :- N mod L =:= 0.: Checks if number N has a factor L by verifying if N is divisible by L.
    has_factor(N, L) :- L * L < N, L2 is L + 2, has_factor(N, L2).: Recursively checks for factors:
        It stops when L^2 exceeds N.
        It increments L by 2 to consider only odd factors.

3. goldbach/2 Predicate :-

    goldbach(N, [P1, P2]): Finds prime pairs [P1, P2] that sum up to the even integer N.
        N > 2: Ensures N is greater than 2.
        N mod 2 =:= 0: Ensures N is even.
        between(2, N, P1): Iterates through all numbers between 2 and N as potential values for P1.
        is_prime(P1): Checks if P1 is prime.
        P2 is N - P1: Calculates P2 as the difference between N and P1.
        is_prime(P2): Checks if P2 is prime.
        P1 =< P2: Ensures P1 is less than or equal to P2.
        !: Cuts to terminate after finding the first pair, as Goldbach's conjecture only requires one such pair for each even number.


Commands to execute :-

after opening the terminal,type :- 


swipl - to open the console

[goldbach].  => to execute the program



example input:- 

goldbach(30,L). => 
first hit enter, then keep on pressing ';' till it prints false(which means all the pairs are exhausted)

output:- 

L = [7, 23] ;
L = [11, 19] ;
L = [13, 17] ;
false.

to get only one pair, hit 'enter' just after the first pair to go for the next input.
