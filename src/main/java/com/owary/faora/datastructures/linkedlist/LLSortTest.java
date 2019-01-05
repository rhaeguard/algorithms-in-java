package com.owary.faora.datastructures.linkedlist;

public class LLSortTest {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(100);
        list.add(-2);
        list.add(3);

        list.print();

        list.sort();

        list.print();
    }

}
