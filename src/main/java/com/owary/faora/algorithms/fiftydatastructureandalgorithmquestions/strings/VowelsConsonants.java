package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.strings;

import java.util.Arrays;

/**
 * @author Mensur Owary
 */
public class VowelsConsonants {

    public static void main(String[] args) {
        String nolifeSHAQ = Arrays.toString(vowelAndConsonants("nolifeSHAQ"));
        System.out.println(nolifeSHAQ);
    }

    private static int[] vowelAndConsonants (String str) {
        int vowels = 0;
        int consonants = 0;
        for (char c : str.toCharArray()) {
            if (inRange(c, 65, 90)) {
                c += 32;
            }
            if (c == 97 || c == 101 || c == 105 || c == 111 || c == 117) {
                vowels++;
            } else if (inRange(c, 97, 122)) {
                consonants++;
            }
        }
        return new int[] {
                vowels, consonants
        };
    }

    private static boolean inRange (int a, int b, int c) {
        return a >= b && a <= c;
    }
}
