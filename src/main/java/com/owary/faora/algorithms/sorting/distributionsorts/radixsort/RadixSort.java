package com.owary.faora.algorithms.sorting.distributionsorts.radixsort;

import static com.owary.faora.utils.Utils.maxInt;

public class RadixSort {

    /**
     * Radix sort uses counting sort (and sometimes Bucket Sort) as subroutine. Running time is O(d(n+k))
     * @param arr is the input array
     * @return sorted array
     */
    public static int[] radixSort(int[] arr){
        // get the maximum number to determine the max number of iteration over digits
        // because clearly the maximum number has the maximum number of digits
        int max = maxInt(arr);
        // exponent is used for getting specific digits from numbers
        int exp = 1;
        // here we multiply max by 10 just to loop "number of digits" times
        max*=10;
        while (max/10!=0){
            // call to counting sort as a subroutine
            // k = 10 because the 0-9 we have at most 10 digits
            arr = countingSortRadixSubroutine(arr, 10, exp);
            exp*=10; // multiply exp by 10 to get the next digit from left
            max /= 10; // divide max by 10 to reach 0, ultimately
        }
        return arr;
    }

    /**
     * Counting Sort as the subroutine of Radix Sort. Running time is O(n+k)
     * @param arr is the input array
     * @param k is the maximum value of the digit. For example, if we have numbers (45, 12, 341, 203), at the least significant digit level, k is 5 (because (4)5>(20)3>(1)2>(34)1)
     * @param exp is used to determine the corresponding digit. digit = (i/exp)%10 here we get digits of the number from left to right by multiplying exp by 10 in each iteration
     * @return sorted array
     */
    public static int[] countingSortRadixSubroutine(int[] arr, int k, int exp){
        int[] c = new int[k];
        for(int i : arr){
            // here we count the numbers based on their least significant digit
            // as the exp increases in different calls, we take digits of numbers from left to right and count
            // based upon them
            int digit = (i/exp)%10;
            c[digit]++;
        }

        int[] shift = new int[k];
        for (int i = 0; i < c.length-1; i++) {
            shift[i+1] = shift[i]+c[i];
        }

        int[] result = new int[arr.length];
        for (int i : arr){
            // we construct our result array by their real values instead of digits
            int digit = (i/exp)%10;
            result[shift[digit]] = i;
            shift[digit]++;
        }
        return result;
    }


}
