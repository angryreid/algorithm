package emma.union;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UnionFind<V> {
    private Map<V, Node<V>> nodes = new HashMap<>();

    public void makeSet(V value) {
        if (nodes.containsKey(value)) return;
        nodes.put(value, new Node<>(value));
    }

    public V find(V value) {
        Node<V> node = findRootNode(value);
        return node == null ? null : node.value;
    }

    public void union(V value1, V value2) {
        Node<V> p1 = findRootNode(value1);
        Node<V> p2 = findRootNode(value2);
        if (p1 == null || p2 == null) return;
        if (Objects.equals(p1.value, p2.value)) return;
        if(p1.rank < p2.rank) {
            p1.parent = p2;
        } else if (p2.rank < p1.rank) {
            p2.parent = p1;
        } else {
            p1.parent = p2;
            p2.rank++;
        }
    }

    public boolean isSame(V value1, V value2) {
        return Objects.equals(find(value1), find(value2));
    }

    private Node<V> findRootNode(V value) {
        Node<V> node = nodes.get(value);
        if (node == null) return null;
        while (!Objects.equals(node.value, node.parent.value)) { // Use saved value to compare
            node.parent = node.parent.parent;
            node = node.parent;
        }
        return node;
    }

    private static class Node<V> {
        V value;
        Node<V> parent = this;
        int rank = 1;

        public Node(V value) {
            this.value = value;
        }
    }
}
