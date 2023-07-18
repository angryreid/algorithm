package emma;

import java.util.Comparator;

public class SkipList<K, V> {
    private static final int MAX_LEVEL= 32;
    private int size;
    private Comparator<K> comparator;
    private Node<K, V> head; // null head

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        head = new Node<>();
        head.nexts = new Node[MAX_LEVEL];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V put(K key, V value) {
        keyCheck(key);
        return null;
    }

    public V get(K key) {
        keyCheck(key);
        return null;
    }

    public V remove(K key) {
        keyCheck(key);
        return null;
    }

    private void keyCheck(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }
    }

    private int compare(K k1, K k2) {
        return comparator != null ? comparator.compare(k1, k2) : ((Comparable<K>)k1).compareTo(k2);
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V>[] nexts;
    }
}
