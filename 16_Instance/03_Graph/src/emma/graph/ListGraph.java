package emma.graph;

import emma.heap.MinHeap;
import emma.union.UnionFind;


import java.nio.file.Path;
import java.util.*;

public class ListGraph<V, E> extends Graph<V, E> {
    private Map<V, Vertex<V, E>> vertices = new HashMap<>();
    private Set<Edge<V, E>> edges = new HashSet<>();
    private Comparator<Edge<V, E>> edgeComparator = (Edge<V, E> e1, Edge<V, E> e2) -> {
        return weightManager.compare(e1.weight, e2.weight);
    };

    public ListGraph() {
        super();
    }

    public ListGraph(WeightManager<E> weightManager) {
        super(weightManager);
    }

    public void print() {
        vertices.forEach((V key, Vertex<V, E> vertex) -> {
            System.out.println("====================================");
            System.out.println("Vertex:" + key);
            System.out.println("In Edges:");
            System.out.println(vertex.inEdges);
            System.out.println("Out Edges:");
            System.out.println(vertex.outEdges);
            System.out.println("====================================");
        });

        edges.forEach((Edge<V, E> edge) -> {
            System.out.println(edge);
        });
    }

    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public int edgesSize() {
        return edges.size();
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
            edges.remove(edge);
        }
        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    @Override
    public void removeVertex(V v) {
        Vertex<V, E> vertex = vertices.remove(v); // Remove vertex and return removed value
        if (vertex == null) return;

        for (Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator(); iterator.hasNext(); ) {
            Edge<V, E> edge = iterator.next();
            edge.to.inEdges.remove(edge);
            iterator.remove();// remove current element from current collection loop
            edges.remove(edge);
        }

        for (Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator(); iterator.hasNext(); ) {
            Edge<V, E> edge = iterator.next();
            edge.from.outEdges.remove(edge);
            iterator.remove();// remove current element from current collection loop
            edges.remove(edge);
        }
    }

    @Override
    public void removeEdge(V from, V to) {
        Vertex<V, E> fromVertex = vertices.get(from);
        Vertex<V, E> toVertex = vertices.get(to);
        if (fromVertex == null || toVertex == null) return;

        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
    }

    @Override
    public void bfs(V begin, VertexVisitor<V> visitor) {
        if (visitor == null) return;
        Vertex<V, E> headVertex = vertices.get(begin);
        if (headVertex == null) return;

        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        queue.offer(headVertex);
        visitedVertices.add(headVertex);

        while (!queue.isEmpty()) {
            Vertex<V, E> vertex = queue.poll(); // From the head
            if (visitor.visit(vertex.value)) return;

            for (Edge<V, E> edge : vertex.outEdges) {
                if (!visitedVertices.contains(edge.to)) {
                    queue.offer(edge.to);
                    visitedVertices.add(edge.to);
                }
            }
        }
    }

    @Override
    public void dfs(V begin, VertexVisitor<V> visitor) {
        if (visitor == null) return;
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
        Stack<Vertex<V, E>> stack = new Stack<>();

        stack.push(beginVertex);
        visitedVertices.add(beginVertex);
        if (visitor.visit(beginVertex.value)) return;
        System.out.println(begin);

        while (!stack.isEmpty()) {
            Vertex<V, E> vertex = stack.pop();// From the tail
            for (Edge<V, E> edge : vertex.outEdges) {
                if (visitedVertices.contains(edge.to)) continue;
                stack.push(edge.from);
                stack.push(edge.to);
                visitedVertices.add(edge.to);
                if (visitor.visit(edge.to.value)) return;
                break;
            }
        }
    }

    @Override
    public Set<EdgeInfo<V, E>> mst() {
//        return prim();
        return kruskal();
    }

    public Set<EdgeInfo<V, E>> prim() {
        Iterator<Vertex<V, E>> iterator = vertices.values().iterator();
        if (!iterator.hasNext()) return null;

        Vertex<V, E> vertex = iterator.next();

        Set<EdgeInfo<V, E>> edgeInfos = new HashSet<>();
        Set<Vertex<V, E>> addedVertices = new HashSet<>();

        addedVertices.add(vertex);
        MinHeap<Edge<V, E>> heap = new MinHeap<>(vertex.outEdges, edgeComparator);
        int edgeSize = vertices.size() - 1;
        while (!heap.isEmpty() && edgeInfos.size() < edgeSize) {
            Edge<V, E> edge = heap.remove();
            if (addedVertices.contains(edge.to)) continue;
            edgeInfos.add(edge.info());
            addedVertices.add(edge.to);
            heap.addAll(edge.to.outEdges);
        }
        return edgeInfos;
    }

    public Set<EdgeInfo<V, E>> kruskal() { // E * O(logE)
        int edgeSize = vertices.size() - 1;
        if (edgeSize <= 1) return null;

        Set<EdgeInfo<V, E>> edgeInfos = new HashSet<>();
        // O(E)
        MinHeap<Edge<V, E>> heap = new MinHeap<>(edges, edgeComparator);
        UnionFind<Vertex<V, E>> uf = new UnionFind<>(); // Can not to use addedVertices Set to store due to multiple Set existing possible
        // O(V)
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            uf.makeSet(vertex);
        });

        // E * O(logE)
        while (!heap.isEmpty() && edgeInfos.size() < edgeSize) { // O(E)
            Edge<V, E> edge = heap.remove();// O(logE)
            if (uf.isSame(edge.from, edge.to)) continue;// // O(1)
            edgeInfos.add(edge.info()); // O(1)
            uf.union(edge.from, edge.to);// // O(1)
        }
        return edgeInfos;
    }

    public void dfs2(V begin) {
        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
        Set<Vertex<V, E>> addedVertices = new HashSet<>();
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex != null)
            dfs2(beginVertex, visitedVertices);
    }

    public void dfs2(Vertex<V, E> vertex, Set<Vertex<V, E>> visitedVertices) {
        visitedVertices.add(vertex);
        System.out.println(vertex.value);
        for (Edge<V, E> edge : vertex.outEdges) {
            if (!visitedVertices.contains(edge.to))
                dfs2(edge.to, visitedVertices);
        }
    }

    @Override
    public List<V> topologicalSort() {
        List<V> list = new ArrayList<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        Map<Vertex<V, E>, Integer> ins = new HashMap<>();
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            int in = vertex.inEdges.size();
            if (in == 0) {
                queue.offer(vertex);
            } else {
                ins.put(vertex, in);
            }
        });

        while (!queue.isEmpty()) {
            Vertex<V, E> vertex = queue.poll();
            list.add(vertex.value);
            for (Edge<V, E> edge : vertex.outEdges) {
                int inEdgesSize = ins.get(edge.to) - 1;
                if (inEdgesSize == 0) {
                    queue.offer(edge.to);
                } else {
                    ins.put(edge.to, inEdgesSize);
                }
            }
        }
        return list;
    }

    @Override
    public Map<V, PathInfo<V, E>> shortestPath(V begin) {
        return dijkstra(begin);
//        return bellmanFord(begin);
    }

    @Override
    public Map<V, Map<V, PathInfo<V, E>>> allShortestPath() {
        return floyd();
    }

    private Map<V, Map<V, PathInfo<V, E>>> floyd() {
        Map<V, Map<V, PathInfo<V, E>>> paths = new HashMap<>();

        // Initial value
        for (Edge<V, E> edge : edges) {
            Map<V, PathInfo<V, E>> map = paths.get(edge.from.value);
            if (map == null) {
                map = new HashMap<>();
                paths.put(edge.from.value, map);
            }

            PathInfo<V, E> pathInfo = new PathInfo<>(edge.weight);
            pathInfo.edgeInfos.add(edge.info());
            map.put(edge.to.value, pathInfo);
        }

        // (from -> mid) + D(mid -> end) < D(from -> end)
        vertices.forEach((V mid, Vertex<V, E> midVertex) -> {
            vertices.forEach((V from, Vertex<V, E> fromVertex) -> {
                vertices.forEach((V end, Vertex<V, E> endVertex) -> {
                    if (from.equals(mid) || mid.equals(end) || from.equals(end)) return;
                    // from -> mid
                    PathInfo<V, E> fromToMid = getPathInfo(from, mid, paths);
                    if (fromToMid == null) return;
                    // mid -> end
                    PathInfo<V, E> midToEnd = getPathInfo(mid, end, paths);
                    if (midToEnd == null) return;
                    // from -> end
                    PathInfo<V, E> fromToEnd = getPathInfo(from, end, paths);
                    E newWeight = weightManager.add(fromToMid.weight, midToEnd.weight);
                    if (fromToEnd != null && weightManager.compare(newWeight, fromToEnd.weight) >= 0) return;
                    if (fromToEnd == null) {
                        fromToEnd = new PathInfo<>();
                        paths.get(from).put(end, fromToEnd); // Put & Update
                    } else {
                        fromToEnd.edgeInfos.clear();
                    }

                    fromToEnd.weight = newWeight;
                    fromToEnd.edgeInfos.addAll(fromToMid.edgeInfos);
                    fromToEnd.edgeInfos.addAll(midToEnd.edgeInfos);

                });
            });
        });
        return paths;
    }

    private PathInfo<V, E> getPathInfo(V from, V end, Map<V, Map<V, PathInfo<V, E>>> paths) {
        Map<V, PathInfo<V, E>> map = paths.get(from);
        return map == null ? null : map.get(end);
    }

    private Map<V, PathInfo<V, E>> bellmanFord(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return null;

        Map<V, PathInfo<V, E>> selectedPaths = new HashMap<>();
        selectedPaths.put(begin, new PathInfo<>(weightManager.zero()));

        int count = vertices.size() - 1;
        for (int i = 0; i < count; i++) {
            for (Edge<V, E> edge : edges) {
                PathInfo<V, E> fromPath = selectedPaths.get(edge.from.value);
                if (fromPath == null) continue;
                relaxBellmanFord(edge, fromPath, selectedPaths);
            }
        }

        for (Edge<V, E> edge : edges) {
            PathInfo<V, E> fromPath = selectedPaths.get(edge.from.value);
            if (fromPath == null) continue;
            if (relaxBellmanFord(edge, fromPath, selectedPaths)) {
                System.out.println("Negative Cycle detected.");
                return null;
            }
            ;
        }
        selectedPaths.remove(begin);
        return selectedPaths;
    }

    private boolean relaxBellmanFord(Edge<V, E> edge, PathInfo<V, E> fromPath, Map<V, PathInfo<V, E>> paths) {
        // beginVertex -> edge.to
        E newWeight = weightManager.add(fromPath.weight, edge.weight);
        // beginVertex -> edge.from + edge.weight
//         E oldWeight = paths.get(edge.to).weight;

        PathInfo<V, E> oldPath = paths.get(edge.to.value);
        if (oldPath != null && weightManager.compare(newWeight, oldPath.weight) >= 0) return false;
        if (oldPath == null) {
            oldPath = new PathInfo<>();
            paths.put(edge.to.value, oldPath);
        } else {
            oldPath.edgeInfos.clear();
        }

        oldPath.weight = newWeight;
        oldPath.edgeInfos.addAll(fromPath.edgeInfos);
        oldPath.edgeInfos.add(edge.info());
        return true;
    }

    /**
     *
     */
    private Map<V, PathInfo<V, E>> dijkstra(V begin) { // O(V^2 + E)
        Vertex<V, E> beginVertex = vertices.get(begin); // 
        if (beginVertex == null) return null;// 

        Map<V, PathInfo<V, E>> selectedPaths = new HashMap<>();
        Map<Vertex<V, E>, PathInfo<V, E>> paths = new HashMap<>();

        paths.put(beginVertex, new PathInfo<>(weightManager.zero()));

        // Enhancement
//        for (Edge<V, E> edge : beginVertex.outEdges) {
//            PathInfo<V, E> path = new PathInfo<>();
//            path.weight = edge.weight;
//            path.edgeInfos.add(edge.info());
//            paths.put(edge.to, path);
//        }

        while (!paths.isEmpty()) {
            Map.Entry<Vertex<V, E>, PathInfo<V, E>> minEntry = getMinPath(paths);
            Vertex<V, E> minVertex = minEntry.getKey();
            PathInfo<V, E> minPath = minEntry.getValue();
            selectedPaths.put(minVertex.value, minPath);
            paths.remove(minVertex);
            for (Edge<V, E> edge : minVertex.outEdges) {
                // filter undirected edge.to
                if (selectedPaths.containsKey(edge.to.value)) continue;
                relaxDijkstra(edge, minPath, paths);
            }
        }

        selectedPaths.remove(begin);
        return selectedPaths;
    }

/**
 * 
 */
    private void relaxDijkstra(Edge<V, E> edge, PathInfo<V, E> fromPath, Map<Vertex<V, E>, PathInfo<V, E>> paths) {
        // beginVertex -> edge.to
        E newWeight = weightManager.add(fromPath.weight, edge.weight);
        // beginVertex -> edge.from + edge.weight
//         E oldWeight = paths.get(edge.to).weight;

        PathInfo<V, E> oldPath = paths.get(edge.to);
        if (oldPath != null && weightManager.compare(newWeight, oldPath.weight) >= 0) return;
        if (oldPath == null) {
            oldPath = new PathInfo<>();
            paths.put(edge.to, oldPath);
        } else {
            oldPath.edgeInfos.clear();
        }

        oldPath.weight = newWeight;
        oldPath.edgeInfos.addAll(fromPath.edgeInfos);
        oldPath.edgeInfos.add(edge.info());
    }

    private Map.Entry<Vertex<V, E>, PathInfo<V, E>> getMinPath(Map<Vertex<V, E>, PathInfo<V, E>> paths) {
        Iterator<Map.Entry<Vertex<V, E>, PathInfo<V, E>>> it = paths.entrySet().iterator();
        Map.Entry<Vertex<V, E>, PathInfo<V, E>> minEntry = it.next();
        while (it.hasNext()) {
            Map.Entry<Vertex<V, E>, PathInfo<V, E>> entry = it.next();
            if (weightManager.compare(entry.getValue().weight, minEntry.getValue().weight) < 0) { // entry < minEntry
                minEntry = entry;
            }
        }
        return minEntry;
    }

    private static class Vertex<V, E> {
        V value;
        Set<Edge<V, E>> inEdges = new HashSet<>();
        Set<Edge<V, E>> outEdges = new HashSet<>();

        Vertex(V value) {
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

        @Override
        public String toString() {
            return value == null ? "null" : value.toString();
        }
    }

    private static class Edge<V, E> {
        E weight;
        Vertex<V, E> from;
        Vertex<V, E> to;

        Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }

        Edge(Vertex<V, E> from, Vertex<V, E> to, E weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        EdgeInfo<V, E> info() {
            return new EdgeInfo<>(from.value, to.value, weight);
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

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", from=" + from +
                    ", to=" + to +
                    '}';
        }
    }
}
