package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.strings;

/**
 * @author Mensur Owary
 */
public class Palindrome {

    public static void main(String[] args) {
        String[] strings = {
            "malam",
            "abccba",
            "abc1cba",
            "abcbda"
        };
        for (String string : strings) {
            System.out.println(isPalindromic(string, 0, string.length()-1));
        }
    }

    private static boolean isPalindromic (String string, int st, int e) {
        if (st == e) {
            return true;
        }
        if (string.charAt(st) != string.charAt(e)) {
            return false;
        } else{
            if (st > e) {
                return true;
            }
        }
        return isPalindromic(string, st+1, e-1);
    }

}
