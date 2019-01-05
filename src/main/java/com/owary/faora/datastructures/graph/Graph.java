package com.owary.faora.datastructures.graph;

import java.util.List;

public interface Graph {

    void addVertice(Vertex v);
    List<List<Vertex>> breathFirstSearch(Vertex start);
    void depthFirstSearch(Vertex start);

}
