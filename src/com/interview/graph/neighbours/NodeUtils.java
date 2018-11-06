package com.interview.graph.neighbours;


public class NodeUtils {

    /**
     *         (1)
     *        /   \
     *       /     \
     *     (2)     (3)
     *     |  \     |
     *     |   \    |
     *     |    \   |
     *     |     \  |
     *    (4)-----(5)
     *      \      /
     *       \    /
     *        (6)
     *
     **/
    public static Node simpleGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.addNeighbours(node2).addNeighbours(node3);
        node2.addNeighbours(node4).addNeighbours(node5);
        node3.addNeighbours(node5);
        node4.addNeighbours(node4).addNeighbours(node6);
        node5.addNeighbours(node6);
        return null;
    }
}
