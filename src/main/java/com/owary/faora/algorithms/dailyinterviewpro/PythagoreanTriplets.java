package com.owary.faora.algorithms.dailyinterviewpro;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mensur Owary
 *
 * Given a list of numbers, find if there exists a pythagorean triplet in that list. A pythagorean triplet is 3 variables a, b, c where a^2 + b^2 = c^2
 *
 * Example:
 * Input: [3, 5, 12, 5, 13]
 * Output: True
 * Here, 5^2 + 12^2 = 13^2.
 *
 * def findPythagoreanTriplets(nums):
 *   # Fill this in.
 *
 * print findPythagoreanTriplets([3, 12, 5, 13])
 * # True
 *
 */
public class PythagoreanTriplets {

    public static void main(String[] args) {
        int[] arr = {5, 9, 8, 12, 10, 13, 4, 3, 6};
        findAll(arr);
    }

    private static void findAll (int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                Integer companion = getCompanion(arr[i], arr[j]);
                if (companion != null && set.contains(companion)) {
                    System.out.printf("%d^2 + %d^2 = %d^2\n", arr[i], arr[j], companion);
                }
            }
        }
    }

    private static Integer getCompanion (int a, int b) {
        double c2 = a*a + b*b;
        double sqrt = Math.sqrt(c2);
        double floor = Math.floor(sqrt);
        return Double.compare(c2, floor *  floor) == 0 ? (int) sqrt : null;
    }

}
