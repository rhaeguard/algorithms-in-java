package com.owary.faora.algorithms.sorting.mergesort;

public class MergeSort {

    public static <T extends Comparable<T>> void mergeInit(T[] array){
        mergeSort(array, 0, array.length-1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] array, int st, int end){
        if(end-st>0){
            int mid = (st+end)/2;
            mergeSort(array, 0, mid);
            mergeSort(array, mid+1, end);
            merge(array, st, end, mid);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] array, int st, int end, int mid) {
        int i=0; int j = mid+1;
        T[] temp = (T[])new Comparable[array.length];
        for (int k = 0; k <= end; k++) {
            if(j>end){
                temp[k] = array[i];
                i++;
            }else if(i>mid){
                temp[k] = array[j];
                j++;
            }else if(array[i].compareTo(array[j])<0){
                temp[k]=array[i];
                i++;
            }else if(array[i].compareTo(array[j])>0){
                temp[k]=array[j];
                j++;
            }
        }
        for (int k = 0; k <= end; k++) {
            array[k] = temp[k];
        }
    }


}
