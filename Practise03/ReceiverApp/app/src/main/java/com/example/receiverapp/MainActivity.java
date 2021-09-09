package com.example.receiverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(final View view) {
        String receivedMessage = "I'm fine!";
        textView = (TextView) findViewById(R.id.textViewReceiver);
        textView.setText("I got message: " + receivedMessage);
        //Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}