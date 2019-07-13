package com.example.myapplication.HttpURL;

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);
}
