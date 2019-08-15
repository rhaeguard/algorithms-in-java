package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.arrays;

import java.util.Arrays;

import static com.owary.faora.utils.Utils.getRandomArrayOfSize;

/**
 * @author Mensur Owary
 */
public class LargestSmallestInUnsortedArray {

    public static void main(String[] args) {
        int[] array = getRandomArrayOfSize(20);
        int[] ints = smallestAndLargest(array);
        System.out.println("Arr : "+ Arrays.toString(array));
        System.out.println("Min : "+ints[0]);
        System.out.println("Max : "+ints[1]);
    }

    private static int[] smallestAndLargest (int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }

            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return new int[] {min, max};
    }
}
