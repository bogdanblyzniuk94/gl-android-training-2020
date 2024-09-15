package com.example.practise03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.servicestorageapp.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MyApplication";

    private IMyAidlInterface mService;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            if (service != null) {
                mService = IMyAidlInterface.Stub.asInterface(service);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputTextSender = (EditText)findViewById(R.id.inputTextSender);
        final Button buttonSend = (Button)findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = inputTextSender.getText().toString();

                try {
                    mService.saveData(message);
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                } catch (RemoteException | NullPointerException e) {
                    Log.e(TAG, "call add failed!!!");
                } catch (NumberFormatException e) {
                    Log.e(TAG, "call add failed!!!");
                }
            }
        });

        Intent intent = new Intent();
        intent.setClassName("com.example.servicestorageapp", "com.example.servicestorageapp.MyStorageService");
        try {
            bindService(intent, mConnection, BIND_AUTO_CREATE);
        } catch (SecurityException e) {
            Log.e(TAG, "bind to service failed by security!");
        }
    }


}