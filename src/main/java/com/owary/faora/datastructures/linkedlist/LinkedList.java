package com.owary.faora.datastructures.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable<T>>{

    Node<T> sentinel;
    Node<T> current;
    Node<T> last;
    private int size;

    public LinkedList(){
        sentinel = new Node<>();
        last = new Node<>();

        sentinel.makeSentinel();
        last.makeLast();

        sentinel.prev(last);
        last.next(sentinel);

        current = sentinel;

        size=0;
    }

    public void add(T item){
        Node<T> node = new Node<>(item);

        node.prev(current);
        node.next(last);

        node.prev().next(node);
        node.next().prev(node);

        current=node;
        size++;
    }

    public void insert(T item, int position){
        if(position>size){
            throw new RuntimeException("Position exceeds the current size");
        }
        Node<T> node = find(position);
        Node<T> newNode = new Node<T>(item);

        newNode.prev(node);
        newNode.next(node.next());

        node.next().prev(newNode);
        node.next(newNode);

        size++;
    }

    public void delete(int position){
        if(position<0 && position > size){throw new NoSuchElementException();}
        Node<T> node = find(position);
        node.prev().next(node.next());
        node.next().prev(node.prev());
        size--;
    }

    /*
        basically, it is a modified bubble sort.
        compares Nodes' values and swaps their values
     */
    public void sort(){
        Node<T> head = sentinel.next();
        Node<T> next = null;
        while (head.hasNext()){
            next = head.next();
            while (!next.isLast()){
                if(head.compareTo(next)>0){
                    T temp = head.value();
                    head.value(next.value());
                    next.value(temp);
                }
                next = next.next();
            }
            head = head.next();
        }
    }

    public Node<T> find(int position){
        Node<T> curNode = sentinel;
        int ctr = 1;
        if(position<=-1){return curNode;}
        else{
            while (ctr!=position){
                curNode = curNode.next();
                ctr++;
            }
            return curNode;
        }
    }

    public void print(){
        String str = "";
        Node<T> node = sentinel.next();
        while (!node.isLast()){
            str+=node+"\n";
            node = node.next();
        }
        System.out.println(str);
    }


}
