-- Declaring a binary tree data structure
data BinaryTree a = EmptyTree | Node a (BinaryTree a) (BinaryTree a) deriving (Show)

-- Depth-first traversal function
dft :: BinaryTree a -> [a]
dft EmptyTree = [] -- Base case: an empty tree returns an empty list
dft (Node val left right) =
    [val] ++ dft left ++ dft right -- Recursive traversal: left subtree, root, right subtree

-- Breadth-first traversal function
bft :: BinaryTree a -> [a]
bft tree = bfs [tree]
    where 
        bfs [] = [] -- Base case: an empty queue returns an empty list
        bfs (EmptyTree : xs) = bfs xs -- If the current node is empty, skip it
        bfs ((Node val left right) : xs) = 
            val : bfs (xs ++ [left,right]) -- Add the current node value and its children to the queue for further traversal

-- Main function
main :: IO ()
main = do
    -- Declaring an example binary tree
    let ebt :: BinaryTree Int
        ebt = Node 1 
            (Node 3 
                (Node 5 EmptyTree EmptyTree)
                (Node 8 EmptyTree EmptyTree))
            (Node 2 
                (Node 6 EmptyTree EmptyTree)
                (EmptyTree))

    -- Printing the breadth-first traversal of the binary tree
    putStrLn "Breadth-first traversal:"
    print $ bft ebt

    -- Printing the depth-first traversal of the binary tree
    putStrLn "Depth-first traversal:"
    print $ dft ebt
