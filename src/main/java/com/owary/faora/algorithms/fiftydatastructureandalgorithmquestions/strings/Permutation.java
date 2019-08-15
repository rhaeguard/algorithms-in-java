package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.strings;

/**
 * @author Mensur Owary
 */
public class Permutation {

    public static void main(String[] args) {
        permutation("abc".toCharArray(), 0, 2);
    }

    private static void permutation (char[] chars, int s, int e) {
        if (s == e) {
            System.out.println(new String(chars));
        }else{
            for (int i = s; i < e; i++) {
                swap (chars, s, i);
                int k = ++s;
                permutation(chars, k, e);
                swap (chars, s, i);
            }
        }
    }

    private static void swap(char[] chars, int s, int e) {
        System.out.println(String.format("%d\t%d", s, e));
        char t = chars[s];
        chars[s] = chars[e];
        chars[e] = t;
    }

}
