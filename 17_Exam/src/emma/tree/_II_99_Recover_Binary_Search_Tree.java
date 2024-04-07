package emma.tree;

import emma.common.TreeNode;

public class _II_99_Recover_Binary_Search_Tree {
    // Variables to keep track of the previous, first and second nodes
    private TreeNode pre;
    private TreeNode first;
    private TreeNode second;
    
    // Method to recover the binary search tree
    public void recoverTree(TreeNode root) {
        TreeNode node = root; // Start from the root
        while (node != null) { // While there are nodes to process
            if (node.left != null) { // If the node has a left child
                TreeNode pred = node.left; // Start from the left child
                // Find the rightmost node in the left subtree
                while(pred.right != null && pred.right != node) {
                    pred = pred.right;
                }
                if(pred.right == null) { // If the rightmost node's right child is null
                    pred.right = node; // Make the current node as its right child
                    node = node.left; // Move to the left child
                } else {
                    // If the rightmost node's right child is the current node
                    find(node); // Check if the current node is misplaced
                    pred.right = null; // Break the link to restore the original tree structure
                    node = node.right; // Move to the right child
                }
            } else {
                find(node); // Check if the current node is misplaced
                node = node.right; // Move to the right child
            }
        }
        swap(first, second); // Swap the first and second nodes to recover the tree
    }
    
    // Method to recover the tree using in-order traversal
    public void recoverTree2(TreeNode root) {
        inOrder(root); // Perform in-order traversal
        swap(first, second); // Swap the first and second nodes to recover the tree
    }

    // Method for in-order traversal
    private void inOrder(TreeNode root) {
        if (root == null) return; // If the node is null, return
        inOrder(root.left); // Traverse the left subtree
        find(root); // Check if the current node is misplaced
        inOrder(root.right); // Traverse the right subtree
    }

    // Method to find the misplaced nodes
    private void find(TreeNode root) {
        // If the previous node's value is greater than the current node's value
        if (pre != null && pre.val > root.val) {
            second = root; // The current node is the second node
            if (first != null) return; // If the first node is already found, return
            first = pre; // The previous node is the first node
        }
        pre = root; // Update the previous node
    }

    // Method to swap the values of two nodes
    private void swap(TreeNode first, TreeNode second) {
        int temp = first.val; // Store the value of the first node
        first.val = second.val; // Assign the value of the second node to the first node
        second.val = temp; // Assign the stored value to the second node
    }
}