package emma.dfs;

import emma.common.TreeNode;

public class _II_PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode node, int remain) {
        boolean res = false;
        if (node == null) return res;
        remain -= node.val;
        if (node.left == null && node.right == null) {
            if (remain == 0) res = true;
        } else {
            if (node.left != null) {
                res = dfs(node.left, remain);
            }
            if (node.right != null && !res) {
                res = dfs(node.right, remain);
            }
        }
        return res;
    }

    static class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return sum == root.val;
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
