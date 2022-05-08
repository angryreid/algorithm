package emma.tree;

import java.util.Comparator;

public class AVL<E> extends BBST<E> {
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

    protected void updateHeight(Node<E> node) {
        AVLNode<E> avlNode = (AVLNode<E>) node;
        avlNode.updateHeight();
    }

    @Override
    public void afterRotate(Node<E> node, Node<E> parent, Node<E> child) {
        super.afterRotate(node, parent, child);
        updateHeight(node);
        updateHeight(parent);
    }

    @Override
    protected void rotate(Node<E> oRoot, Node<E> lTreeLeft, Node<E> lTreeRoot, Node<E> lTreeRight, Node<E> nRoot, Node<E> rTreeLeft, Node<E> rTreeRoot, Node<E> rTreeRight) {
        super.rotate(oRoot, lTreeLeft, lTreeRoot, lTreeRight, nRoot, rTreeLeft, rTreeRoot, rTreeRight);
        updateHeight(lTreeRoot);
        updateHeight(rTreeRoot);
        updateHeight(nRoot);
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
    protected void afterRemove(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalance(node)) {
                // To set height
                updateHeight(node);
            } else {
                rebalance(node);
            }
        }
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }
}
