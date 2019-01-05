package com.owary.faora.algorithms.sorting.insertionsort;

public class InsertionSort {


    public static <T extends Comparable<T>> void insertionSort(T[] array){
        for (int i = 1; i < array.length; i++) {
            T x = array[i];
            int j = i-1;
            while(j>=0 && array[j].compareTo(x)>0){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = x;
        }
    }


}
