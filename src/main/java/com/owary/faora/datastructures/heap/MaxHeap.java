package com.owary.faora.datastructures.heap;

import java.util.Arrays;

public class MaxHeap {

    private int size;
    private double[] arr;

    public MaxHeap(double[] arr){
        this.arr = arr;
        this.size = arr.length;
        this.buildMaxHeap();
    }

    public double max(){return arr[0];}

    public double extractMax(){
        if(size==0){
            throw new RuntimeException("Heap Underflow!");
        }
        double max = arr[0];
        swap(0, arr.length-1);
        arr = Arrays.copyOfRange(arr, 0, arr.length-1);
        size--;
        maxHeapify(0);
        return max;
    }

    public void sort(){
        for(int i=arr.length-1;i>0;i--){
            swap(i, 0);
            this.size--;
            maxHeapify(0);
        }
    }

    public void buildMaxHeap(){
        for(int i=arr.length/2;i>=0;i--){
            maxHeapify(i);
        }
    }

    public void maxHeapify(int i){
        int l = left(i);
        int r = right(i);
        int largest;
        if(l < size && arr[l] > arr[i]){
            largest = l;
        }else{
            largest = i;
        }
        if(r < size && arr[largest]<arr[r]){
            largest = r;
        }
        if(largest!=i){
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    private int left(int i){
        return 2*i+1;
    }

    private int right(int i){
        return 2*i+2;
    }

    public void swap(int i, int j){
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for heapsort in Heapsort class
    public void decrementSize(){
        size--;
    }

    public double[] getArray(){
        return arr;
    }

}
