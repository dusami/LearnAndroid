package com.example.myapplication.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class DatabaseActivity extends AppCompatActivity {

    private static final String TAG = "DatabaseActivity";
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 3);
        Button createDatabase = findViewById(R.id.create_database);
        Button addData = findViewById(R.id.add_data);
        Button updateDate = findViewById(R.id.update_data);
        Button deleteButton = findViewById(R.id.delete_data);
        Button queryButton = findViewById(R.id.query_data);

        createDatabase.setOnClickListener(v -> dbHelper.getWritableDatabase());

        addData.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            //开始组装第一条数据
            values.put("name", "The Da Vinci Code");
            values.put("author", "Dan Brown");
            values.put("pages", 454);
            values.put("price", 16.96);
            db.insert("Book", null, values);//插入第一条数据
            values.clear();
            //开始组装第二条数据
            values.put("name", "The Lost Symbol");
            values.put("author", "Dan Brown");
            values.put("pages", 510);
            values.put("price", 19.95);
            db.insert("Book", null ,values);//插入第二条数据
        });

        updateDate.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("price", 10.99);
            db.update("Book", values, "name = ?", new String[]{"The Da Vinci Code"});
        });

        deleteButton.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.delete("Book", "price > ?", new String[]{"12"});
        });

        queryButton.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            //查询Book表中所有的数据
            Cursor cursor = db.query("Book", null, null, null, null, null, null);
            if (cursor.moveToFirst()){
                do{
                    //遍历Cursor对象，取出数据并打印
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String anthor = cursor.getString(cursor.getColumnIndex("author"));
                    int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                    double price = cursor.getDouble(cursor.getColumnIndex("price"));
                    Log.d(TAG, "book name is " + name);
                    Log.d(TAG, "book author is " + anthor);
                    Log.d(TAG, "book pages is " + pages);
                    Log.d(TAG, "book price is " + price);
                }while (cursor.moveToNext());
            }
            cursor.close();
        });
    }
}
