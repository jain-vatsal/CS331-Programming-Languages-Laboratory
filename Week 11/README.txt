Problem 1 :- 
we have to implement a binary tree and perform dfs and bfs on it.

Code explanation :-
1. first we declare an empty binary tree.
2. We write the depthFirstTraversal(dft) function and perform it recursively for left and right subtrees. 
3. We write the breadthFirsttraversal(bft) function using queue and perform the level order traversal on the tree.
4. We hard code the sample input in the main function and call the bft and dft functions(change this part for different inputs, keeping the node format same, as mentioned in the code)

Running commands :- 
ghc -o tree tree.hs
./tree

Output :- 
Breadth-first traversal:
[1,2,3,4,5,6,7]
Depth-first traversal:
[4,2,5,1,6,3,7]



Problem 2 :- We have to count the number of dosas based on the given constraints.

Code explanation :- 
1. We first ask for all the inputs from the user.
2. Then we calculate the initial number of dosas purchased.
3. Then we take the group of tokens(t) for purchasing the dosa, while such a group exists(tokens>=t), and increment the purchased dosas.
4. Then we print the required answer

Running commands :- 
ghc -o dosa dosa.hs
./dosa

Example input 1 :- 
Enter total budget = 
100
Enter price of one dosa (must be greater than 0) = 
20
How many tokens for one dosa (must be greater than 1) = 
2

Example output 1 :- 
total dosas purchased = 9



Example input 2 :- 
Enter total budget = 
200
Enter price of one dosa (must be greater than 0) = 
10
How many tokens for one dosa (must be greater than 1) = 
3

Example output 2 :- 
total dosas purchased = 29