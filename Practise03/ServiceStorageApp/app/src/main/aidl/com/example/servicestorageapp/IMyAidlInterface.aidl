// IMyAidlInterface.aidl
package com.example.servicestorageapp;


interface IMyAidlInterface {
    void saveData(String message);
    String loadData();
}