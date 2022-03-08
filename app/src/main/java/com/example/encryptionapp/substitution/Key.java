package com.example.encryptionapp.substitution;

public class Key {
    private String key;

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
