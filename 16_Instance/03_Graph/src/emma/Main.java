package emma;

import emma.graph.Graph;
import emma.graph.ListGraph;

public class Main {
    public static void main(String[] args) {
        ListGraph<String, Integer> graph = new ListGraph<>();
        // Create Direction Weight Graph as asset png
        graph.addEdge("v1", "v0", 9);
        graph.addEdge("v1", "v2", 3);
        graph.addEdge("v2", "v0", 2);
        graph.addEdge("v0", "v4", 6);
        graph.addEdge("v3", "v4", 1);
        graph.addEdge("v2", "v3", 5);
        graph.print();
    }
}
