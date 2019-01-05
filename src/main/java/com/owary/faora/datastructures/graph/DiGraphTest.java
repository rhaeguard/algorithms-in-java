package com.owary.faora.datastructures.graph;

import java.util.*;

public class DiGraphTest {

    public static void main(String[] args) {
        Vertex<Object> A = new Vertex<>("A");
        Vertex<Object> B = new Vertex<>("B");
        Vertex<Object> C = new Vertex<>("C");
        Vertex<Object> D = new Vertex<>("D");
        Vertex<Object> E = new Vertex<>("E");

        A.addNeighbor(B);A.addNeighbor(D);
        B.addNeighbor(C);
        C.addNeighbor(E);
        D.addNeighbor(C);D.addNeighbor(E);

        DirectedGraph dg = new DirectedGraph();
        dg.addVertice(A);
        dg.addVertice(B);
        dg.addVertice(C);
        dg.addVertice(D);
        dg.addVertice(E);

        List<List<Vertex>> ll = dg.breathFirstSearch(A);
        System.out.println(ll);
    }

}

