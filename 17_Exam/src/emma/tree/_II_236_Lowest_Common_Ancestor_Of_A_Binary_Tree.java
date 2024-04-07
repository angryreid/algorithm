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
        // handle edge cases
        if (root == null || root == p || root == q) return root;
        return null;
    }
}
