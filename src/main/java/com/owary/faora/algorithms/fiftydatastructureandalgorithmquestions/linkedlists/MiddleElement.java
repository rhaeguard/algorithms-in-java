package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.linkedlists;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mensur Owary
 */
public class MiddleElement {

    public static void main(String[] args) {
        int limit = 13;
        Node prev = new Node(limit, null);
        Node next = null;
        for (int i = limit-1; i > 0; i--) {
            next = new Node(i, prev);
            prev = next;
        }

        Node node = middleOnePassUsingMap(next);
        System.out.println(node);
        System.out.println(middleOnePassTwoPointers(next));
    }

    private static Node middleOnePassUsingMap (Node node) {
        int i = 0;
        Map<Integer, Node> map = new HashMap<>();
        while (node != null) {
            i++;
            map.put(i, node);
            node = node.next;
            // clear not needed elements from map.
            if (i % 2 != 0) {
                map.remove(((i + 1) / 2) - 1);
            }
        }
        return i % 2 == 0 ? null : map.get((i+1) / 2);
    }

    private static Node middleOnePassTwoPointers(Node node) {
        Node fastPtr = node;
        Node slowPtr = node;
        int i = 0;
        while (fastPtr != null) {
            i++;
            if (i % 2 != 0 && i != 1) {
                slowPtr = slowPtr.next;
            }
            fastPtr = fastPtr.next;
        }
        return slowPtr;
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
