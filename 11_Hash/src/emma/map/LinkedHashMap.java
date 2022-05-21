package emma.map;

import java.util.Objects;

public class LinkedHashMap<K, V> extends HashMap<K, V> {
    private LinkedNode<K, V> head;
    private LinkedNode<K, V> tail;
    private static class LinkedNode<K, V> extends Node<K, V> {
        LinkedNode<K, V> prev;
        LinkedNode<K, V> next;
        public LinkedNode(K key, V value, Node<K, V> parent) {
            super(key, value, parent);
        }
    }

    @Override
    protected Node<K, V> createNode(K key, V value, Node<K, V> parent) {
        LinkedNode<K, V> node = new LinkedNode<>(key, value, parent);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        return node;
    }

    @Override
    public void clear() {
        super.clear();
        head = tail = null;
    }

    @Override
    public void traversal(Visitor visitor) {
        if (visitor == null) return;
        LinkedNode<K, V> node = head;
        while (node != null) {
            if (visitor.visit(node.key, node.value)) return;
            node = node.next;
        }
    }

    @Override
    public boolean containValue(V value) {
        LinkedNode<K, V> node = head;
        while (node != null) {
            if (Objects.equals(value, node.value)) return true;
            node = node.next;
        }
        return false;
    }

    @Override
    protected void afterRemove(Node<K, V> node) {
        LinkedNode<K, V> linkedNode = (LinkedNode<K, V>)node;
        LinkedNode<K, V> prev = linkedNode.prev;
        LinkedNode<K, V> next = linkedNode.next;
        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
    }

    @Override
    protected void afterReplace(Node<K, V> node, Node<K, V> replaceNode) {
        LinkedNode<K, V> node1 = (LinkedNode<K, V>)node;
        LinkedNode<K, V> node2 = (LinkedNode<K, V>)replaceNode;
        // swap pre
        LinkedNode<K, V> tempPrev = node1.prev;
        node1.prev = node2.prev;
        node2.prev = tempPrev;
        if (node1.prev == null) {
            head = node1;
        } else {
            node1.prev.next = node1;
        }
        if (node2.prev == null) {
            head = node2;
        } else {
            node2.prev.next = node2;
        }
        // swap next

        LinkedNode<K, V> tempNext = node1.prev;
        node1.next = node2.next;
        node2.next = tempNext ;
        if (node1.next == null) {
            tail = node1;
        } else {
            node1.next.prev = node1;
        }
        if (node2.next == null) {
            tail = node2;
        } else {
            node2.next.prev = node2;
        }
    }
}
