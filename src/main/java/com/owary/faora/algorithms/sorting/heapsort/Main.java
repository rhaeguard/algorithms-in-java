package com.owary.faora.algorithms.sorting.heapsort;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        double[] arr = new double[]{2, 1, 9, 3, -15, -7, 13, -22};
//        MinHeap mnHeap = new MinHeap(arr);
//        mnHeap.sort();
//        System.out.println(Arrays.toString(mnHeap.getArray()));
        System.out.println(Arrays.toString(Heapsort.sort(arr)));
    }

}
