package emma.trie;

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
        return node == null ? null : node.value;
    }

    @Override
    public boolean contains(String key) {
        return node(key) != null;
    }

    @Override
    public V add(String key, V value) {
        keyCheck(key);
        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            char c = key.charAt(i);
            boolean emptyChildren = node.children == null;
            Node<V> childNode = emptyChildren ? null : node.children.get(c);
            if (childNode == null) {
                childNode = new Node<>(node);
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
    public V remove(String key) {
        return null;
    }

    @Override
    public boolean startsWith(String prefix) {
        return false;
    }

    private Node<V> node(String key) {
        keyCheck(key);
        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            char c = key.charAt(i);
            if (node.children == null) return null;
            node = node.children.get(c);
            if (node == null) return null;
        }
        return node.word ? node : null;
    }

    private void keyCheck(String key) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("Illegal key received");
        }
    }

    private static class Node<V> {
        HashMap<Character, Node<V>> children;
        Node<V> parent;
        boolean word;
        V value;
        public Node(Node<V> parent) {
            this.parent = parent;
        }
    }
}
