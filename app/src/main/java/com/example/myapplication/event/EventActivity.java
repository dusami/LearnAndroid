package com.example.myapplication.event;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class EventActivity extends AppCompatActivity /* 通过事件源所在的类实现 implements View.OnClickListener */ {

    private static final String TAG = "Activity";
    private Button mBtnEvent;
    private Button mBtnHandler;
    private MyButton mBtnMy;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnMy = findViewById(R.id.btn_my);
        mBtnHandler = findViewById(R.id.btn_handler);

        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this,HandlerActivity.class);
                startActivity(intent);
            }
        });

        mBtnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener", "---onTouch---");
                        break;
                }
                return false;
            }
        });
        mBtnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Listener", "---onClick:---");
            }
        });

        //通过内部类实现
        mBtnEvent.setOnClickListener(new OnClick());
//        //通过匿名内部类实现
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(EventActivity.this,"click...",Toast.LENGTH_SHORT).show();
//            }
//        });
//        //通过事件源所在的类实现
//        mBtnEvent.setOnClickListener(EventActivity.this);
//        //通过外部类实现
//        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));

    }

//    //通过事件源所在的类实现
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btn_event:
//                Toast.makeText(EventActivity.this,"click...",Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }

    //通过内部类实现
    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_event:
                    Toast.makeText(EventActivity.this,"click...",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

//    //布局文件中onClick属性（针对点击事件）
//    public void show(View v){
//        switch (v.getId()){
//            case R.id.btn_event:
//                Toast.makeText(EventActivity.this,"click...",Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "---onTouchEvent---");
                break;
        }
        return false;
    }
}
