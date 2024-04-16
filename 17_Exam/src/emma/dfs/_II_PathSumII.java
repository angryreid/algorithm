package emma.dfs;

import emma.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _II_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> routes = new ArrayList<>();
        dfs(root, res, routes, targetSum);
        return res;
    }

    private void dfs(TreeNode node, List<List<Integer>> res, List<Integer> routes, int remain) {
        if (node == null) return;
        routes.add(node.val);
        remain -= node.val;
        if (node.left == null && node.right == null) {
            if (remain == 0) res.add(new ArrayList<>(routes));
        } else {
            dfs(node.left, res, routes, remain);
            dfs(node.right, res, routes, remain);
        }
        routes.removeLast();
    }
}
