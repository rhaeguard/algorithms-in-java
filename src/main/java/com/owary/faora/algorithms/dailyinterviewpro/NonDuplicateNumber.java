package com.owary.faora.algorithms.dailyinterviewpro;

/**
 * @author Mensur Owary
 */
public class NonDuplicateNumber {

    public static void main(String[] args) {
        int[] arr = {1, 5, 1, 17, 41, 5, 41};
        System.out.println(findNonDuplicate(arr));
    }

    /**
     * Basic explanation:
     *
     * XOR-ing a number with itself results in 0.
     * XOR-ing a number with 0 results in itself.
     * So, since we have duplicates in numbers,
     * XOR-ing all the numbers
     * will cause duplicates to cancel out each other
     */
    private static int findNonDuplicate(int[] arr) {
        int xor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }

}
