package emma.tree;

import emma.common.TreeNode;

public class _II_99_Recover_Binary_Search_Tree {
    private TreeNode pre;
    private TreeNode first;
    private TreeNode second;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (pre != null && pre.val > root.val) {
            second = root;
            if (first != null) return;
            first = pre;
        }
        pre = root;
        inOrder(root.right);
    }
}
