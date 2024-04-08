package emma.tree;
import emma.common.TreeNode;
public class II_333_Largest_BST_Subtree {
    private boolean isBST(TreeNode root) {
        return false;
    }

    private int nodes(TreeNode root) {
        return 0;
    }
    /**
     * Preorder traversal -> root, left, right
     * This solution is not correct, but it is a good starting point, it will have much more duplicated cases
     * Method to find the largest BST subtree
     * @param root The root of the tree
     * @return The size of the largest BST subtree
     */
    public int largestBSTSubtree2(TreeNode root) {
        if (root == null) return 0;
        if (isBST(root)) return nodes(root);
        return Math.max(largestBSTSubtree2(root.left), largestBSTSubtree2(root.right));
    }

    public int largestBSTSubtree(TreeNode root) {
        return (root == null) ? 0 : getInfo(root).size;
    }

    private MaxSubBSTTreeInfo getInfo(TreeNode root) {
        if (root == null) return null;

        MaxSubBSTTreeInfo li = getInfo(root.left);
        MaxSubBSTTreeInfo ri = getInfo(root.right);

        int liSize = -1, riSize = -1, max = root.val, min = root.val;

        if (li == null) {
            liSize = 0;
        } else if (li.root == root.left && li.max < root.val) {
            liSize = li.size;
            min = li.min;
        }

        if (ri == null) {
            riSize = 0;
        } else if (ri.root == root.right && ri.min > root.val) {
            riSize = ri.size;
            max = ri.max;
        }

        // root is BST
        if(liSize >= 0 && riSize >= 0) {
            return new MaxSubBSTTreeInfo(root, 1 + liSize + riSize, max, min)
        }

        // root is not BST
        if (li != null && ri != null) return li.size > ri.size ? li : ri;
        return li != null ? li : ri;
    }

    private static class MaxSubBSTTreeInfo {
        public TreeNode root;
        public int size = 1;
        public int max = 0;
        public int min = 0;

        public MaxSubBSTTreeInfo(TreeNode root, int size, int max, int min) {
            this.root = root;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    

    // public static class Result {
    //     int size;
    //     int lower;
    //     int upper;
    //     boolean isBST;

    //     public Result() {
    //         this.size = 0;
    //         this.lower = Integer.MAX_VALUE;
    //         this.upper = Integer.MIN_VALUE;
    //         this.isBST = false;
    //     }
    // }

    // private Result largestBSTSubtreeHelper(TreeNode root) {
    //     if (root == null) {
    //         Result r = new Result();
    //         r.isBST = true; // An empty tree is a BST
    //         return r;
    //     }

    //     Result left = largestBSTSubtreeHelper(root.left);
    //     Result right = largestBSTSubtreeHelper(root.right);

    //     Result r = new Result();
    //     // An invalid subtree will cause the whole tree to be invalid.
    //     if (!left.isBST || !right.isBST || root.val <= left.upper || root.val >= right.lower) {
    //         r.isBST = false;
    //         r.size = Math.max(left.size, right.size); // Return the size of the largest BST
    //         return r;
    //     }

    //     r.isBST = true;
    //     r.size = left.size + 1 + right.size;
    //     r.lower = root.left != null ? left.lower : root.val;
    //     r.upper = root.right != null ? right.upper : root.val;

    //     return r;
    // }

//     public int largestBSTSubtree(TreeNode root) {
//         return largestBSTSubtreeHelper(root).size;
//     }
}
