package emma.union;

public interface UF {
    int find(int v);
    void union(int v1, int v2);
    boolean isSame(int v1, int v2);
}
