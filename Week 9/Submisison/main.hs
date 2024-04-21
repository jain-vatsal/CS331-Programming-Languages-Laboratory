import Data.Char (isAlphaNum, toLower)
import Data.List (sort, group)

-- Function to clean and tokenize the input string
-- This function takes a string as input and returns a list of words.
-- It cleans the input string by converting it to lowercase and removing non-alphanumeric characters.
-- Then, it splits the cleaned string into words.
cleanAndTokenize :: String -> [String]
cleanAndTokenize = words . map (\c -> if isAlphaNum c || c == ' ' then toLower c else ' ')

-- Function to count the frequency of each unique word
-- This function takes a string as input and returns a list of tuples,
-- where each tuple contains a unique word and its frequency in the input string.
-- It uses the cleanAndTokenize function to tokenize the input string.
-- Then, it sorts the list of words alphabetically and groups identical words together.
-- Finally, it maps each group of identical words to a tuple containing the word and its frequency.
wordFrequency :: String -> [(String, Int)]
wordFrequency = map (\ws -> (head ws, length ws)) . group . sort . cleanAndTokenize

-- Main function
main :: IO ()
main = do
    putStrLn "Enter a string:"
    input <- getLine
    let frequencies = wordFrequency input
    putStrLn "Word frequencies:"
    -- Prints each word along with its frequency
    mapM_ (\(word, freq) -> putStrLn $ word ++ ": " ++ show freq) frequencies
