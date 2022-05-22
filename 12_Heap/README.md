# Heap

## BinaryHeap

The data structure is a full binary tree, but it can be map as array based on index.

`i`, the index of node.
`n`, the number of all nodes.

1. `i == 0`, the root node
2. `i > 0`, the father node of i is `floor((i-1)/2)`
3. `2*i + 1 <= n - 1`, the **left** child node's index is `2 * i + 1`
4. `2*i + 1 > n - 1`, node doesn't have **left** child.
5. `2*i + 2 <= n - 1`, the **right** child node's index is `2 * i + 2`
6. `2*i + 2 > n - 1`, node doesn't have **right** child.
