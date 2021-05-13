package com.lenyiova.katas;

// Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.
//
// #Example 1: a1 = ["arp", "live", "strong"]
//
// a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
//
// returns ["arp", "live", "strong"]
//
// #Example 2: a1 = ["tarp", "mice", "bull"]
//
// a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
//
// returns []
// Notes:
//
//    Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
//
//    In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.
//
//    Beware: r must be without duplicates.
//    Don't mutate the inputs.

import java.util.HashSet;
import java.util.Set;

public class WhichAreIn {
    public static String[] inArray(String[] array1, String[] array2) {
        Set<String> helper = new HashSet<>();

        for (String a2 : array2) {
            for (String a1 : array1) {
                if (a2.contains(a1)) helper.add(a1);
            }
        }

        String[] result = helper.toArray(new String[0]);

        return sortArray(result);
    }

    private static String[] sortArray(String[] array) {
        boolean check = false;

        while(!check) {
            check = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    String box = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = box;
                    check = false;
                }
            }
        }

        return array;
    }

}
