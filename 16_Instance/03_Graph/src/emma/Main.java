package emma;

import emma.graph.Graph;
import emma.graph.Graph.VertexVisitor;
import emma.graph.ListGraph;
import emma.model.Data;

import java.util.List;
import java.util.Objects;

public class Main {
    /**
     * directedGraph
     */
    private static Graph<Object, Double> directedGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>();
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
            }
        }
        return graph;
    }

    /**
     * undirectedGraph
     * @param data
     * @return
     */
    private static Graph<Object, Double> undirectedGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>();
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);
                graph.addEdge(edge[1], edge[0]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
                graph.addEdge(edge[1], edge[0], weight);
            }
        }
        return graph;
    }

    public static void test() {
        ListGraph<String, Integer> graph = new ListGraph<>();
        // Create Direction Weight Graph as asset png
        graph.addEdge("v1", "v0", 9);
        graph.addEdge("v1", "v2", 3);
        graph.addEdge("v2", "v0", 2);
        graph.addEdge("v0", "v4", 6);
        graph.addEdge("v3", "v4", 1);
        graph.addEdge("v2", "v3", 5);

//        graph.removeEdge("v0", "v4");
//        graph.removeVertex("v0");
//        graph.print();

        graph.bfs("v1", (String v) -> {
            System.out.println(v);
            return false;
        });
    }

    public static void testUndirectedBFS() {
        Graph graph = undirectedGraph(Data.BFS_01);
        graph.bfs("A", (Object v) -> {
            System.out.println(v);
            return false;
        });
        /**
         * A
         * B,F
         * C,I,G,E
         * D,H
         */
    }

    public static void testDirectedBFS() {
        Graph graph = directedGraph(Data.BFS_02);
//        graph.bfs(0);
//        graph.bfs(0, new VertexVisitor<Integer>() {
//
//            @Override
//            public boolean visit(Integer integer) {
//                System.out.println(integer);
//                return false;
//            }
//        });
        graph.bfs(0, (Object v) -> {
            System.out.println(v);
            return false;
        });
        /**
         * 0
         * 1,4
         * 2,6,7
         * 5
         * 3
         */
    }

    public static void testUndirectedDFS() {
        Graph graph = undirectedGraph(Data.DFS_01);
        graph.dfs(1, (Object v) -> {
            System.out.println(v);
            return false;
        });
        /**
         * 1
         * 2
         * 4
         * 3
         * 7
         * 5
         * 6
         * 0
         */
    }

    public static void testDirectedDFS() {
        ListGraph<Object, Double> graph = (ListGraph<Object, Double>)directedGraph(Data.DFS_02);
        graph.dfs("a", (Object v) -> {
            System.out.println(v);
            return false;
        });
        graph.dfs2("a");
        /**
         * a
         * b
         * e
         * f
         * c
         */
    }

    public static void testTopologicalSort() {
        Graph<Object, Double> graph = directedGraph(Data.TOPO);
        List<Object> list = graph.topologicalSort();
        System.out.println(list);
    }

    public static void main(String[] args) {
//        test();
//        testUndirectedBFS();
//        testDirectedBFS();
//        testUndirectedDFS();
//        testDirectedDFS();
        testTopologicalSort();
    }
}
