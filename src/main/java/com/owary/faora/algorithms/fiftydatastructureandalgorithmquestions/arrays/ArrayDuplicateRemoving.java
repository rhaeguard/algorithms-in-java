package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.arrays;

import java.util.Arrays;

/**
 * @author Mensur Owary
 */
public class ArrayDuplicateRemoving {

    public static void main(String[] args) {
        int[] arrayWDuplicates = {1, 2, 9, 2, 9, 255, 43, 2};
        int[] ints = removeDuplicates(arrayWDuplicates);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] removeDuplicates(int[] elements) {
        int min = Integer.MAX_VALUE,
            max = Integer.MIN_VALUE;
        for (int element : elements) {
            if (min > element) {
                min = element;
            }
            if (max < element) {
                max = element;
            }
        }

        Integer[] temp = new Integer[max+1];
        int total = 0;
        for (int element : elements) {
            if (temp[element] == null) {
                if (element == max) {
                    temp[max] = element;
                }else {
                    temp[element] = element;
                }
                total++;
            }else{
                System.out.println(element);
            }
        }
        int i = 0;
        int[] result = new int[total];

        for (Integer element : temp) {
            if (element != null) {
                result[i] = element;
                i++;
            }
        }

        return result;
    }

}
