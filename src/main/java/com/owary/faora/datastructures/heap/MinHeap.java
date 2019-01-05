package com.owary.faora.datastructures.heap;

public class MinHeap {
    public int size;
    private double[] arr;

    public MinHeap(double[] arr){
        this.arr = arr;
        this.size = arr.length;
        this.buildMinHeap();
    }

    // Modified, so that it won't return reverse sorted array
    public void sort(){
        double[] tmp = new double[size];
        int j = 1;
        tmp[0] = arr[0];
        for(int i=arr.length-1;i>0;i--){
            swap(i, 0);
            this.size--;
            minHeapify(0);
            tmp[j] = arr[0];
            j++;
        }
        arr = tmp;
        size = arr.length;
    }

    public void buildMinHeap(){
        for(int i=arr.length/2;i>=0;i--){
            minHeapify(i);
        }
    }

    public void minHeapify(int i){
        int l = left(i);
        int r = right(i);
        int lowest;

        if(l < size && arr[l] < arr[i]){
            lowest = l;
        }else{
            lowest = i;
        }

        if(r < size && arr[r] < arr[lowest]){
            lowest = r;
        }

        if(lowest!=i){
            swap(lowest, i);
            minHeapify(lowest);
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

    public double[] getArray(){
        return arr;
    }

}
