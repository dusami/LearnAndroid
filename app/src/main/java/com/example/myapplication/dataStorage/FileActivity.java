package com.example.myapplication.dataStorage;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    private Button mBtnSave;
    private Button mBtnShow;
    private EditText mEtName;
    private TextView mTvContent;
    private final String mFileName = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mEtName = findViewById(R.id.et_name);
        mTvContent = findViewById(R.id.tv_content);

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEtName.getText().toString());
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(read());
            }
        });
    }

    //存储数据
    private void save(String content) {
        FileOutputStream fileOutputStream = null;
        try {
//            //内部存储
//            fileOutputStream = openFileOutput(mFileName, MODE_PRIVATE);

            //外部存储
            //创建文件夹
            File dir = new File(Environment.getExternalStorageDirectory(),"123");
            if (!dir.exists()){
                dir.mkdirs();
            }
            //创建文件
            File file = new File(dir,mFileName);
            if (!file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);

            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //读取数据
    private String read() {
        FileInputStream fileInputStream = null;
        try {
//            //内部读取
//            fileInputStream = openFileInput(mFileName);

            //外部读取
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"123",mFileName);
            fileInputStream = new FileInputStream(file);

            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while ((len = fileInputStream.read(buff)) > 0) {
                sb.append(new String(buff, 0, len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}