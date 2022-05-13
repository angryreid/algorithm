package emma.set;

public interface Set<E> {
    int size();
    boolean isEmpty();
    void clear();
    boolean contains();
    void add();
    void remove();
    void traversal(Visitor visitor);
    
    public static abstract class Visitor<E> {
        boolean stop;
        abstract boolean visit(E element);
    }
}
