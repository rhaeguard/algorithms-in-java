package com.owary.faora.algorithms.sorting.distributionsorts.countingsort;

import java.util.Arrays;

import static com.owary.faora.algorithms.sorting.distributionsorts.countingsort.CountingSort.countingSort;

public class CountSortTest {

    public static void main(String[] args) {
        int[] arr = {8, 9, 5, 1, 0, 7, 15};
        arr = countingSort(arr, 16);
        System.out.println(Arrays.toString(arr));
    }

}
