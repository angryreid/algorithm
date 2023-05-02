# Divided And Conquer

Split the original problems into multiple sub-problems, each problems must be separated from other problems.

Merge the solutions.

## Master theorem

T(n)=a*T(⌈n/b⌉)+O(n^d)

If a>0
   b>1
   d≥0

T(n)=O(n^d) d > logb(a)
T(n)=O(n^d * log(n) d = logb(a)
T(n)=O(n^(logb(a)) d < logb(a)

For merge sort: T(n)=2T(⌈n/2⌉)+O(n^1)
a=2
b=2
d=1
d=1=logb(a)=1
T(n)=O(n^d * logn)=O(nlogn)
