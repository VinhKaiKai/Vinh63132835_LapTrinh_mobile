package com.tramquangvinh.sqlite_lop;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase bookDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookDB =openOrCreateDatabase("book.db", MODE_PRIVATE, null);
        String sqltext = "DROP TABLE IF EXISTS BOOKS";
        String sqltaobang = "CREATE TABLE BOOKS(bookID interger PRIMARY KEY, BookName text, \n"+"Page interger, Price Float, Decription text)";

        bookDB.execSQL(sqltext);
        bookDB.execSQL(sqltaobang);
        bookDB.close();

    }
}