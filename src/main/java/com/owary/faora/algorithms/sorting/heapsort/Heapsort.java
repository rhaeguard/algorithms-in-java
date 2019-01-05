package com.owary.faora.algorithms.sorting.heapsort;

import com.owary.faora.datastructures.heap.MaxHeap;

public class Heapsort {

    public static double[] sort(double[] arr){
        MaxHeap heap = new MaxHeap(arr);
        for(int i=arr.length-1;i>0;i--){
            heap.swap(i, 0);
            heap.decrementSize();
            heap.maxHeapify(0);
        }
        return heap.getArray();
    }

}
