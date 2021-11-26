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

 function searchBST(root: TreeNode | null, val: number): TreeNode | null {
  if (root == null) return root;

  while (root != null) {
    if (root.val == val) return root;

    if (root.left && root.val > val) {
      root = root.left;
    } else if (root.right && root.val < val) {
      root = root.right
    } else {
      return null;
    }
  }
};


function searchBST(root: TreeNode | null, val: number): TreeNode | null {
  if (root == null) return root;
  if (root.val == val) return root;

  if (root.left && root.val > val) {
    return searchBST(root.left, val);
  }

  if (root.right && root.val < val) {
    return searchBST(root.right, val);
  }

  return null;
};


