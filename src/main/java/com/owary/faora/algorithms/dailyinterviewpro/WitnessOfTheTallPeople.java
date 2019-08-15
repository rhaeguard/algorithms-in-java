package com.owary.faora.algorithms.dailyinterviewpro;

/**
 * @author Mensur Owary
 */
public class WitnessOfTheTallPeople {

    public static void main(String[] args) {
        System.out.println(witness(new int[] {3, 6, 3, 4, 1}));
    }

    /**
     * Basically, find how many max-es there have been
     * starting from the very end.
     */
    private static int witness (int[] arr) {
        int count = 1; // it is 1 because at least the last person sees it.
        int length = arr.length;
        int max = arr[length -1];
        for (int i = length -2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                count++;
            }
        }
        return count;
    }

}
