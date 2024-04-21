
% Define the binary tree structure
% A tree is either empty (nil) or a node with a value, a left subtree, and a right subtree.

% Base case: An empty tree is a BST.
is_bst(nil).

% Recursive case: A tree is a BST if:
% 1. The left subtree is a BST.
% 2. The right subtree is a BST.
% 3. All values in the left subtree are less than the node's value.
% 4. All values in the right subtree are greater than the node's value.


is_bst(node(Value, Left, Right)) :-
    is_bst(Left),
    is_bst(Right),
    is_subtree_less(Left, Value),
    is_subtree_greater(Right, Value).

% Check if all nodes in the subtree are less than the given value.
% Base case: An empty tree satisfies this condition trivially.


is_subtree_less(nil, _).
% Recursive case: Check if:
% 1. The node's value is less than the given value.
% 2. The left subtree satisfies this condition.
% 3. The right subtree satisfies this condition.
is_subtree_less(node(Value, Left, Right), X) :-
    Value < X,
    is_subtree_less(Left, X),
    is_subtree_less(Right, X).

% Check if all nodes in the subtree are greater than the given value.
% Base case: An empty tree satisfies this condition trivially.



is_subtree_greater(nil, _).
% Recursive case: Check if:
% 1. The node's value is greater than the given value.
% 2. The left subtree satisfies this condition.
% 3. The right subtree satisfies this condition.
is_subtree_greater(node(Value, Left, Right), X) :-
    Value > X,
    is_subtree_greater(Left, X),
    is_subtree_greater(Right, X).