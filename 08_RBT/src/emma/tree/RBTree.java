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
        boolean color = true;

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }
    }

    private Node<E> coloring(Node<E> node, boolean color) {
        RBNode<E> rbNode = (RBNode<E>)node;
        rbNode.color = color;
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
        return ((RBNode<E>)node).color == BLACK;
    }

    private boolean isRed(Node<E> node) {
        return ((RBNode<E>)node).color == RED;
    }

    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;
        if (parent == null) {
            // Added root;
            black(node);
        }
        // Parent is black node (4 cases)
        if (isBlack(parent)) {
            return;
        }

        // Uncle color.
        Node<E> uncle = node.sibling();
        Node<E> grand = parent.parent;
        if (isRed(uncle)) { // overflow (4 case)
            black(parent);
            black(uncle);
            // Grand node recursevily handing
            afterAdd(red(grand));
        } else { // Uncle is black, rotating.

        }

    }

    @Override
    protected void afterRemove(Node<E> node) {
    }
}
