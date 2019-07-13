package com.example.myapplication.event;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class MyClickListener implements View.OnClickListener {

    private Activity mActivity;

    public MyClickListener(Activity activity){
        this.mActivity = activity;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(mActivity,"click...",Toast.LENGTH_SHORT).show();
    }
}
