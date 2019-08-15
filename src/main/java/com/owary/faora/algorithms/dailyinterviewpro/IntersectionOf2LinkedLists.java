package com.owary.faora.algorithms.dailyinterviewpro;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * You are given two singly linked lists. The lists intersect at some node. Find, and return the node. Note: the lists are non-cyclical.
 *
 * Example:
 *
 * A = 1 -> 2 -> 3 -> 4
 * B = 6 -> 3 -> 4
 *
 * This should return 3 (you may assume that any nodes with the same value are the same node).
 *
 * @author Mensur Owary
 */
public class IntersectionOf2LinkedLists {

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

        Node k4 = new Node(20, n6);
        Node k3 = new Node(20, k4);
        Node k2 = new Node(20, k3);
        Node k1 = new Node(20, k2);

        System.out.println(findIntersection(k1, n1));
        System.out.println(findIntersectionConstantSpace(k1, n1));
    }

    /**
     * Basic idea:
     *
     * Traverse 1st list, remember all the nodes
     * Traverse 2nd list, check if you seen any, if yes, then stop and return
     */
    private static Node findIntersection (Node list1, Node list2) {
        Set<Node> seen = new HashSet<>();
        while (list1 != null) {
            seen.add(list1);
            list1 = list1.next;
        }

        while (!seen.contains(list2)) {
            list2 = list2.next;
        }

        return list2;
    }

    /**
     *
     * Basic idea:
     *
     * Lists are in different length. But since they intersect and later on continue the same, it means, starting from the end, they share the same objects
     *
     * Next, we want to start checking from the same length, so what we do is:
     *
     * - find lengths of both lists
     * - find the difference between them
     * - move as much as the difference in the bigger list
     * - continue the same thing but for both lists in parallel and check if the nodes are the same.
     * - stop if they are.
     * - return null otherwise
     *
     */
    private static Node findIntersectionConstantSpace (Node list1, Node list2) {
        // list lengths
        int l1 = 0, l2 = 0;
        // not to lose the heads of the lists
        Node h1 = list1; Node h2 = list2;

        // measuring the list length
        while (h1 != null) {
            h1 = h1.next;
            l1++;
        }

        // measuring the list length
        while (h2 != null) {
            h2 = h2.next;
            l2++;
        }

        // big and small lists
        Node big, small;

        // set which one is bigger
        if (l1 > l2) {
            big = list1;
            small = list2;
        } else {
            big = list2;
            small = list1;
        }

        // find the difference
        int diff = Math.abs(l1 - l2);
        while (diff != 0) {
            big = big.next;
            diff--;
        }

        // parallel processing
        while (big != null) {
            // stop if equality has been found
            if (big.equals(small)) {
                return big;
            }
            big = big.next;
            small = small.next;
        }
        return null;
    }

}
