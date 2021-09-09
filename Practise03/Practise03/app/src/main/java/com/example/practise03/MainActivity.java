package com.example.practise03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(final View view) {
        edit = (EditText)findViewById(R.id.inputTextSender);
        String message = edit.getText().toString();
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }

}