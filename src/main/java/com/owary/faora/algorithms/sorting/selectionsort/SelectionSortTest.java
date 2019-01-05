package com.owary.faora.algorithms.sorting.selectionsort;

import java.util.Arrays;

import static com.owary.faora.algorithms.sorting.selectionsort.SelectionSort.selectionSort;


public class SelectionSortTest {

    public static void main(String[] args) {
        String[] strArr = "the quick brown fox jumps over lazy dog".split("\\s");
        System.out.println("Unsorted : \n" + Arrays.toString(strArr));
        selectionSort(strArr);
        System.out.println("Sorted : \n" + Arrays.toString(strArr));
    }


}
