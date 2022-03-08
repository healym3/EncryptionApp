package com.example.encryptionapp.substitution;

import java.util.Map;

public class Key {
    private String key;
    private Map<Character, Character> keyMap;

    private boolean checkKey(String key){

        return true;
    }

    public String getKey() {
        return key;
    }

    public boolean setKey(String key) {
        this.key = key;

        return true;
    }
}
