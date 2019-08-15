package com.owary.faora.algorithms.misc;

public class PowerOf2 {

    public static void main(String[] args) {
        int n = 50000;
        long l = System.currentTimeMillis();
        int[] ints = twoToN(n);
        System.out.println("Calculation Took : "+(System.currentTimeMillis() - l) +" ms");
        System.out.println("2^"+n);
        print(ints);
    }

    /**
     * Calculates nth power of 2 where n is bigger enough like 50000
     * @param n the desired power
     * @return the calculated value in array, reversed, padded with zeros
     */
    private static int[] twoToN(int n){
        // if the number is less than equal to 31, meaning that Java can calculate it
        if (n <= 31) {
            // return java calculated value
            return getJavaCalcValue(n);
        }
        // otherwise start with 2^31's digit array
        int[] one = getStartPoint();

        // and multiply each result by 2 until we reach the desired level
        for (int i = 31; i < n; i++) {
            // get the result and re-supply it to the method
            one = twoDoubled(one);
        }
        return one;
    }

    /**
     * Multiplies the given array consisting of digits in reverse order (ascending decimal places) by 2
     * @param num the number array
     * @return doubled number digits, in reverse order padded with zeros (possibly)
     */
    private static int[] twoDoubled(int[] num){
        /**
         * Basically, this method does the multiplication we learned at school
         * But multiplies by 2
         */
        // result array
        int[] r = new int[num.length+1];

        // index indicator
        int k = 0;
        // what is remembered after the multiplication of 2 digits
        int remember = 0;
        for (int i = 0; i < num.length; i++) {
            // get the digit
            int digit = num[i];
            // multiply it by 2
            int newDigit = digit*2;
            // get the least decimal place, so if multiplication result was 8 it will be 8, if it was 15 it will be 5
            digit = newDigit % 10;
            // put the digit to its place
            r[k] = digit+remember;
            // if the multiplication had 2 digit result (<=18, because 2*9 is the max)
            if (newDigit >= 10){
                // set the remembered value
                remember = newDigit / 10;
            }else{
                // otherwise make it 0, cuz the result was single number
                remember = 0;
            }
            // increment the index flag
            k++;
        }
        // if still something is remembered
        if (remember != 0){
            // put it to the end of the array
            r[k] = remember;
        }
        // return the array
        return r;
    }

    /**
     * This function is used to speed up calculations, because Java can very well calculate numbers under 2^31 (inclusive), that's why we add this pre-calculated array
     * @return 2^31 in reverse digit order
     */
    private static int[] getStartPoint() {
        return new int[]{8, 4, 6, 3, 8, 4, 7, 4, 1, 2};
    }

    /**
     * Removes padded zeros, reverses the digits and prints them as a result
     * @param nums array of digits
     */
    private static void print(int[] nums){
        int prev = nums[nums.length - 1];
        int st = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (prev != 0) {
                st = i;
                break;
            } else {
                prev = nums[i];
            }
        }
        if (st+1 < nums.length && nums[st+1] != 0){
            st = st + 1;
        }
        for (int i = st; i >= 0; i--) {
            System.out.print(nums[i]);
        }
    }

    /**
     * Let Java calculate 2^n where n <= 31
     * @param n the desired power
     * @return 2 raised to nth power
     */
    private static int[] getJavaCalcValue(int n) {
        // if number is 31 return the pre-processed array
        if (n == 31) return getStartPoint();
        // otherwise, calculate it.
        int a = (int) Math.pow(2, n);
        // digitize it
        int[] res = new int[10];
        for (int i = 0; i < res.length; i++) {
            res[i] = a % 10;
            a /= 10;
        }
        return res;
    }


}
