# Union Find

Disjoint Set

Applicable for blow cases.

- Combination
- Find

The average time complexity is `O(y(n)), y(n) < 5`

Operations Core:

1. Find: To find the data set of target element.
2. Union: To union two data set with two diff element.

Solutions:

**Quick Find**

Time of complexity->

- find: O(1)
- union: O(n)

**Quick Union**

Time of complexity->

- find: `O(y(n)), y(n) < 5`
- union: `O(y(n)), y(n) < 5`


## Test

Count 10 000

```txt
[QuickFind]
Start time: 16:45:38.032
End time: 16:45:38.081
Cost: 0.049s
-------------------------------------
[QuickUnion]
Start time: 16:45:38.084
End time: 16:45:38.115
Cost: 0.031s
-------------------------------------
[QuickUnionSize]
Start time: 16:45:38.116
End time: 16:45:38.119
Cost: 0.003s
-------------------------------------
[QuickUnionRank]
Start time: 16:45:38.120
End time: 16:45:38.122
Cost: 0.002s
-------------------------------------
[QuickUnionRankPathCompress]
Start time: 16:45:38.123
End time: 16:45:38.125
Cost: 0.002s
-------------------------------------
[QuickUnionRankPathSplit]
Start time: 16:45:38.126
End time: 16:45:38.129
Cost: 0.003s
-------------------------------------
[QuickUnionRankPathHalf]
Start time: 16:45:38.129
End time: 16:45:38.132
Cost: 0.003s
-------------------------------------
```
