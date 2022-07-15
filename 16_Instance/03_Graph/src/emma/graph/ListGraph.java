package emma.graph;

import java.util.*;

public class ListGraph<V, E> implements Graph<V, E> {
    private Map<V, Vertex<V, E>> vertices = new HashMap<>();
    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public int edgesSize() {
        return 0;
    }

    @Override
    public void addVertex(V v) {
        if (vertices.containsKey(v)) return;
        vertices.put(v, new Vertex<>(v));
    }

    @Override
    public void addEdge(V from, V to) {
        addEdge(from, to, null);
    }

    @Override
    public void addEdge(V from, V to, E weight) {
        // 1. If from , to vertex existing or not
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) {
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }
        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) {
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }

        // 2. To check if Edges existing or not
//        if (fromVertex.outEdges.contains(edge)) return;
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex, weight);
//        fromVertex.outEdges.remove(edge);
//        toVertex.inEdges.remove(edge);
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
        }
        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
    }

    @Override
    public void removeVertex(V v) {

    }

    @Override
    public void removeEdge(V from, V to) {

    }

    private static class Vertex<V, E> {
        V value;
        Set<Edge<V, E>> inEdges = new HashSet<>();
        Set<Edge<V, E>> outEdges = new HashSet<>();

        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            Vertex<V, E> vertex = (Vertex<V, E>) obj;
            return Objects.equals(value, vertex.value);
        }

        @Override
        public int hashCode() {
            return value == null ? 0 : value.hashCode();
        }
    }

    private static class Edge<V, E> {
        E weight;
        Vertex<V, E> from;
        Vertex<V, E> to;

        public Edge(Vertex<V, E> from, Vertex<V, E> to, E weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object obj) {
            Edge<V, E> edge = (Edge<V, E>) obj;
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }
    }
}
