// string 'reverse-odd-levels-of-binary-tree' convert to string splited by underscore
// reverse_odd_levels_of_binary_tree

// LeeCode: 103. Binary Tree Zigzag Level Order Traversal

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var reverseOddLevels = function(root) {
  let q = [root];
  let isOdd = false;
  while(q.length) {
      if (isOdd) {
          const n = q.length;
          for(let i = 0; i < n/2; i++) {
              [q[i].val, q[n - 1 - i].val] = [q[n - 1 - i].val, q[i].val];
          }
      }

      const tmp = [...q];
      q = []; // level loop
      for (const node of tmp) {
          if (node.left) {
              q.push(node.left);
          }
          if (node.right) {
              q.push(node.right);
          }
      }
      isOdd ^= true;
  }

  return root;
};