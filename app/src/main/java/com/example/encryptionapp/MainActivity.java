package com.example.encryptionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.encryptionapp.substitution.Key;
import com.example.encryptionapp.substitution.Substitution;

public class MainActivity extends AppCompatActivity {
    private Substitution substitution;
    private Key key;
    private TextView keyTextView;
    private Button createKeyButton;
    private Button encryptButton;
    private Button decryptButton;
    private EditText plainEditText;
    private EditText cipherEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keyTextView = findViewById(R.id.keyTextView);
        createKeyButton = findViewById(R.id.createKeyButton);
        encryptButton = findViewById(R.id.encryptButton);
        decryptButton = findViewById(R.id.decryptButton);
        plainEditText = findViewById(R.id.plainEditText);
        cipherEditText = findViewById(R.id.cipherEditText);


        key = new Key();
        key.setKey("defghijklmnopqrstuvwxyzabc");
        displayKey();
        Log.d("Key", "onCreate: " + key.getKey().toString());

        substitution = new Substitution(key);
        String cipher = substitution.encrypt("hello world this is mackenzie");
        Log.d("Key", "encrypt: " + cipher);
        String plain = substitution.decrypt(cipher);
        Log.d("Key", "decrypt: " + plain);

        createKeyButton.setOnClickListener(view -> {
            key.generateKey();
            displayKey();
        });
        encryptButton.setOnClickListener(view -> {
            if (!TextUtils.isEmpty(plainEditText.getText())) {
                String cipherText = substitution.encrypt(String.valueOf(plainEditText.getText()));
                cipherEditText.setText(cipherText);
            }

        });
        decryptButton.setOnClickListener(view -> {
            if (!TextUtils.isEmpty(cipherEditText.getText())) {
                String plainText = substitution.decrypt(String.valueOf(cipherEditText.getText()));
                plainEditText.setText(plainText);
            }
        });
    }

    private void displayKey(){
        keyTextView.setText(key.toString());
    }
}