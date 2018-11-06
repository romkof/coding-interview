package com.interview.graph.neighbours;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int value;
    private List<Node> neighbours;

    public Node(int value) {
        this.value = value;
        this.neighbours = new ArrayList<>();

    }

    public Node addNeighbours(Node neighbourNode) {
        this.neighbours.add(neighbourNode);
        return this;
    }

    public List getNeighbours() {
        return neighbours;
    }
}
