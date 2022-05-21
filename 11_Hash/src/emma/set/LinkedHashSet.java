package emma.set;

import emma.map.HashMap;
import emma.map.Map;

public class LinkedHashSet<E> implements Set<E> {
    private Map<E, Object> map = new HashMap<>();
    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(E element) {
        return map.containsKey(element);
    }

    @Override
    public void add(E element) {
        map.put(element, null);
    }

    @Override
    public void remove(E element) {
        map.remove(element);
    }

    @Override
    public void traversal(Visitor visitor) {
        map.traversal(new Map.Visitor() {
            @Override
            public boolean visit(Object key, Object value) {
                return visitor.visit(key);
            }
        });
    }
}
