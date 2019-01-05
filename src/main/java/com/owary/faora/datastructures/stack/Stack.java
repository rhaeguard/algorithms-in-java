package com.owary.faora.datastructures.stack;

import java.util.Arrays;
import java.util.stream.Stream;

public class Stack<T> {

    private T[] array;
    private int top; // pointer to the top of the stack;

    public Stack(int size){
        this.top = 0;
        this.array = (T[])new Object[size];
    }

    public int push(T item){
        if(top < array.length) {
            array[top] = item;
        }else{
            throw new RuntimeException("Stack Overflow");
        }
        top++;
        return top;
    }

    public void pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack Underflow");
        }
        top--;
    }

    public T peek(){
        if(top>0){
            return array[top-1];
        }else{
            throw new RuntimeException("Stack is Empty!");
        }
    }

    public boolean isEmpty(){
        return top==0;
    }

    public boolean isFull(){
        return top == array.length;
    }

    private T[] increaseSize(T[] array) {
        T[] arr = (T[]) new Object[array.length*2];
        for (int i = 0; i < array.length; i++) {
            arr[i] = array[i];
        }
        return arr;
    }

    @Override
    public String toString(){
        return Stream.of(Arrays.copyOfRange(array, 0, top))
                .map(el->el.toString())
                .reduce("", (acc, el)->"\n"+el+acc)
                .substring(1);
    }

}
