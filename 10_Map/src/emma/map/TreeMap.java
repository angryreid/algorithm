package emma.map;


import java.util.*;

public class TreeMap<K, V> implements Map<K, V> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private Comparator<K> comparator;

    public TreeMap() {
        this(null);
    }

    public TreeMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }


    private int size;
    private Node<K, V> root;
    
    private static class Node<K, V> {
        K key;
        V value;
        boolean color = RED;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;

        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean fullLeaf() {
            return left != null && right != null;
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }

        public Node<K, V> sibling() {
            if (isLeftChild()) {
                return parent.right;
            }

            if (isRightChild()) {
                return parent.left;
            }
            return null;
        }
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public V put(K key, V value) {
        checkKeyNull(key);

        if (root == null) { // first node
            root = new Node<>(key, value, null);
            size++;
            afterPut(root);
            return null;
        }

        // Add other node
        // find parent
        Node<K, V> parent = null;
        Node<K, V> node = root;

        // compere
        int compareRes = 0;
        while (node != null) {
            compareRes = compare(key, node.key);
            parent = node;
            if (compareRes > 0) {
                node = node.right;
            } else if (compareRes < 0) {
                node = node.left;
            } else { // equals
                V oldValue = node.value;
                node.value = value;// Cover
                return oldValue;
            }
        }

        // add to parent's left or right
        Node<K, V> newNode = new Node<>(key, value, parent);
        if (compareRes > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
        afterPut(newNode);
        return null;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = node(key);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        return remove(node(key));
    }

    @Override
    public boolean containsKey(K key) {
        return node(key) != null;
    }

    @Override
    public boolean containValue(V value) {
        if (root == null) return false;
        Queue<Node<K, V>> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() != 0) {
            Node<K, V> node = queue.poll();
            if (valEquals(node.value, value)) return true;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return false;
    }

    @Override
    public void traversal(Visitor visitor) {
        if (visitor == null) return;
        traversal(root, visitor);
    }

    public void traversal(Node<K, V> node, Visitor visitor) {
        if (node == null || visitor.stop) return;
        traversal(node.left, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.key, node.value);
        traversal(node.right, visitor);
    }

    private void checkKeyNull(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }
    }

    private void afterPut(Node<K, V> node) {
        Node<K, V> parent = node.parent;
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
        Node<K, V> uncle = parent.sibling();
        Node<K, V> grand = red(parent.parent);
        if (isRed(uncle)) { // overflow (4 case)
            black(parent);
            black(uncle);
            // Grand node recursevily handing
            afterPut(grand);
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

    /**
     *
     * @param el1
     * @param el2
     * @return 0 el1 == el2 > 0 el1 > el2 < 0 el1 < el2
     */
    private int compare(K el1, K el2) {//
        if (comparator != null) {
            return comparator.compare(el1, el2);
        }
        return ((Comparable<K>) el1).compareTo(el2);
    }

    private Node<K, V> coloring(Node<K, V> node, boolean color) {
        node.color = color;
        return node;
    }

    private Node<K, V> red(Node<K, V> node) {
        return coloring(node, RED);
    }

    private Node<K, V> black(Node<K, V> node) {
        return coloring(node, BLACK);
    }

    private boolean colorOf(Node<K, V> node) {
        return node == null ? BLACK : node.color;
    }

    private boolean isBlack(Node<K, V> node) {
        return colorOf(node) == BLACK;
    }

    private boolean isRed(Node<K, V> node) {
        return colorOf(node) == RED;
    }

    private void rotateLeft(Node<K, V> node) {
        Node<K, V> parent = node.right;
        Node<K, V> child = parent.left;
        node.right = child;
        parent.left = node;
        afterRotate(node, parent, child);
    }

    private void rotateRight(Node<K, V> node) {
        Node<K, V> parent = node.left;
        Node<K, V> child = parent.right;
        node.left = child;
        parent.right = node;
        afterRotate(node, parent, child);
    }

    private void afterRotate(Node<K, V> node, Node<K, V> parent, Node<K, V> child) {
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

    private Node<K, V> node(K key) {
        Node<K, V> node = root;
        while (node != null) {
            if (node.key.equals(key)) return node;
            int compareRes = compare(node.key, key);
            if (compareRes > 0)
                node = node.left;
            else
                node = node.right;
        }
        return null;
    }

    private V remove(Node<K, V> node) {
        if (node == null) return null;
        size--;

        V oldValue = node.value;
        if (node.fullLeaf()) { // Handing this case specially.
            Node<K, V> pre = predecessor(node);
            node.key = pre.key;
            node.value = pre.value;
            node = pre;// Binding the value to delete later.
        }

        // remove node.
        if (node.isLeaf()) { // remove leaf node case.
            if (node.parent == null) {
                root = null;
                afterRemove(node);
            } else {
                if (node == node.parent.left) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
                afterRemove(node);
            }
        } else { // remove one child case.
            Node<K, V> replaceNode = node.left != null ? node.left : node.right;
            replaceNode.parent = node.parent;
            if (node.parent == null) { // node is root and has only one child
                root = replaceNode;
            }else if (node == node.parent.left) {
                node.parent.left = replaceNode;
            } else {
                node.parent.right = replaceNode;
            }
            afterRemove(replaceNode);
        }
        return oldValue;
    }

    private void afterRemove(Node<K, V> node) {
//        if (isRed(node)) return; // Removed red node.can be combine with below case.

        if(isRed(node)) { // Replacement node
            black(node);
            return;
        }

        Node<K, V> parent = node.parent;
        // Remove root
        if (parent == null) return;

        // Remove black node. And this node must be leaf node.
        boolean left = parent.left == null || node.isLeftChild();
//        Node<E> sibling = node.sibling();
        Node<K, V> sibling = left ? parent.right : parent.left;
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

    private Node<K, V> predecessor(Node<K, V> node) {
        if (node == null) return null;
        Node<K, V> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }

    private Node<K, V> subdecessor(Node<K, V> node) {
        if (node == null) return null;
        Node<K, V> s = node.right;
        if (s != null) {
            while (s.left != null) {
                s = s.left;
            }
            return s;
        }
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    private boolean valEquals(V v1, V v2) {
//         return v1 == null ? v2 == null : v1.equals(v2);
        return Objects.equals(v1, v2);
    }
}
