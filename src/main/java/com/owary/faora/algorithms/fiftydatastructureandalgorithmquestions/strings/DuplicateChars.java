package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mensur Owary
 */
public class DuplicateChars {

    public static void main(String[] args) {
        Set<Character> set = printDuplicateChars("This life of yours are not gonna end in a good fashion, mate");
        System.out.println(set);
    }

    private static Set<Character> printDuplicateChars (String string) {
        Set<Character> chars = new HashSet<>();
        Set<Character> duplicates = new HashSet<>();
        for (char c : string.toCharArray()) {
            if (chars.contains(c)) {
                duplicates.add(c);
            }else{
                chars.add(c);
            }
        }
        return duplicates;
    }

}
