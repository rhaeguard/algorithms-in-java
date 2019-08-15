package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mensur Owary
 */
public class FirstNonRepeatedChar {

    public static void main(String[] args) {
        firstNonRepeatedChar("covercroek");
        firstNonRepeatedChar("coovvrecer");
    }

    private static void firstNonRepeatedChar (String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                Integer integer = map.get(c) + 1;
                map.put(c, integer);
            }else {
                map.put(c, 1);
            }
        }

        for (char c : str.toCharArray()) {
            Integer integer = map.get(c);
            if (integer == 1) {
                System.out.println(c);
                return;
            }
        }

        System.out.println("No non-repeated char");
    }

}
