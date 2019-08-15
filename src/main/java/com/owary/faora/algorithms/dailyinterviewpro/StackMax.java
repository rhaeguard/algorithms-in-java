package com.owary.faora.algorithms.dailyinterviewpro;

/**
 * @author Mensur Owary
 *
 * Implement a class for a stack that supports all the regular functions (push, pop) and
 * an additional function of max() which returns the maximum element in the stack
 * (return None if the stack is empty). Each method should run in constant time.
 */
public class StackMax {

    public static void main(String[] args) {
        MaxStack s = new MaxStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(2);
        System.out.println(s.max()); //3
        s.pop();
        s.pop();
        System.out.println(s.max()); //2
    }
}

class MaxStack {
    private int[] data;
    private int[] maxima;

    private int top;
    private int ptrMax;

    MaxStack() {
        this.data = new int[100];
        this.maxima = new int[100];
        this.top = 0;
        this.ptrMax = 0;
    }

    void push(int num) {
        if (num >= 100) {throw new IllegalStateException("Cannot push to a full stack");}
        data[top] = num;
        top++;

        if (ptrMax == 0 || num > maxima[ptrMax-1]) {
            maxima[ptrMax] = num;
            ptrMax++;
        }
    }

    int pop() {
        if (top == 0) {throw new IllegalStateException("Cannot pop from an empty stack");}
        if (maxima[ptrMax-1] == data[top-1]) {
            ptrMax--;
        }
        top--;
        return data[top+1];
    }

    public int max () {
        if (ptrMax == 0) throw new IllegalStateException("Stack is empty");
        return maxima[ptrMax-1];
    }
}
