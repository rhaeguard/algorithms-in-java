package com.owary.faora.algorithms.dailyinterviewpro;

/**
 * @author Mensur Owary
 */
public class SingleModification {

    public static void main(String[] args) {
        int[] arrFalse = {5, 1, 3, 2, 5};
        System.out.println(singleModifiable(arrFalse));

        int[] arrTrue = {1, 7, 9, 8, 13, 41};
        System.out.println(singleModifiable(arrTrue));
    }

    /**
     *
     * Basic idea:
     * in a non decreasing array, the graph should be steadily rising.
     * we try to find if there's more than 1 decrease.
     *
     */
    private static boolean singleModifiable (int[] arr) {
        if (arr.length < 2) return true;
        int downCount = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                downCount++;
            }
            if (downCount > 1) {
                return false;
            }
        }
        return true;
    }
}
