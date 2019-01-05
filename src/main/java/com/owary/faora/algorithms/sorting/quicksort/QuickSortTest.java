package com.owary.faora.algorithms.sorting.quicksort;

import static com.owary.faora.algorithms.sorting.quicksort.QuickSort.quickInit;
import static com.owary.faora.utils.Utils.print;
import static com.owary.faora.utils.Utils.printArray;
import static com.owary.faora.utils.Utils.randomStringArray;

public class QuickSortTest {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{9, 2, 4, -8, 12, -78};
        print("Integer Sorting\n=================");
        printArray(arr, "Original");
        quickInit(arr);
        printArray(arr, "Sorted");

        String[] strarr = randomStringArray(15, 6);
        print("\nRandom String Sorting\n=================");
        printArray(strarr, "Original");
        quickInit(strarr);
        printArray(strarr, "Sorted");
    }


}
