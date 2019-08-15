package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.strings;

/**
 * @author Mensur Owary
 */
public class ReverseStringRecursive {

    public static void main(String[] args) {
        String s = reverse("Reverse");
        System.out.println(s);
    }

    private static String reverse (String str) {
        char[] chars = str.toCharArray();
        doReverse(chars, 0, str.length()-1);
        return new String(chars);
    }

    private static void doReverse (char[] chars, int s, int e) {
        if (s <= e) {
            char t = chars[s];
            chars[s] = chars[e];
            chars[e] = t;
            doReverse(chars, ++s, --e);
        }
    }
}
