package emma.trie;

import java.util.Calendar;
import java.util.HashMap;

public class MyTrie<V> implements Trie<V> {
    private int size;
    private Node<V> root;
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
        size = 0;
        root = null;
    }

    @Override
    public V get(String key) {
        Node<V> node = node(key);
        return nodeIsWord(node) ? null : node.value;
    }

    @Override
    public boolean contains(String key) {
        Node<V> node = node(key);
        return nodeIsWord(node);
    }

    @Override
    public V add(String key, V value) {
        keyCheck(key);
        if(root == null) {
            root = new Node<>(null, null);
        }
        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            char c = key.charAt(i);
            boolean emptyChildren = node.children == null;
            Node<V> childNode = emptyChildren ? null : node.children.get(c);
            if (childNode == null) {
                childNode = new Node<>(node, c);
                node.children = emptyChildren ? new HashMap<>() : node.children;
                node.children.put(c, childNode);
            }
            node = childNode;
        }
        if (!node.word) { // Added a new word
            node.word = true;
            node.value = value;
            size++;
            return null;
        }

        V oldValue = node.value;
        node.value = value;
        return oldValue;
    }

    @Override
    public V remove(String key) { // remove word
        Node<V> node = node(key);
        if (node == null || !node.word) return null; // Not a word
        size--;
        V oldValue = node.value;
        if (node.children != null && !node.children.isEmpty()) { // Removing node has children.
            node.word = false;
            node.value = null;
            return oldValue;
        }

        // Removing node has no children.
        Node<V> parent = node.parent;
        while (parent != null) {
            parent.children.remove(node.c);
            if(parent.word || !parent.children.isEmpty()) break;// Parent has other children.
            // Parent has one child only.
            node = parent;
            parent = node.parent;
        }

//        Node<V> parent = null;
//        while ((parent = node.parent) != null) {
//            parent.children.remove(node.c);
//            if(parent.word || !parent.children.isEmpty()) break;// Parent has other children.
//            // Parent has one child only.
//            node = parent;
//        }
        return oldValue;
    }

    @Override
    public boolean startsWith(String prefix) {
        keyCheck(prefix);
        return node(prefix) != null;
    }

    private Node<V> node(String key) {
        keyCheck(key);
        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            if (node == null || node.children == null || node.children.isEmpty()) return null;
            char c = key.charAt(i);
            node = node.children.get(c);
        }
        return node;
    }

    private void keyCheck(String key) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("Illegal key received");
        }
    }

    private static class Node<V> {
        HashMap<Character, Node<V>> children;
        Node<V> parent;
        Character c;
        boolean word;
        V value;
        public Node(Node<V> parent, Character c) {
            this.parent = parent;
            this.c = c;
        }
    }

    private boolean nodeIsWord(Node<V> node) {
        return node != null && node.word;
    }
}
