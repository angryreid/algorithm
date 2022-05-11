# Red Black Tree

RBT is balance tree.

- Node must be red or black
- Root must be black
- Leaf (Empty node) must be black
- Red node's children must be black.
- Starting from any node, it's children have the same black node.

RBT equals Degree 4 B tree.
- Black node combine with its red node will consist of one B tree node.
- RB tree's black node count equals B tree node number.

RB tree's max path will not greater than 2 times of the min path.

Time complexity 

- Find O(logn)
- Add O(logn) O(1) rotating cost
- Remove O(logn) O(1) rotating cost

AVL VS Red Black Tree

- More and more finding: AVL

- Other: Red Black Tree