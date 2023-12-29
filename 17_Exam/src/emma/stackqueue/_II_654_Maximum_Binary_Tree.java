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

    public int[] parentIndexes(int[] nums) {
        /**
         * 1. Traverse the array
         * 2. Keep stack of indexes of elements that are smaller than the current element
         * 3. If the stack is empty, the parent of the current element is -1
         */
        int len = nums.length;
        int[] lis = new int[len];
        int[] ris = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            ris[i] = -1;
            lis[i] = -1;
            int v = nums[i];
            while (!stack.isEmpty() && v >= nums[stack.peek()]) {
                ris[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                lis[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] parents = new int[len];
        for (int i = 0; i < len; i++) {
            if (lis[i] == -1 && ris[i] == -1) {
                parents[i] = -1;
            } else if (lis[i] == -1) {
                parents[i] = ris[i];
            } else if (ris[i] == -1) {
                parents[i] = lis[i];
            } else {
                parents[i] = nums[lis[i]] > nums[ris[i]] ? lis[i] : ris[i];
            }
        }
        return parents;
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
