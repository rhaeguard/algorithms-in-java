package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.linkedlists;

import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Mensur Owary
 */
public class DuplicateRemoval {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        LiNode n9 = new LiNode(9, null);
        LiNode n8 = new LiNode(3, n9);
        LiNode n7 = new LiNode(4, n8);
        LiNode n6 = new LiNode(2, n7);
        LiNode n5 = new LiNode(5, n6);
        LiNode n4 = new LiNode(4, n5);
        LiNode n3 = new LiNode(3, n4);
        LiNode n2 = new LiNode(2, n3);
        LiNode n1 = new LiNode(1, n2);

        removeDuplicates(n1);

        while (n1 != null) {
            System.out.println(n1);
            n1 = n1.next;
        }
    }

    private static void removeDuplicates (LiNode head) {
        Set<LiNode> cache = new HashSet<>();
        LiNode prev = null;
        while (head != null) {
            if (cache.contains(head)) {
                prev.next = head.next;
            } else {
                cache.add(head);
                prev = head;
            }
            head = head.next;
        }
    }
}

@AllArgsConstructor
class LiNode {

    public int value;
    public LiNode next;

    @Override
    public String toString() {
        return "["+value+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LiNode)) return false;
        LiNode liNode = (LiNode) o;
        return value == liNode.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
