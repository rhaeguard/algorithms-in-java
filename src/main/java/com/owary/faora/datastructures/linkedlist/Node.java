package com.owary.faora.datastructures.linkedlist;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{

    private T value;
    private Node<T> next;
    private Node<T> prev;
    private boolean isSentinel=false;
    private boolean isLast=false;

    public Node(T item){
        value = item;
    }

    public Node(){value=null;}

    public Node<T> next(){
        return next;
    }

    public Node<T> prev(){
        return prev;
    }

    public void next(Node<T> next){
        this.next = next;
    }

    public void prev(Node<T> prev){
        this.prev = prev;
    }

    public boolean hasNext(){
        return !this.next().isLast();
    }

    public void makeSentinel(){isSentinel=true;}
    public void makeLast(){isLast=true;}

    public T value(){return this.value;}
    public void value(T value){this.value = value;}

    public boolean isLast(){return isLast;}
    public boolean isSentinel(){return isSentinel;}

    @Override
    public String toString(){return value.toString();}

    @Override
    public int compareTo(Node<T> o) {
        return this.value().compareTo(o.value());
    }
}
