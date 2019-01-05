package com.owary.faora.algorithms.sorting.distributionsorts.radixsort;

import java.util.Arrays;

import static com.owary.faora.algorithms.sorting.distributionsorts.radixsort.RadixSort.radixSort;

public class RadixTest {

    public static void main(String[] args) {
        int[] a = {170,45,75,90,2,802,2,66};
        System.out.println(Arrays.toString(radixSort(a)));
    }

}
