package com.example.myapplication.LitePal;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import org.litepal.LitePal;

import java.util.List;

public class LitePalActivity extends AppCompatActivity {

    private static final String TAG = "LitePalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);
        Button createDatabase = findViewById(R.id.create_database);
        createDatabase.setOnClickListener(v -> LitePal.getDatabase());

        Button addData = findViewById(R.id.add_data);
        Button updateData = findViewById(R.id.update_data);
        Button deleteData = findViewById(R.id.delete_data);
        Button queryButtion = findViewById(R.id.query_data);

        addData.setOnClickListener(v -> {
            Book book = new Book();
            book.setName("The Da Vinci Code");
            book.setAnthor("Dan Brown");
            book.setPages(454);
            book.setPrice(16.96);
            book.setPress("Unknown");
            book.save();
        });

        updateData.setOnClickListener(v -> {
            Book book = new Book();
            book.setPrice(14.96);
            book.setPress("Anchor");
            book.updateAll("name = ? and author = ?", "The Da Vinci Code", "Dan Brown");
        });

        deleteData.setOnClickListener(v -> {
            LitePal.deleteAll(Book.class, "price < ?", "15");
        });

        queryButtion.setOnClickListener(v -> {
            List<Book> books = LitePal.findAll(Book.class);
            for (Book book: books){
                Log.d(TAG, "book name is " + book.getName());
                Log.d(TAG, "book author is " + book.getAnthor());
                Log.d(TAG, "book pages is " + book.getPages());
                Log.d(TAG, "book price is" + book.getPrice());
                Log.d(TAG, "book press is" + book.getPress());
            }
        });
    }
}
