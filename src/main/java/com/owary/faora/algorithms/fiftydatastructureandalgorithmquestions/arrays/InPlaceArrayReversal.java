package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.arrays;

import com.owary.faora.utils.Utils;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @author Mensur Owary
 */
public class InPlaceArrayReversal {

    public static void main(String[] args) {
        int[] array1 = Utils.getRandomArrayOfSize(15000);
        int[] array2 = Arrays.copyOf(array1, array1.length);

        long started = System.currentTimeMillis();
        inPlaceReversalIterative(array1);
        long diff = System.currentTimeMillis() - started;
        System.out.println("Iterative Took : "+diff);

        started = System.currentTimeMillis();
        inPlaceReversalRecursive(array2, 0, array2.length-1);
        diff = System.currentTimeMillis() - started;
        System.out.println("Recursive Took : "+diff);

        System.out.println("Iterative result : "+Arrays.toString(array1));
        System.out.println("Recursive result : "+Arrays.toString(array2));
    }

    private static void inPlaceReversalIterative(int[] arr){
        for (int i = 0, j = arr.length-1;
             i < j;
             i++, j--)
        {
            swap(arr, i, j);
        }
    }

    /**
     * Recursive is rather slow, also it throws StackOverflow error for inputs that exceed 150K elements.
     */
    private static void inPlaceReversalRecursive (int[] arr, int st, int e) {
        if (st < e) {
            swap(arr, st, e);
            inPlaceReversalRecursive(arr, st+1, e-1);
        }
    }

    private static void swap (int[] arr, int st, int e) {
        int t = arr[st];
        arr[st] = arr[e];
        arr[e] = t;
    }

}
