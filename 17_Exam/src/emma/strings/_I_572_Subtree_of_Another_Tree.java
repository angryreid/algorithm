package emma.strings;

import emma.common.TreeNode;

public class _I_572_Subtree_of_Another_Tree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        return postSerialise(root).contains(postSerialise(subRoot));
    }

    private String postSerialise(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postSerialise(root, sb);
        return sb.toString();
    }

    private void postSerialise(TreeNode node, StringBuilder sb) {
        if (node.left == null) {
            sb.append("#!");
        } else {
            postSerialise(node.left, sb);
        }

        if (node.right == null) {
            sb.append("#!");
        } else {
            postSerialise(node.right, sb);
        }

        sb.append(node.val).append("!");
    }
}
