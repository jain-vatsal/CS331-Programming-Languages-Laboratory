% Define a predicate to check if a number is prime
is_prime(2). % 2 is a prime number
is_prime(3). % 3 is a prime number
is_prime(P) :- % For numbers greater than 3
    P > 3, % Ensure P is greater than 3
    P mod 2 =\= 0, % Check if P is odd
    \+ has_factor(P, 3). % Check if P has factors other than 1 and itself

% Define a predicate to check if a number has a factor
has_factor(N, L) :- N mod L =:= 0. % N has a factor L if N is divisible by L
has_factor(N, L) :- % Recursively check for factors
    L * L < N, % Stop when L^2 is greater than N
    L2 is L + 2, % Increment L by 2 for odd factors
    has_factor(N, L2). % Recursively check for factors

% Define a predicate to find two prime numbers summing up to an even integer
goldbach(N, [P1, P2]) :-
    N > 2, % Ensure N is greater than 2
    N mod 2 =:= 0, % Ensure N is even
    between(2, N, P1), % Iterate through all numbers between 2 and N
    is_prime(P1), % Check if P1 is prime
    P2 is N - P1, % Calculate P2
    is_prime(P2), % Check if P2 is prime
    P1 =< P2. % Ensure P1 is less than or equal to P2
