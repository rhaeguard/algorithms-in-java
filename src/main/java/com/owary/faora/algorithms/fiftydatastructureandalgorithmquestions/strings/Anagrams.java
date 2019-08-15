package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mensur Owary
 */
public class Anagrams {

    public static void main(String[] args) {
        System.out.println(areAnagrams("listen", "silent"));
    }

    private static boolean areAnagrams (String str1, String str2) {
        if (str1.equals(str2)) return true;
        if (str1.length() != str2.length()) return false;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<Character, Integer> chars = new HashMap<>();
        for (char c : str1.toCharArray()) {
            if (chars.containsKey(c)) {
                int newVal = chars.get(c)+1;
                chars.put(c, newVal);
            }else{
                chars.put(c, 1);
            }
        }

        for (char c : str2.toCharArray()) {
            if (chars.containsKey(c)) {
                Integer integer = chars.get(c);
                integer--;
                if (integer == 0) {
                    chars.remove(c);
                }else{
                    chars.put(c, integer);
                }
            }
        }
        return chars.isEmpty();
    }

}
