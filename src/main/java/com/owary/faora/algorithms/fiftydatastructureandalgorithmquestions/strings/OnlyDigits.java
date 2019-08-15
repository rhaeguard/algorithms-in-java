package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.strings;

/**
 * @author Mensur Owary
 */
public class OnlyDigits {

    public static void main(String[] args) {
        System.out.println(containsOnlyDigits("1234567890"));
        System.out.println(containsOnlyDigits("123das4567890"));
        System.out.println(containsOnlyDigits("123456/-7890"));
    }

    private static boolean containsOnlyDigits (String str) {
        for (char c : str.toCharArray()) {
            // basically ascii values for digits, ranging from 0 to 9, inclusively
            if (!(c >= 48 && c <= 57)) {
                return false;
            }
        }
        return true;
    }

}
