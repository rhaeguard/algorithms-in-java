package com.owary.faora.algorithms.sorting.insertionsort;

import java.util.Arrays;

import static com.owary.faora.algorithms.sorting.insertionsort.InsertionSort.insertionSort;

public class InsertionSortTest {

    public static void main(String[] args) {
        String[] strArr = "the quick brown fox jumps over lazy dog".split("\\s");
        System.out.println("Unsorted : \n" + Arrays.toString(strArr));
        insertionSort(strArr);
        System.out.println("Sorted : \n" + Arrays.toString(strArr));
    }

}
