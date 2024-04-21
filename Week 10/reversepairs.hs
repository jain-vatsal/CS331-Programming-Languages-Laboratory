import Data.List (tails)

reversePairsCount :: [Int] -> Int
reversePairsCount xs = sum [1 | (x:ys) <- tails xs, y <- ys, x > 2 * y]

main :: IO ()
main = do
    putStrLn "Enter the elements of the list separated by spaces:"
    input <- getLine
    let nums = map read $ words input :: [Int]
        ans = reversePairsCount nums
    putStrLn $ "Number of reverse pairs: " ++ show ans
