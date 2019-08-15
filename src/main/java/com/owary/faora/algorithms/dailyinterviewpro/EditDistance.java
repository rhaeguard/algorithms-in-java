package com.owary.faora.algorithms.dailyinterviewpro;

import static java.lang.Math.max;

/**
 * @author Mensur Owary
 */
public class EditDistance {

    private static int editDistanceDynamicProgramming (char[] string1, char[] string2) {
        int a = string1.length;
        int b = string2.length;
        int[][] cache = new int[a+1][b+1];

        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (i == 0) {
                    cache[i][j] = j;
                }
                else if (j == 0) {
                    cache[i][j] = i;
                }
                else if (string1[i-1] == string2[j-1]) {
                    cache[i][j] = cache[i-1][j-1];
                }
                else{
                    cache[i][j] = 1 + min(cache[i-1][j], cache[i][j-1], cache[i-1][j-1]);
                }
            }
        }
        return cache[a][b];
    }

    /**
     *
     * Basically the idea is that,
     *
     * Starting from the last characters, if
     *  - chars are equal, then 1 action - substitution is needed
     *  - one char is missing, then 1 action - either insert or delete required.
     *  - edit distance is the minimum of these three
     *
     */
    private static int editDistanceRecursive (char[] string1, int s1len, char[] string2, int s2len) {
        // base case
        // if any of the strings is empty, then it requires
        // the non-empty string's length amount of insertions (actions)
        if (min(s1len, s2len) == 0) {
            return max(s1len, s2len);
        }

        char s1 = string1[s1len - 1];
        char s2 = string2[s2len - 1];

        int a, b, c;

        // if both chars are present (diff adds 1 if chars are different, adds 0 if they are the same) - substitution required
        a =     editDistanceRecursive(string1, s1len - 1, string2, s2len - 1) + diff(s1, s2);
        // if source string misses a char - delete required
        b = 1 + editDistanceRecursive(string1, s1len - 1, string2, s2len);
        // if destination string misses a char - insert required
        c = 1 + editDistanceRecursive(string1, s1len, string2, s2len-1);
        // edit distance is the minimum of these three
        return min(a, b, c);
    }

    private static int min (int...a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }

    private static int diff (char a, char b) {
        return a == b ? 0 : 1;
    }

    public static void main(String[] args) {
        String str1 = "algorithm";
        String str2 = "altruistic";

        int distance = editDistanceRecursive(str1.toCharArray(), str1.length(), str2.toCharArray(), str2.length());
        System.out.println(distance);

        distance = editDistanceDynamicProgramming(str1.toCharArray(), str2.toCharArray());
        System.out.println(distance);
    }

}
