package tree;

import java.util.ArrayList;
import java.util.List;

//Q: https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
//A: https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/solution/alton-er-cha-shu-zhong-suo-you-ju-chi-we-osk3/
public class _863_k_target {

    /**
     * Definition for a binary tree node.
     */
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    String[] help = new String[501];
    String compare = "";
    int tValue;
    int k;

    public List<Integer> distanceK(TreeNode root, TreeNode t, int k) {

        List<Integer> res = new ArrayList<>();
        tValue = t.val;
        this.k = k;

        // k 等于 0， 只有本身符合条件
        if (k == 0)  {
            res.add(t.val);
            return res;
        }

        // 树节点范围 [0,500] 不在此范围的 k 没有任何意义。直接返回 res
        if (k > 500) {
            // 空  list
            return res;
        }

        dfs(root, "1");

        for (int i = 0; i < 501; i++) {
            if (help[i] != null && getDistance(compare, help[i]) == k) {
                res.add(i);
            }
        }

        return res;
    }

    private int getDistance(String compare, String flag) {
        int equalValue = 0;
        int compareLen = compare.length(), flagLen = flag.length();
        char[] compareChar = compare.toCharArray(), flagChar = flag.toCharArray();
        if (Math.abs(compareLen - flagLen) > k) {
            return -1;
        }
        for (int i = 0; i < Math.min(compareLen, flagLen); i++) {
            if (compareChar[i] == flagChar[i]) {
                equalValue++;
            } else {
                break;
            }
        }

        return compareLen + flagLen - 2 * equalValue;

    }

    private void dfs(TreeNode node, String par) {

        if (node == null) {
            return;
        }

        help[node.val] = par;
        if (node.val == tValue) {
            compare = par;
        }

        dfs(node.left, par + "0");
        dfs(node.right, par + "1");
    }
}
