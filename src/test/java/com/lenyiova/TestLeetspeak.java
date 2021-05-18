package com.lenyiova;

import com.lenyiova.katas.Dictionary;
import com.lenyiova.katas.Leetspeak;
import com.lenyiova.katas.LeetspeakDictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLeetspeak {

    private Leetspeak leetspeak;

    @BeforeEach
    public void prepareLeetspeak() {
        leetspeak = new Leetspeak();
    }

    @Test
    public void testEmptyString() {
        String emptyString = "";

        String result = leetspeak.encode(emptyString);

        Assertions.assertEquals("", result);
    }

    @Test
    public void testLeetspeakDictionaryIsAppliedCorrectly() {
        Dictionary dictionary = new LeetspeakDictionary();
        String keys = "";
        for (String key : dictionary.keySet()) keys += key;
        String values = "";
        for (String value : dictionary.values()) values += value;

        String result = leetspeak.encode(keys);

        Assertions.assertEquals(values, result);
    }

    @Test
    public void testUpperCaseLettersAreTranslated() {
        Dictionary dictionary = new LeetspeakDictionary();
        String keys = "";
        for (String key : dictionary.keySet()) keys += key.toUpperCase();
        String values = "";
        for (String value : dictionary.values()) values += value;

        String result = leetspeak.encode(keys);

        Assertions.assertEquals(values, result);
    }

    @Test
    public void testNotDictionaryLettersAreNotModified() {
        Dictionary dictionary = new LeetspeakDictionary();
        String nonDictionaryLetters = "";
        for (int i = (int) 'a'; i <= (int) 'z'; i++) {
            char c = (char) i;
            if (!dictionary.keySet().contains(Character.toString(c))) nonDictionaryLetters += Character.toString(c);
        }

        String result = leetspeak.encode(nonDictionaryLetters);

        Assertions.assertEquals(nonDictionaryLetters, result);
    }
}
