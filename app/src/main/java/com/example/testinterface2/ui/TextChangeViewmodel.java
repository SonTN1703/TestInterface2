package com.example.testinterface2.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TextChangeViewmodel extends ViewModel {
    private MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<String> getStringMutableLiveData() {
        return stringMutableLiveData;
    }

    public void setString(String a){
        stringMutableLiveData.postValue(a);
        stringMutableLiveData.setValue(a);
    }
}
