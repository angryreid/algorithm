package emma.map;

import java.util.Objects;

public class HashMap<K, V> implements Map<K, V> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    public static final int DEFAULT_CAPACITY = 1 << 5;
    private int size;
    private Node<K, V>[] table;
    
    public HashMap() {
        table = new Node[DEFAULT_CAPACITY];
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
        if (size == 0) return;
        size = 0;
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    @Override
    public V put(K key, V value) {
        int index = index(key); // hash code is not equals index.
        Node<K, V> root = table[index];
        if (root == null) {
            root = new Node<>(key, value, null);
            table[index] = root;
            size++;
            afterPut(root);
            return null;
        }
        // Hash Conflict, Need to add new Node to Red Black Tree
        // Add other node
        // find parent
        Node<K, V> parent = null;
        Node<K, V> node = root;

        // compere
        int compareRes = 0;
        int keyHash = key == null ? 0 : key.hashCode();
        do {
            compareRes = compare(key, node.key, keyHash, node.hash);
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
        } while (node != null);

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
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containValue(V value) {
        return false;
    }

    @Override
    public void traversal(Visitor visitor) {

    }

    private static class Node<K, V> {
        K key;
        V value;
        int hash;
        boolean color = RED;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;

        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.hash = key == null ? 0 : key.hashCode();
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

    /**
     * To get index value based on the inputting key
     * @param key
     * @return
     */
    private int index(K key) {
        if (key == null) return 0;
        int hash = key.hashCode();
        // ^ will use the high 16bit ^ with the low 16bit
        // & will limit the hash code smaller then table size
        return (hash ^ (hash >>> 16)) & (table.length - 1);
    }

    private int index(Node<K, V> node) {
        int hash = node.hash;
        return (hash ^ (hash >>> 16)) & (table.length - 1);
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

    private int compare(K key1, K key2, int hashKey1, int hashKey2) {
        int res = hashKey1 - hashKey2;
        if (res != 0) return res;

        if (Objects.equals(key1, key2)) return 0;
        // Same hash, diff equals
        if (key1 != null && key2 != null) {
            String key1ClsName = key1.getClass().getName();
            String key2ClsName = key2.getClass().getName();
            res = key1ClsName.compareTo(key2ClsName);
            if (res != 0) return res;
            // Same Class
            if (key1 instanceof Comparable) {
                return ((Comparable) key1).compareTo(key2);
            }
        }
        // One of two key is null.
        // Same hash, Same class, but can not be compared.
        return System.identityHashCode(key1) - System.identityHashCode(key2);
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
            table[index(node)] = parent;
        }
        if (child != null)
            child.parent = node;
        parent.parent = node.parent;
        node.parent = parent;
    }

    private Node<K, V> node(K key, Node<K, V> root) {
        Node<K, V> node = root;
        int keyHash = keyHash(key);
        while (node != null) {
            if (node.key.equals(key)) return node;
            int compareRes = compare(node.key, key, node.hash, keyHash);
            if (compareRes > 0)
                node = node.left;
            else
                node = node.right;
        }
        return null;
    }

    private int keyHash(K key) {
        return key == null ? 0 : key.hashCode();
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
}
