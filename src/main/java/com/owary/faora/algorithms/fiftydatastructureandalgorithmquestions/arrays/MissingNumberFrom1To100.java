package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.arrays;

/**
 * @author Mensur Owary
 */
public class MissingNumberFrom1To100 {

    public static void main(String[] args) {
        // populating the array
        int[] arr = new int[99];
        int j = 0;
        for (int i = 1; i <= 100; i++) {
            // missing number is 47
            if (i != 47) {
                arr[j] = i;
                j++;
            }
        }

        // it will print 47!
        System.out.println(findMissing(arr));
    }

    private static int findMissing (int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return 5050 - sum;
    }
}
