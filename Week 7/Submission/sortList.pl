% Helper predicate to count occurrences of an element in the list
countNumber([], _, 0).
countNumber([X|Rest], X, Count) :-
   countNumber(Rest, X, RestCount),
   Count is RestCount + 1.
countNumber([Y|Rest], X, Count) :-
   Y \= X,
   countNumber(Rest, X, Count).

% Main Dutch Flag Sorting predicate
sortList(UnsortedList, SortedList) :-
   countNumber(UnsortedList, 'red', RedCount),
   countNumber(UnsortedList, 'white', WhiteCount),
   countNumber(UnsortedList, 'blue', BlueCount),
   findall('red', between(1, RedCount, _), RedList),
   findall('white', between(1, WhiteCount, _), WhiteList),
   findall('blue', between(1, BlueCount, _), BlueList),
   append(RedList, WhiteList, TempList),
   append(TempList, BlueList, SortedList).
