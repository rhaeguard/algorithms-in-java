package com.owary.faora.algorithms.sorting.distributionsorts.countingsort;

public class CountingSort {

    public static int[] countingSort(int[] arr, int k){
        // c array will count how the number of each element and store it in corresponding index
        // k is the threshold
        int[] c = new int[k];
        for(int i : arr){
            c[i]++;
        }
        // then we'll do accumulation that is sum each contiguous array member iteratively
        // and we'll shift the end result by 1 element to the right and the 0th element will be 0
        // here we do shift and accumulation altogether
        int[] shift = new int[k];
        for (int i = 0; i < c.length-1; i++) {
            // shift the accumulated value by 1 index
            shift[i+1] = shift[i]+c[i];
        }
        // result array of size of the input size
        int[] result = new int[arr.length];
        for (int i : arr){
            // since in shift array index and value correspond to the actual value and its start
            // index in the final array respectively
            // then we save the result and increment the value by 1
            result[shift[i]] = i;
            shift[i]++;
        }
        return result;
    }




}
