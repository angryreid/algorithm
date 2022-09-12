package emma.graph;

public interface Graph<V, E>{
    int verticesSize();
    int edgesSize();

    void addVertex(V v);
    void addEdge(V from, V to);
    void addEdge(V from, V to, E weight);

    void removeVertex(V v);
    void removeEdge(V from, V to);

    void bfs(V begin, VertexVisitor<V> visitor);
    void dfs(V begin, VertexVisitor<V> visitor);

    interface VertexVisitor<V> {
        boolean visit(V v);
    }
}
