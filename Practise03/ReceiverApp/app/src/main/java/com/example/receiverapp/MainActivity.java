package com.example.receiverapp;

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
import android.widget.TextView;

import com.example.servicestorageapp.IMyAidlInterface;


public class MainActivity extends AppCompatActivity {

    final static String TAG = "ReceiverApp";

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

        final TextView textView = (TextView)findViewById(R.id.textViewReceiver);
        final Button btnReceiver = (Button)findViewById(R.id.buttonReceiver);
        btnReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String receivedMessage = mService.loadData();
                    textView.setText(receivedMessage);
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