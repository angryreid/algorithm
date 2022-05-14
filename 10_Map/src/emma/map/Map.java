package emma.map;

public interface Map<K ,V> {
    int size();
    boolean isEmpty();
    void clear();
    V put(K key, V value);
    V get(K key);
    V remove(K key);

    boolean containsKey(K key);
    boolean containValue(V value);
    void traversal(Visitor visitor);

    abstract class Visitor<K, V> {
        boolean stop;
        public abstract boolean visit(K key, V value);
    }


}
