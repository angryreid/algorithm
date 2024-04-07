package emma.tree;
import emma.common.TreeNode;
public class II_333_Largest_BST_Subtree {
    private boolean isBST(TreeNode root) {
        return false;
    }

    private int nodes(TreeNode root) {
        return 0;
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        if (isBST(root)) return nodes(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
}
