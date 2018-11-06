package com.interview.graph.adjacency.matrix;

import java.util.LinkedList;
import java.util.List;

class Graph {
    private int V;   
    private List<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }
}

