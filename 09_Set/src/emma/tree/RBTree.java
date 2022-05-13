package emma.tree;

import java.util.Comparator;

public class RBTree<E> extends BBST<E> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;


    public RBTree() {this(null);}
    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }

    private static class RBNode<E> extends Node<E> {
        boolean color = RED;

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            String str = "__";
            if (color == BLACK) {
                str = "R_";
            }
            return str + element.toString();
        }
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RBNode<>(element, parent);
    }

    private Node<E> coloring(Node<E> node, boolean color) {
        ((RBNode<E>)node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node) {
        return coloring(node, RED);
    }

    private Node<E> black(Node<E> node) {
        return coloring(node, BLACK);
    }

    private boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RBNode<E>)node).color;
    }

    private boolean isBlack(Node<E> node) {
        return colorOf(node) == BLACK;
    }

    private boolean isRed(Node<E> node) {
        return colorOf(node) == RED;
    }

    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;
        if (parent == null) {
            // Added root or overflow reaching to root node.
            black(node);
            return;
        }
        // Parent is black node (4 cases)
        if (isBlack(parent)) {
            return;
        }

        // Uncle color.
        Node<E> uncle = parent.sibling();
        Node<E> grand = red(parent.parent);
        if (isRed(uncle)) { // overflow (4 case)
            black(parent);
            black(uncle);
            // Grand node recursevily handing
            afterAdd(grand);
            return;
        }
        // Uncle is black, rotating.
        if (parent.isLeftChild()) {
            if (node.isLeftChild())  {
                // LL
                black(parent);
            } else {
                // LR
                black(node);
                rotateLeft(parent);
            }
            rotateRight(grand);
        } else {
            if (node.isLeftChild())  {
                // RL
                black(node);
                rotateRight(parent);
            } else {
                // RR
                black(parent);
            }
            rotateLeft(grand);
        }
    }
//
    @Override
    protected void afterRemove(Node<E> node) {
//        if (isRed(node)) return; // Removed red node.can be combine with below case.

        if(isRed(node)) { // Replacement node
            black(node);
            return;
        }

        Node<E> parent = node.parent;
        // Remove root
        if (parent == null) return;

        // Remove black node. And this node must be leaf node.
        boolean left = parent.left == null || node.isLeftChild();
//        Node<E> sibling = node.sibling();
        Node<E> sibling = left ? parent.right : parent.left;
        if (left) { // Deleted left node.
            if (isRed(sibling)) { // Special case.
                black(sibling);
                red(parent);
                rotateLeft(parent);
                // To change sibling
                sibling = parent.right;
            }
            // Sibling is black
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                // Sibling no red node. parent will underflow
                boolean isBlackParent = isBlack(parent);
                black(parent);
                red(sibling);
                if (isBlackParent) {
                    afterRemove(parent);
                }
            } else { // Sibling has more then one red node. will borrow node from sibling.
                if (isBlack(sibling.right)) {
                    rotateRight(sibling);
                    sibling = parent.right;
                }
                coloring(sibling, colorOf(parent));
                black(sibling.right);
                black(parent);
                rotateLeft(parent);
            }
        } else { // Deleted right node.
            if (isRed(sibling)) { // Special case.
                black(sibling);
                red(parent);
                rotateRight(parent);
                // To change sibling
                sibling = parent.left;
            }
            // Sibling is black
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                // Sibling no red node. parent will underflow
                boolean isBlackParent = isBlack(parent);
                black(parent);
                red(sibling);
                if (isBlackParent) {
                    afterRemove(parent);
                }
            } else { // Sibling has more then one red node. will borrow node from sibling.
                if (isBlack(sibling.left)) {
                    rotateLeft(sibling);
                    sibling = parent.left;
                }
                coloring(sibling, colorOf(parent));
                black(sibling.left);
                black(parent);
                rotateRight(parent);
            }
        }
    }
}
