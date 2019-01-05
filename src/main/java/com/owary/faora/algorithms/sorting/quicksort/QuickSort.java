package com.owary.faora.algorithms.sorting.quicksort;

import java.util.Random;

import static com.owary.faora.utils.Utils.swap;

public class QuickSort {

    public static <T extends Comparable<T>> void quickInit(T[] arr){
        quicksort(arr, 0, arr.length-1);
    }

    private static <T extends Comparable<T>> void quicksort(T[] arr, int st, int end){
        if(st<end){
            int q = randomPartition(arr, st, end);
            quicksort(arr, st, q-1);
            quicksort(arr, q+1, end);
        }
    }

    private static <T extends Comparable<T>> int randomPartition(T[] arr, int st, int end){
        int r = new Random().nextInt((end-st)+1)+st;
        swap(arr, r, end);
        return partition(arr, st, end);
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int st, int end) {
        T x = arr[end];
        int i=st;
        for (int j = st; j <= end-1; j++) {
            if(arr[j].compareTo(x)<=0){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }


}
