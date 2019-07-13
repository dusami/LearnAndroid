package com.example.myapplication.UI;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView mTvTitle;
    private TextView mTvMessage;
    private TextView mTvCancel;
    private TextView mTvConfirm;
    private String title,message,cancel,confirm;

    private IOnCancelListener cancelListener;
    private IOnConfirmLister confirmLister;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_diglog);

//        //设置宽度
//        WindowManager m = getWindow().getWindowManager();
//        Display d = m.getDefaultDisplay();
//        WindowManager.LayoutParams p = getWindow().getAttributes();
//        Point size = new Point();
//        d.getSize(size);
//        p.width = (int) (size.x * 0.8); //设置dialog的宽度为当前手机屏幕宽度*0.8
//        getWindow().setAttributes(p);

        mTvTitle = findViewById(R.id.tv_title);
        mTvCancel = findViewById(R.id.tv_cancel);
        mTvMessage = findViewById(R.id.tv_massage);
        mTvConfirm = findViewById(R.id.tv_confirm);

        if (!TextUtils.isEmpty(title)){
            mTvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(message)){
            mTvMessage.setText(message);
        }
        if (!TextUtils.isEmpty(confirm)){
            mTvConfirm.setText(confirm);
        }
        if (!TextUtils.isEmpty(cancel)){
            mTvCancel.setText(cancel);
        }
        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener onCancelListener) {
        this.cancel = cancel;
        this.cancelListener = onCancelListener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmLister confirmLister) {
        this.confirm = confirm;
        this.confirmLister = confirmLister;
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_cancel:
                if (cancelListener != null){
                    cancelListener.onCancel(this);
                }
                hide();
                break;
            case R.id.tv_confirm:
                if (confirmLister != null){
                    confirmLister.onConfirm(this);
                }
                hide();
                break;
        }
    }

    public interface IOnCancelListener{
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfirmLister{
        void onConfirm(CustomDialog dialog);
    }
}
