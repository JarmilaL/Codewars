package com.lenyiova.katas;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetspeakDictionary implements Dictionary {

    private final Map<String, String> dictionary;

    public LeetspeakDictionary() {
        this.dictionary = new HashMap<>();
        dictionary.put("a", "4");
        dictionary.put("e", "3");
        dictionary.put("l", "1");
        dictionary.put("m", "/^^\\");
        dictionary.put("o", "0");
        dictionary.put("u", "(_)");
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    @Override
    public int size() {
        return dictionary.size();
    }

    @Override
    public boolean isEmpty() {
        return dictionary.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return dictionary.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return dictionary.containsValue(o);
    }

    @Override
    public String get(Object o) {
        return dictionary.get(o);
    }

    @Override
    public String put(String s, String s2) {
        return dictionary.put(s, s2);
    }

    @Override
    public String remove(Object o) {
        return dictionary.remove(o);
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> map) {
        dictionary.putAll(map);
    }

    @Override
    public void clear() {
        dictionary.clear();
    }

    @Override
    public Set<String> keySet() {
        return dictionary.keySet();
    }

    @Override
    public Collection<String> values() {
        return dictionary.values();
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return dictionary.entrySet();
    }
}
