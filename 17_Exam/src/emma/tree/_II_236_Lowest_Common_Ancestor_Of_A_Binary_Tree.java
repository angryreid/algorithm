package emma.tree;

import emma.common.TreeNode;

public class _II_236_Lowest_Common_Ancestor_Of_A_Binary_Tree {
    /**
     * Find the lowest common ancestor of two nodes in a binary tree
     * @param root the root of the binary tree
     * @param p the first node
     * @param q the second node
     * @return the lowest common ancestor of p and q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root; // handle edge cases
        TreeNode left = lowestCommonAncestor(root.left, p, q); // find p or q in left subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q); // find p or q in right subtree
        if (left != null && right != null) return root; // p and q are in different subtrees
        return (left != null) ? left : right; // p and q are in the same subtree
    }
}
