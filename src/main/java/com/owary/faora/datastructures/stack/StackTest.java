package com.owary.faora.datastructures.stack;

public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(4);
        stack.push("This");
        stack.push("is");
        stack.push("Sparta!");
        stack.push("Lea");

        if (stack.isFull()){
            System.out.println("Stack is full");
        }

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        if (stack.isEmpty()){
            System.out.println("Stack is empty");
        }

        System.out.println(stack.peek());

        System.out.println(stack);

        stack.pop();

        System.out.println("========\n"+stack);
        System.out.println(stack.peek());
    }

}
