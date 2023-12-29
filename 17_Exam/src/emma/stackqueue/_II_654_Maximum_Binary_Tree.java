package emma.stackqueue;

public class _II_654_Maximum_Binary_Tree {




    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return findRoot(nums, 0, nums.length);
    }

    /**
     * [l, r)
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public TreeNode findRoot(int[] nums, int l, int r) {
        if (l >= r) return null;
        int maxIdx = l;
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = findRoot(nums, l, maxIdx);
        root.right = findRoot(nums, maxIdx + 1, r);
        return root;
    }

    /**
     * Definition for a binary tree node.
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
