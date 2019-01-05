package com.owary.faora.datastructures.dictionary;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Dictionary<String, Double> famousNums = new Dictionary<>();
        famousNums.add("PI", 3.14);
        famousNums.add("PI", 6.0);
        famousNums.add("PI", 14.5);
        famousNums.add("PI", 31.4);

        famousNums.add("E", 2.72);
        famousNums.add("Fi", 1.61);
        famousNums.add("PI", 2.39);


        System.out.println(famousNums.size());

        famousNums.delete("PI");


        famousNums.add("PI", 2.39);
        famousNums.add("PI", 2.39);

        System.out.println(famousNums.size());
        System.out.println(Arrays.toString(famousNums.keys()));
//        famousNums.getBucket();
    }

}
