package com.cookandroid.upstair_alpha;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "upstair_alpha.db";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { // db 생성될 때 호출
        db.execSQL("CREATE TABLE IF NOT EXISTS StairList (id INTEGER PRIMARY KEY AUTOINCREMENT, content TEXT NOT NULL, postDate TEXT NOT NULL, picture TEXT NOT NULL)"); // SQL query 문 들어가는 곳
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
