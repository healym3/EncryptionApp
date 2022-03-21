package com.example.encryptionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.encryptionapp.breaker.Breaker;
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

//        Breaker breaker = new Breaker(this.getApplicationContext());
//        breaker.breakCipher("msr crkqimurem xz jxukdmri bjvrejr qec renverriven mrjsextxna vb xer " +
//                "xz msirr qjqcruvj crkqimuremb pvmsve msr jxttrnr xz bjvrejrb qec " +
//                "mrjsextxna qm msr devoribvma xz sxdbmxe cxpemxpe. pr xzzri bmdcremb q " +
//                "devwdr xkkximdevma mx qjsvror qjqcruvj bdjjrbb ve jxukdmri bjvrejr qec " +
//                "renverriven mrjsextxna msixdns ivnxixdb qec ryjvmven jxdibrb, " +
//                "vejtdcven decriniqcdqmr irbrqijs xkkximdevmvrb. pr qir jxuuvmmrc mx " +
//                "miqveven bmdcremb zxi jsqttrenrb ve jxukdmri bjvrejr qec renverriven " +
//                "mrjsextxna, qec ve zvrtcb irwdviven msr gexptrcnr qec bgvttb, xdi " +
//                "jdiivjdtdu kixovcrb zxi bmdcremb pvmsve mryqb qec qixdec msr pxitc. " +
//                "msr crkqimurem xz jxukdmri bjvrejrb qec renverriven mrjsextxna vb msr " +
//                "zqbmrbm nixpven crkqimurem pvmsve msr jxttrnr xz bjvrejrb qec " +
//                "mrjsextxna. qccvmvxeqtta, qb q bmdcrem xz msr jbrm crkqimurem, axd " +
//                "pvtt nqve sqecb xe rykrivrejr qec kiqjmvjqt miqveven. bmdcremb pvtt fr " +
//                "irwdvirc mx kqimvjvkqmr ve q brurbmri kixhrjm, psvjs pvtt miqve " +
//                "bmdcremb mx pxig xe irqt vecdbmia kixftrub ve q mrqu reovixeurem msqm " +
//                "msra pvtt rejxdemri pxigven ve vecdbmia qzmri niqcdqmvxe. msr brevxi " +
//                "kixhrjm qttxpb bmdcremb mx qkkta msrvi jxdibr uqmrivqtb qec trqieven " +
//                "rykrivrejrb mx brurbmri txen irqt pxitc kixhrjmb.");
    }

    private void displayKey(){
        keyTextView.setText(key.toString());
    }
}