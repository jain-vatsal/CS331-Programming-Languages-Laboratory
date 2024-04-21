# Binary Search Tree
Binary Search Tree is a node-based binary tree data structure which has the following properties:

    The left subtree of a node contains only nodes with keys lesser than the node’s key.
    The right subtree of a node contains only nodes with keys greater than the node’s key.
    The left and right subtree each must also be a binary search tree


## The program uses the following predicates 
Binary Search Tree is a node-based binary tree data structure which has the following properties:

    The left subtree of a node contains only nodes with keys lesser than the node’s key.
    The right subtree of a node contains only nodes with keys greater than the node’s key.
    The left and right subtree each must also be a binary search tree


## The following predicates that serve the requirements of the program 

### is_bst/1 :- 
        This predicate uses the helper predicates to check the BST condition for the entire tree.

### is_subtree_less/2 and is_subtree_greater/2 :- 
        These are helper predicates to check the conditions for the left and right subtrees.

        

## format for each node - 
node(value,<left_child>,<right_child>)

example :- 
is_bst(node(10, node(5, nil, nil), node(15, nil, nil))).


# commands to run this code - (after going to the root directory of the project)

swipl
            to start the prolog execution command line

[binarysearchtree]. 
            to compile the file.

sample inputs                                                           expected outputs

is_bst(node(5, nil, node(4, nil, nil))).                                     false
is_bst(node(5, node(6, nil, nil), nil)).                                     false
is_bst(node(5, nil, node(6, nil, node(7, nil, nil)))).                       true
is_bst(node(-5, nil, nil)).                                                  true
is_bst(nil).                                                                 true