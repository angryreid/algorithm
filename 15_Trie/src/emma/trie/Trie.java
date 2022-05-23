package emma.trie;

public interface Trie<V> {
    int size();
    boolean isEmpty();
    void clear();
    boolean contains(String str);
    V add(String str, V value);
    V remove(String str);
    boolean startsWith(String prefix);
}
