package com.owary.faora.datastructures.queue;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class Queue<T> {

    private T[] array;
    private int head;
    private int tail;


    public Queue(int size){
        this.array = (T[]) new Object[size];
        this.head=0;
        this.tail=0;
    }

    public void enqueue(T item){
        boolean res = true;
        if(tail==array.length){
            res = shift();
            if(!res){throw new RuntimeException("Queue Overflow");}
        }
        if(res){array[tail++]=item;}
    }

    public void enqueue(Collection<T> collection){
        collection.forEach(e->enqueue(e));
    }

    public T dequeue(){
        if(head==tail){
            throw new RuntimeException("Queue Underflow");
        }
        head++;
        return array[head-1];
    }

    public boolean contains(T item){
        return Stream.of(Arrays.copyOfRange(array, head, tail))
                .filter(el->el.equals(item))
                .count()>=1;
    }

    @Override
    public String toString(){
        return Stream.of(Arrays.copyOfRange(array, head, tail))
                .map(el->el.toString())
                .reduce("", (acc, el)->acc+el+"\n");
    }

    private boolean shift(){
        if(head==0){return false;}
        int diff = head;
        for (int i=0;i<array.length-diff;i++){
            array[i] = array[i+diff];
        }
        head=0;tail-=diff;
        return true;
    }

    public boolean isEmpty(){
        return this.tail==this.head;
    }

    public T[] getArray(){
        return this.array;
    }



}
