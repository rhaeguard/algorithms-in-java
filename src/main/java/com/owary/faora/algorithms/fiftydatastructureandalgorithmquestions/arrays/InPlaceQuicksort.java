package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.arrays;

import java.util.Arrays;

/**
 * @author Mensur Owary
 */
public class InPlaceQuicksort {

    public static void main(String[] args) {
        int[] arr = {7, 10, 10, 4, 8};
        quicksort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quicksort (int[] arr, int s, int e) {
        if (s >= e) return;
        int pivot = arr[e];
        int until = e;
        for (int i = s; i < until; i++) {
            if (arr[i] > pivot) {
                int big = arr[i];
                for (int j = i; j < e; j++) {
                    arr[j] = arr[j+1];
                }
                arr[e] = big;
                until--;
                i--;
            }
        }
        quicksort(arr, s, until-1);
        quicksort(arr, until+1, e);
    }

}
