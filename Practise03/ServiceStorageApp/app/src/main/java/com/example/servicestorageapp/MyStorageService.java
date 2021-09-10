package com.example.servicestorageapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyStorageService extends Service {

    public String storageMessage = "";

    private IMyAidlInterface.Stub mService = new IMyAidlInterface.Stub() {
        @Override
        public void saveData(String message) throws RemoteException {
            storageMessage = message;
        }

        @Override
        public String loadData() throws RemoteException {
            return storageMessage;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mService;
    }


}