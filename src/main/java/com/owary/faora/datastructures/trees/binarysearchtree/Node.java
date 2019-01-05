package com.owary.faora.datastructures.trees.binarysearchtree;

import java.util.Objects;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private T data;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    private boolean isRoot;

    public Node(T data){
        this.data = data;
    }

    public void parent(Node<T> node){this.parent=node;}
    public void left(Node<T> node){this.left=node;}
    public void right(Node<T> node){this.right=node;}

    public Node<T> parent(){return this.parent;}
    public Node<T> left(){return this.left;}
    public Node<T> right(){return this.right;}

    public void makeRoot(){this.isRoot=true;}
    public boolean isRoot() {return isRoot;}

    public T data(){return this.data;}

    @Override
    public int compareTo(Node<T> o) {
        return this.data().compareTo(o.data());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node<?> node = (Node<?>) o;
        return isRoot() == node.isRoot() &&
                Objects.equals(data, node.data) &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right) &&
                Objects.equals(parent, node.parent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data, left, right, parent, isRoot());
    }

    @Override
    public String toString(){
        return data.toString();
    }
}
