package emma.tree;

import java.util.Comparator;

public class BBST<E> extends BST<E> {

    public BBST() {this(null);}
    public BBST(Comparator<E> comparator) {
        super(comparator);
    }

    protected void rotate(
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

        // New right tree settings
        rTreeRoot.left = rTreeLeft;
        rTreeRoot.right = rTreeRight;

        if (rTreeLeft != null)
            rTreeLeft.parent = rTreeRoot;
        if (rTreeRight != null)
            rTreeRight.parent = rTreeRoot;

        nRoot.left = lTreeRoot;
        nRoot.right = rTreeRoot;
        lTreeRoot.parent = nRoot;
        rTreeRoot.parent = nRoot;
    }


    protected void rotateLeft(Node<E> node) {
        Node<E> parent = node.right;
        Node<E> child = parent.left;
        node.right = parent.left;
        parent.left = node;
        afterRotate(node, parent, child);
    }

    protected void rotateRight(Node<E> node) {
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
    }
}
