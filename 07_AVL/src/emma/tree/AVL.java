package emma.tree;

import java.util.Comparator;

public class AVL<E> extends BST<E> {
    public AVL() {this(null);}
    public AVL(Comparator<E> comparator) {
        super(comparator);
    }

    private static class AVLNode<E> extends Node<E> {
        int height = 1;
        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        private int getLeftHeight() {
            return left == null ? 0 : ((AVLNode<E>)left).height;
        }

        private int getRightHeight() {
            return right == null ? 0 : ((AVLNode<E>)right).height;
        }

        public AVLNode<E> tallerChild() {
            if (getLeftHeight() == getRightHeight()) {
                return isLeftChild() ? ((AVLNode<E>)left) : ((AVLNode<E>)right);
            }
            return getLeftHeight() > getRightHeight() ? ((AVLNode<E>)left) : ((AVLNode<E>)right);
        }

        public int balanceFactor() {
            return getLeftHeight() - getRightHeight();
        }

        public void updateHeight() {
            height = Math.max(getLeftHeight(), getRightHeight()) + 1;
        }
    }

    private void updateHeight(Node<E> node) {
        AVLNode<E> avlNode = (AVLNode<E>) node;
        avlNode.updateHeight();
    }

    private Boolean isBalance(Node<E> node) {
        return Math.abs(((AVLNode<E>)node).balanceFactor()) <= 1;
    }

    /**
     *
     * @param grand height is the lowest and lost balance.
     */
    private void rebalance2(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();
        if (parent.isLeftChild()) {
            if (node.isRightChild()) {
                // LR
                rotateLeft(parent);
            }
            rotateRight(grand);
        } else {
            if (node.isLeftChild()) {
                // RL
                rotateRight(parent);
            }
            rotateLeft(grand);
        }
    }

    /**
     *
     * @param grand height is the lowest and lost balance.
     */
    private void rebalance(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();
        if (parent.isLeftChild()) {
            if (node.isLeftChild()) {
                // LL
                rotate(grand, node.left, node, node.right, parent, parent.right, grand, grand.right);
            } else {
                // LR
                rotate(grand, parent.left, parent, node.left, node, node.right, grand, grand.right);
            }
        } else {
            if (node.isLeftChild()) {
                // RL
                rotate(grand, grand.left, grand, node.left, node, node.right, parent, parent.right);
            } else {
                // RR
                rotate(grand, grand.left, grand, parent.left, parent, node.left, node, node.right);
            }
        }
    }

    private void rotate(
            Node<E> oRoot,
            Node<E> lTreeLeft, Node<E> lTreeRoot, Node<E> lTreeRight,
            Node<E> nRoot,
            Node<E> rTreeLeft, Node<E> rTreeRoot, Node<E> rTreeRight
    ) {
        // New root settings
        nRoot.parent = oRoot.parent;
        if (oRoot.isLeftChild()) {
            oRoot.parent.left = nRoot;
        } else if (oRoot.isRightChild()) {
            oRoot.parent.right = nRoot;
        } else {
            root = nRoot;
        }

        // New left tree settings
        lTreeRoot.left = lTreeLeft;
        lTreeRoot.right = lTreeRight;

        if (lTreeLeft != null)
            lTreeLeft.parent = lTreeRoot;
        if (lTreeRight != null)
            lTreeRight.parent = lTreeRoot;
        updateHeight(lTreeRoot);

        // New right tree settings
        rTreeRoot.left = rTreeLeft;
        rTreeRoot.right = rTreeRight;

        if (rTreeLeft != null)
            rTreeLeft.parent = rTreeRoot;
        if (rTreeRight != null)
            rTreeRight.parent = rTreeRoot;
        updateHeight(rTreeRoot);

        nRoot.left = lTreeRoot;
        nRoot.right = rTreeRoot;
        lTreeRoot.parent = nRoot;
        rTreeRoot.parent = nRoot;
        updateHeight(nRoot);
    }

    private void rotateLeft(Node<E> node) {
        Node<E> parent = node.right;
        Node<E> child = parent.left;
        node.right = parent.left;
        parent.left = node;
        afterRotate(node, parent, child);
    }

    private void rotateRight(Node<E> node) {
        Node<E> parent = node.left;
        Node<E> child = parent.right;
        node.left = parent.right;
        parent.right = node;
        afterRotate(node, parent, child);
    }
    
    public void afterRotate(Node<E> node, Node<E> parent, Node<E> child) {
        if (node.isLeftChild()) {
            node.parent.left = parent;
        } else if (node.isRightChild()){
            node.parent.right = parent;
        } else {
            root = parent;
        }
        if (child != null)
            child.parent = node;
        parent.parent = node.parent;
        node.parent = parent;
        updateHeight(node);
        updateHeight(parent);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalance(node)) {
                // To set height
                updateHeight(node);
            } else {
                rebalance(node);
                break;
            }
        }
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }
}
