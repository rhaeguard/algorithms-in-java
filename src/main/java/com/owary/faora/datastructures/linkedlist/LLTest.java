package com.owary.faora.datastructures.linkedlist;

public class LLTest {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("This");
        list.add("is");
        list.add("a");
        list.add("better");
        list.add("implemented");
        list.add("Linked");
        list.add("List!");


        list.sort();
        list.insert("Third", 3);
        list.delete(0);

        list.print();
    }

}
