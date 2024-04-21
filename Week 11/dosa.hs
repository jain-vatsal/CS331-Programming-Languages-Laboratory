-- Importing the 'when' function from the 'Control.Monad' module
import Control.Monad (when)

-- Main function
main :: IO ()
main = do
    -- Prompting user to enter the total budget
    putStrLn "Enter total budget = "
    -- Reading the total budget from the user
    x <- readLn
    -- Prompting user to enter the price of one dosa (must be greater than 0)
    putStrLn "Enter price of one dosa (must be greater than 0) = "
    -- Reading the price of one dosa from the user
    y <- readLn
    -- Prompting user to enter how many tokens for one dosa (must be greater than 0)
    putStrLn "How many tokens for one dosa (must be greater than 1) = "
    -- Reading the number of tokens for one dosa from the user
    t <- readLn
    -- Checking if the price of one dosa is not 0
    if y == 0
        -- If the price is 0, printing an error message
        then putStrLn "Error: don't enter 0 cost of dosa"
        -- If the price is not 0, proceeding with the calculation
        else do
            -- Calculating the initial number of dosas that can be purchased with the total budget
            let purchased = x `div` y
                -- Recursive function to simulate the purchase process
                go tokens purchased' = do
                    -- Calculating the number of dosas that can be purchased with the current tokens
                    let rt = tokens `div` t
                        -- Updating the total number of purchased dosas
                        purchased'' = purchased' + rt
                        -- Calculating the remaining tokens after the purchase
                        tokens' = tokens `mod` t + rt
                    -- Checking if there are enough tokens to purchase another dosa
                    if tokens' >= t
                        -- If there are enough tokens, recursively calling the 'go' function with updated values
                        then go tokens' purchased''
                        -- If there are not enough tokens, printing the total number of purchased dosas
                        else putStrLn $ "total dosas purchased = " ++ show purchased''
            -- Initiating the purchase process with initial values of tokens and purchased dosas
            go purchased purchased
