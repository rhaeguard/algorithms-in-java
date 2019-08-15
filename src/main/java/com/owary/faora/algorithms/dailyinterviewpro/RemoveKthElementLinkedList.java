package com.owary.faora.algorithms.dailyinterviewpro;

/**
 *
 * You are given a singly linked list and an integer k.
 * Return the linked list, removing the k-th last element from the list.
 *
 * Try to do it in a single pass and using constant space.
 *
 * @author Mensur Owary
 */
public class RemoveKthElementLinkedList {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Node n10 = new Node(10, null);
        Node n9 = new Node(9, n10);
        Node n8 = new Node(8, n9);
        Node n7 = new Node(7, n8);
        Node n6 = new Node(6, n7);
        Node n5 = new Node(5, n6);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);

        Node node = removeKthLast(n1, 4);
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

    /**
     *
     * Basically the idea is to have 2 pointers
     * the first one travels one by one the entire linked list
     * the second one travels one by one as well, but starts after reaching k element.
     * So, when the first one reaches the end, the second one refers to the kth last element
     *
     * We also keep prevOfSlow pointer to save the previous element of slow pointer
     * Because we gotta delete the kth last element.
     *
     */
    private static Node removeKthLast (Node head, int k) {
        Node slow = head;
        Node prevOfSlow = null;
        Node fast = head;

        int counter = 0;

        while (fast != null) {
            if (counter > k) {
                prevOfSlow = slow;
                slow = slow.next;
            }
            fast = fast.next;
            counter++;
        }
        if (prevOfSlow != null) {
            prevOfSlow.next = slow.next;
            return head;
        }else{
            return head.next;
        }
    }

}
