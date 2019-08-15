package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.linkedlists;

/**
 * @author Mensur Owary
 */
public class ReverseLinkedListIterative {

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
     *  Basic idea...
     *
     *  We have :
     *  L =  1 -> 2 -> 3 -> 4 -> 5 -> NULL
     *
     *  We take 3 nodes at a time
     *  [1 -> 2 -> 3] -> 4 -> 5 -> NULL
     *
     *  and reverse the first 2 ===> [1 <- 2 -> 3] -> 4 -> 5 -> NULL
     *  then move the window.
     *
     *  1 <- [2 -> 3 -> 4] -> 5 -> NULL and do the same thing...
     *  until we reach NULL as our rightmost element in the window.
     */
    private static void reverse (Node head) {
        Node prev = head;
        Node curr = prev.next;
        Node next = curr.next;

        head.next = null;

        while(true) {
            curr.next = prev;

            prev = curr;
            curr = next;
            if (next == null) {
                break;
            }
            next = next.next;
        }
    }



}
