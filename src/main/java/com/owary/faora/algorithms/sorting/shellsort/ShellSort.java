package com.owary.faora.algorithms.sorting.shellsort;

import java.util.Arrays;

import static com.owary.faora.utils.Utils.randomStringArray;

public class ShellSort {

    public static void main(String[] args) {
        String[] arr = randomStringArray(60, 23);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static <T extends Comparable<T>> void shellSort(T[] arr){
        int h = 1; // initial gap
        int n = arr.length;
        while(h<=n){h=3*h+1;}
        do {
            h/=3;
            for (int i = h; i < n; i++) {
                T key = arr[i];
                int j = i;
                while(key.compareTo(arr[j-h])<0){
                    arr[j] = arr[j-h];
                    j = j-h;
                    if(j<h){break;}
                }
                arr[j] = key;
            }
        }while (h>1);
    }




}
