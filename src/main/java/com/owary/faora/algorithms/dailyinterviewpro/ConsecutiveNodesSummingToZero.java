package com.owary.faora.algorithms.dailyinterviewpro;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a linked list of integers, remove all consecutive nodes that sum up to 0.
 *
 * Example:
 * Input: 10 -> 5 -> -3 -> -3 -> 1 -> 4 -> -4
 * Output: 10
 *
 * The consecutive nodes 5 -> -3 -> -3 -> 1 sums up to 0 so that sequence should be removed.
 * 4 -> -4 also sums up to 0 too so that sequence should also be removed.
 *
 * @author Mensur Owary
 */
public class ConsecutiveNodesSummingToZero {

    public static void main(String[] args) {
//        int[] nums = {-4, 4, 1, -3, -3, 5, 10};
        int[] nums = {-4, 4, 5, 8, -5, -10, 10};

        Node prev = new Node(nums[0], null);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            prev = new Node(num, prev);
        }

        prev = sumZeroRemoval(prev);

        while (prev != null) {
            System.out.println(prev);
            prev = prev.next;
        }
    }

    /**
     *
     * Basic idea
     *
     * - Traverse the list and note each node value and its object (first encounter) in a map
     * - Starting from the start node, sum all the elements
     *      - when sum is a number which exists in the map, it means we have to delete the nodes in between the node in map[sum] and current one
     *      - when sum is zero, we just ignore the previous ones and continue from the next node as a head.
     *
     */
    private static Node sumZeroRemoval (Node node) {
        // pointer to the head
        Node head = node;

        // save nodes and their values
        Map<Integer, Node> cache = new HashMap<>();
        Node tmp = node;
        while (tmp != null) {
            cache.putIfAbsent(tmp.value, tmp);
            tmp = tmp.next;
        }

        // start summing up
        int sum = node.value;
        node = node.next;

        while (node != null) {
            sum += node.value;
            node = node.next;
            // if it is in the map, then delete in between nodes
            if (cache.containsKey(sum)) {
                Node start = cache.get(sum);
                start.next = node;
            // if it is empty, then declare the next node as a head
            } else if (sum == 0) {
                head = node;
            }
        }
        // return head
        return head;
    }

}
