# AVL

## Balance Factor

The height between any node's left tree and right tree.

**Points**

- The Balance Factor must be 1, 0, -1 which equals |factor| <= 1
- The search, delete, add operation will cost O(logn)

## Correct lose Balance When add new Node

### LL

Left - Left

Rotation from the right.

### RR

Rotation from the left

### LR

RR -> LL

### RL

LL -> RR

## Balance when remove node

At this condition, only parent node need to balance.

- Removing a node may enable parent or ancestors node losing balance.
- The worst case is all parent node need to balance until the root.

## Summary

The average time complexity 

- Add O(logn)
- remove O(logn)
- find O(logn)



