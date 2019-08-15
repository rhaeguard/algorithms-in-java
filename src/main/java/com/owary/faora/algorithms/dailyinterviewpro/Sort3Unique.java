package com.owary.faora.algorithms.dailyinterviewpro;

import java.util.*;

/**
 * @author Mensur Owary
 *
 * Given a list of numbers with only 3 unique numbers (1, 2, 3), sort the list in O(n) time.
 *
 * Example 1:
 * Input: [3, 3, 2, 1, 3, 2, 1]
 * Output: [1, 1, 2, 2, 3, 3, 3]
 *
 */
public class Sort3Unique {

    public static void main(String[] args) {
        int[] arr = {3, 3, 2, 1, 3, 2, 1};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }

    private static int[] sort (int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        // find count of each number
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.compute(num, (k, v) -> ++v);
            } else{
                map.put(num, 1);
            }
        }
        // find the max and min
        int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE;
        for (Integer num : map.keySet()) {
            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }
        }
        // there are 3 places : min mid max
        // we have min and max
        int[] temp = new int[3];
        temp[0] = min;
        temp[2] = max;
        // finding mid
        for (Integer num : map.keySet()) {
            if (num != max && num != min) {
                temp[1] = num;
            }
        }
        // result array
        int[] res = new int[arr.length];
        int ptr = 0;
        // go over the numbers and their occurrence counts
        // and elements according to their counts
        for (int num : temp) {
            for (int i = 0; i < map.get(num); i++) {
                res[ptr] = num;
                ptr++;
            }
        }

        return res;
    }
}
