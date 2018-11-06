package com.interview.graph.adjacency.matrix;

public class GraphUtils {
    /**
     *         (1)
     *        /   \
     *       /     \
     *     (2)    (3)
     *     |  \     |
     *     |   \    |
     *     |    \   |
     *     |     \  |
     *    (4)-----(5)
     *      \     /
     *       \   /
     *        (6)
     *
     **/
    public static Graph simpleGraph() {
        Graph graph = new Graph(5);
        graph.addEdge(1,3);
        graph.addEdge(1,2);
        graph.addEdge(2,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,6);
        return null;
    }
}
