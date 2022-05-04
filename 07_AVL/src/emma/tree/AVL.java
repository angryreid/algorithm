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
    private void rebalance(Node<E> grand) {
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
