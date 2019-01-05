package com.owary.faora.datastructures.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Vertex<T> {

    private String label;
    private boolean isVisited;
    private Vertex parent;

    private List<Vertex<T>> neighbours;

    private T data;

    public Vertex(String label){
        this.label = label;
        this.isVisited = false;
        this.neighbours = new LinkedList<>();
    }

    public void addNeighbor(Vertex v){
        this.neighbours.add(v);
    }

    public List<Vertex<T>> getNeighbours(){
        return this.neighbours;
    }

    public void isVisited(){this.isVisited=true;}
    public boolean visited(){return this.isVisited;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return this.label==vertex.label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "(" +
                "label='" + label + '\'' +
//                ", isVisited=" + isVisited +
                ')';
    }

    public String label(){
        return this.label;
    }
}
