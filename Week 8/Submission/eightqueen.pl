queens_1(N,Qs) :- rangeQuery(1,N,Rs), permutation(Rs,Qs), testing(Qs).

rangeQuery(A,A,[A]).
rangeQuery(A,B,[A|L]) :- A < B, A1 is A+1, rangeQuery(A1,B,L).

permutation([], []).
permutation(Qs,[Y|Ys]) :- delFirstEle(Y,Qs,Rs), permutation(Rs,Ys).

delFirstEle(X,[X|Xs],Xs).
delFirstEle(X,[Y|Ys],[Y|Zs]) :- delFirstEle(X,Ys,Zs).

testing(Qs) :- testing(Qs,1,[],[]).

testing([],_,_,_).
testing([Y|Ys],X,Cs,Ds) :- 
    C is X-Y, \+ memberchk(C,Cs),
    D is X+Y, \+ memberchk(D,Ds),
    X1 is X + 1,
    testing(Ys,X1,[C|Cs],[D|Ds]).
