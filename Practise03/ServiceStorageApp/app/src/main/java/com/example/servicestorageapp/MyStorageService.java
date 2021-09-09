package com.example.servicestorageapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyStorageService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Hello World!", Toast.LENGTH_LONG).show();
        //return super.onStartCommand(intent, flags, startId);

        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}