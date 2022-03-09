package com.example.encryptionapp.substitution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Key {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Map<Character, Character> key;
    private Map<Character, Character> keyDecrypt;

    public Key() {
        key = new HashMap<Character, Character>();
    }

    private boolean checkKey(String keyString){
        // Key must be as long as alphabet
        if(keyString.length() != ALPHABET.length()) return false;
        keyString = keyString.toUpperCase(Locale.ROOT);

        //Key characters must be unique
        Set<Character> keySet = new HashSet<>();
        for(char ch: keyString.toCharArray()){
            keySet.add(ch);
        }
        if (keySet.size() != ALPHABET.length()) return false;

        Set<Character> alphabetSet = new HashSet<>();
        for(char ch: ALPHABET.toCharArray()){
            alphabetSet.add(ch);
        }
        if (!keySet.equals(alphabetSet)) return false;

        for (int i = 0; i < ALPHABET.length(); i++) {
            key.put(ALPHABET.charAt(i), keyString.charAt(i));
            keyDecrypt.put(keyString.charAt(i), ALPHABET.charAt(i));
        }


        return true;
    }



    public boolean setKey(String key) {
        return checkKey(key);
    }

    public Map<Character, Character> getKey() {
        return key;
    }

    public Map<Character, Character> getKeyDecrypt() {
        return keyDecrypt;
    }
}
