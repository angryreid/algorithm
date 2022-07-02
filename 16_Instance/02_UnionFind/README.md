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
Start time: 16:15:51.327
End time: 16:15:55.677
Cost: 4.35s
-------------------------------------
[QuickUnion]
Start time: 16:15:55.680
End time: 16:16:04.549
Cost: 8.869s
-------------------------------------
[QuickUnionSize]
Start time: 16:16:04.551
End time: 16:16:04.568
Cost: 0.017s
-------------------------------------
[QuickUnionRank]
Start time: 16:16:04.569
End time: 16:16:04.585
Cost: 0.016s
-------------------------------------
```
