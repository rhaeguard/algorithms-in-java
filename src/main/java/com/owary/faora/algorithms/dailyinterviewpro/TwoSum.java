package com.owary.faora.algorithms.dailyinterviewpro;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mensur Owary
 *
 *
 * You are given a list of numbers, and a target number k.
 * Return whether or not there are two numbers in the list that add up to k.
 *
 * Example:
 * Given [4, 7, 1 , -3, 2] and k = 5,
 * print all the pairs
 *
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, -9, -8, 3};
        int target = -7;

        twoSum(arr, target);
    }

    private static void twoSum(int[] arr, int target) {
        Set<Integer> complements = new HashSet<>();
        for (int num : arr) {
            int searched = target - num;

            if (complements.contains(num)) {
                System.out.println(num + " + " + searched + " = "+target);
            } else{
               complements.add(searched);
            }
        }
    }

}
