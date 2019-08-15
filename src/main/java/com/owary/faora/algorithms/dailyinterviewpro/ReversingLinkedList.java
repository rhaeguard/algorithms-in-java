package com.owary.faora.algorithms.dailyinterviewpro;

import lombok.AllArgsConstructor;

/**
 * @author Mensur Owary
 */
public class ReversingLinkedList {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Node n5 = new Node(5, null);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);

        reverse(n1);
        Node node = n5;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**
     * Basic logic.
     *
     * Suppose we have a Linked List A : L1 -> L2 -> L3 -> L4 -> L5 -> null
     *
     * The reverse of this linked list will be : reverse of L2 -> L3 -> L4 -> L5  ===> L1 -> null
     *
     */
    private static Node reverse(Node head) {
        if (head.next == null) {
            return head;
        }else{
            Node rest = reverse(head.next);
            rest.next = head;
            head.next = null;
            return head;
        }
    }

}

@AllArgsConstructor
class Node {

    public int value;
    public Node next;

    @Override
    public String toString() {
        return "["+value+"]";
    }
}
