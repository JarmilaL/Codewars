package com.lenyiova.katas;

//General Objective
//
//The objective of this Kata is to provide some way to encode a string into its leetspeak version.
//Specific Instructions
//
//    The code must contain a Leetspeak class inherited from an Encoder abstract class and containing an encode(String) method returning itself the encoded String.
//
//    The encode method should return an empty String if a null parameter is passed.
//
//    If any uppercase character is given, it should be compared also with the dictionary, 'a' gives '4' but 'A' gives also '4'.
//
//    If any character outside the dictionary is given, it should be output as is.
//
//Dictionary to reproduce
//
//The following dictionary has to be used :
//
//a -> 4
//e -> 3
//l -> 1
//m -> /^^\
//o -> 0
//u -> (_)


public class Leetspeak extends Encoder {

    @Override
    public String encode(String source) {
        if (source.equals("")) return "";

        // To make it through Codewars tests the dictionary must be initialized here.
        // But it should be a second parameter of this method.
        Dictionary dictionary = new LeetspeakDictionary();

        String modifiedSource = "";
        String[] chars = source.split("");

        for (int i = 0; i < chars.length; i++) {
            if (dictionary.keySet().contains(chars[i].toLowerCase())) {
                modifiedSource += dictionary.get(chars[i].toLowerCase());
            } else {
                modifiedSource += chars[i];
            }
        }

        return modifiedSource;
    }
}
