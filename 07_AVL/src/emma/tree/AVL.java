package emma.tree;

import java.util.Comparator;

public class AVL<E> extends BST<E> {
    public AVL() {this(null);}
    public AVL(Comparator<E> comparator) {
        super(comparator);
    }
}
