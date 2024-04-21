Here is the sample explanation of the code 
    
    countNumber/3 predicate:
        This predicate is used to count the occurrences of a particular element in a list.
        countNumber([], _, 0).: The base case of the predicate states that the count of occurrences of any element in an empty list is 0.
        countNumber([X|Rest], X, Count) :- countNumber(Rest, X, RestCount), Count is RestCount + 1.: This rule states that if the head of the list X is the element we are counting, then the count of occurrences is one more than the count of occurrences in the rest of the list.
        countNumber([Y|Rest], X, Count) :- Y \= X, countNumber(Rest, X, Count).: This rule states that if the head of the list Y is not the element we are counting, then the count of occurrences remains the same as the count in the rest of the list.

    sortList/2 predicate:
        This is the main predicate implementing the Dutch Flag Sorting algorithm.
        It counts the occurrences of each color in the input list using the countNumber/3 predicate.
        Then, it generates lists containing the appropriate number of each color using findall/3 and between/3.
        Finally, it appends these lists together to form the sorted list.

The commented-out code snippet at the bottom (# sortDutchFlagList(InputList,resultantArray) :- ...) appears to be an alternative implementation using the partition/4 predicate, but it's commented out and not part of the main code flow.

In summary, the countNumber/3 predicate is used to count occurrences of elements in a list, and sortDutchFlagList/2 sorts a list of colors (red, white, blue) according to the Dutch Flag Sorting algorithm.



Running commands - 

swipl => to load the environment

[sortList]. => to load the executable

sample inputs :-
1. sortList(['white', 'blue','white'], SortedList).
output => SortedList = [white, white, blue] .

2. sortList(['red','blue','white'], SortedList).
output => SortedList = [red, white, blue] .

3. sortList([], SortedList).
output => SortedList = [].

4. sortList(['white','blue','red','red','red','white','white','blue','red','red','red','white'], SortedList).
output => SortedList = [red, red, red, red, red, red, white, white, white|...] .

this |... occurs for long inputs.

Note :- due to the counting occurences algo used, colors other than red, white and blue are ignored/skipped.
