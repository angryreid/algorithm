// house-robber-iii

/**
 * @param {TreeNode} root
 * @return {number}
 */
var rob = function (root) {
  const dfs = function (root) {
    if (!root) return [0, 0];
    const left = dfs(root.left);
    const right = dfs(root.right);
    const selected = root.val + left[1] + right[1];
    const notSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    return [selected, notSelected];
  };
  const ans = dfs(root);
  return Math.max(ans[0], ans[1]);
};

// Definition for a binary tree node.
function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}
