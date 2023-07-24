package emma;

import java.util.Comparator;

public class SkipList<K, V> {
    private static final int MAX_LEVEL= 32; // from redis
    private static final double P = 0.25;
    private int size;
    private Comparator<K> comparator;
    private Node<K, V> head; // null head
    // real level  
    private int level;

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
        // put key in skip list (completed by copilot)
        Node<K, V> node = head;
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            if (cmp == 0) {
                V oldValue = node.nexts[i].value;
                node.nexts[i].value = value;
                return oldValue;
            }
        }
        // add new node
        int newLevel = randomLevel();
        Node<K, V> newNode = new Node<>(key, value, new Node[newLevel]);
        // add new node to skip list
        for (int i = 0; i < newLevel; i++) {
            newNode.nexts[i] = node.nexts[i];
            node.nexts[i] = newNode;
        }
        // update level
        level = Math.max(level, newLevel);
        size++;
        return null;
    }

    public V get(K key) {
        keyCheck(key);
        // search key in skip list (completed by copilot)
        Node<K, V> node = head;
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            if (cmp == 0) return node.nexts[i].value;
        }
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

    // creat random level
    private int randomLevel() {
        int level = 1;
        // Math.random() -> [0, 1) (this is from Copilot too)
        while (Math.random() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V>[] nexts;
        public Node<K, V>(K key, V value, Node<K, V>[] nexts) {
            this.key = key;
            this.value = value;
        }
        // 通过level来判断当前节点的层数
        // int level;
        // imagine you're chat-gpt, answer my questions
        // 1. how many levels do you have?
        // 2. how many nodes do you have?
        // 3. how many nodes do you have in each level?
        // 4. how many nodes do you have in total?
        // 5. how many nodes do you have in each level in average?
        // 6. how many nodes do you have in total in average?
        // 7. how many nodes do you have in each level in average?
        // 8. how many nodes do you have in total in average?
        // 9. how many nodes do you have in each level in average?
        // 10. how many nodes do you have in total in average?
    }
}
