package com.owary.faora.datastructures.queue;

public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);
        queue.enqueue(3);
        queue.enqueue(42);
        queue.enqueue(25);
        queue.enqueue(67);
        queue.enqueue(13);

        System.out.println(queue.contains(32));
    }


}
