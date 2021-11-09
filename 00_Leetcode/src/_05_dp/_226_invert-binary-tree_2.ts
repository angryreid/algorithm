/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

 function invertTree(root: TreeNode | null): TreeNode | null {
  if (root == null) return root;

  const tempNode = new TreeNode(root.val, root.left, root.right); // copy root
  root.left = tempNode.right;
  root.right = tempNode.left;
  invertTree(root.left);
  invertTree(root.right);
  return root;
};