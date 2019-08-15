package com.owary.faora.algorithms.fiftydatastructureandalgorithmquestions.strings;

import java.io.StringWriter;

/**
 * @author Mensur Owary
 */
public class ReverseWordsInSentence {

    public static void main(String[] args) {
        String quick = "The quick brown fox jumps over lazy dog";
        System.out.println(recursedReverse(quick));
    }

    private static String recursedReverse(String sentence) {
        String[] split = sentence.trim().split("\\s+");
        for (int i = 0; i < split.length; i++) {
            char[] var12 = split[i].trim().toCharArray();
            recursedReverse(var12, 0, var12.length-1);
            split[i] = new String(var12);
        }
        StringWriter sw = new StringWriter();
        for (String s : split) {
            sw.append(s);
            sw.append(" ");
        }
        String var13 = sw.toString();
        return var13.substring(0, var13.length()-1);
    }

    private static void recursedReverse(char[] arr, int s, int e) {
        if (s < e) {
            char tmp = arr[s];
            arr[s] = arr[e];
            arr[e] = tmp;
            recursedReverse(arr, s+1, e-1);
        }
    }

}
