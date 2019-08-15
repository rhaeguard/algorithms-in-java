package com.owary.faora.utils;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Utils {

    private static final Random random = new Random();

    public static int maxInt(int[] arr){
        return IntStream.of(arr).max().getAsInt();
    }

    public static String[] randomStringArray(int size, int stringSize){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabet += alphabet.toLowerCase();

        int len = alphabet.length();

        Random r = new Random();
        int rand = -1;
        String[] arr = new String[size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < stringSize; j++) {
                rand = r.nextInt(len);
                sb.append(alphabet.charAt(rand));
            }
            arr[k] = sb.toString();
            k++;
        }

        return arr;
    }

    public static <T extends Comparable<T>> void printArray(T[] arr, String text){
        System.out.println(text+" :\n"+ Arrays.toString(arr));
    }

    public static void print(String text){
        System.out.println(text);
    }

    public static <T extends Comparable<T>> void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] getRandomArrayOfSize (int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(150);
        }
        return arr;
    }

}
