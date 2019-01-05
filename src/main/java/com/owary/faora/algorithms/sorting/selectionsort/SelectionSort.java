package com.owary.faora.algorithms.sorting.selectionsort;

public class SelectionSort {

    public static <T extends Comparable<T>> void selectionSort(T[] array){
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[min].compareTo(array[j])>0){
                    min = j;
                }
            }
            // swapping
            if(i!=min) {
                T temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

}
