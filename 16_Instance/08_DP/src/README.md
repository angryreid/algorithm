# Dynamic Programing

Dynamic Programing is a method for solving a complex problem by breaking it down into a collection of simpler subproblems, solving each of those subproblems just once, and storing their solutions.

## Steps

1. To set a status `dp[i]`
2. To set initial status, `dp[0]`, `dp[1]`? ....
3. To set the status changing formula, `d[i] ?= dp[i - 1]`

### Aims

1. 最优子结构（最优化原理）：通过求解子问题的最优解，可以获得原问题的最优解。
2. 无后效性： 某阶段的状态一旦确定，则此后过程的演变不再受此前各状态及决策的影响。在获取后面阶段的状态时，只关心前面阶段的具体状态，不关心这个状态是怎么获取。
