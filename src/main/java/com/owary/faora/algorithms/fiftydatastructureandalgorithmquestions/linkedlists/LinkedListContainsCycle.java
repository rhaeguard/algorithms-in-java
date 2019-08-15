package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.linkedlists;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mensur Owary
 */
public class LinkedListContainsCycle {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Node n5 = new Node(5, null);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        n5.next = n5;

        Node cyclic = isCyclicUsingSet(n1);
        System.out.println(cyclic);
        System.out.println(isCyclicFloydsAlgorithm(n1));
    }

    private static Node isCyclicUsingSet (Node node) {
        Set<Node> set = new HashSet<>();
        while (node != null) {
            Node next = node.next;
            if (set.contains(next)) {
                return next;
            }
            set.add(node);
            node = next;
        }
        return null;
    }

    /**
     * Basic idea.
     * 2 pointers :
     *  - fastPtr moves by 2
     *  - slowPtr moves by 1
     *
     *  if they meet, then it is cyclic.
     *  if they don't, then it is not.
     */
    private static boolean isCyclicFloydsAlgorithm(Node node){
        Node slowPtr = node;
        Node fastPtr = node;
        while (fastPtr != null) {
            fastPtr = get2StepNextSafely(fastPtr);
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr) {
                return true;
            }
        }
        return false;
    }

    private static Node get2StepNextSafely (Node node) {
        try {
            return node.next.next;
        } catch (Exception ex) {
            return null;
        }
    }

}
