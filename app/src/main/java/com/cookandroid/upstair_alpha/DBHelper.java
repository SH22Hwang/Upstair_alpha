package com.cookandroid.upstair_alpha;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "upstair_alpha.db";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { // db 생성될 때 호출, SQL query 문 넣기
        db.execSQL("CREATE TABLE IF NOT EXISTS StairList (id INTEGER PRIMARY KEY AUTOINCREMENT, postDate TEXT NOT NULL, content TEXT NOT NULL, picture TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    // INSERT(추가)
    public void insertPost(String _postDate, String _content, String _picture) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO StairList (postDate, content, picture) VALUES('" + _postDate + "','" + _content + "','" + _picture + "');");
    }

    // UPDATE(수정)
    public void updatePost(String _postDate, String _content, String _picture, int _id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE StairList SET postDate='" + _postDate + "', content='" + _content + "', picture='" + _picture + "'WHERE id='" + _id + "'");
    }

    // DELETE(삭제)
    public void deletePost(int _id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM StairList WHERE id='" + _id + "'");
    }

    // SELECT(조회)
    public ArrayList<StairItem> getStairList() {
        ArrayList<StairItem> stairItems = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM StairList ORDER BY postDate DESC", null);

        if (cursor.getCount() != 0) { // 데이터 있을 때만 실행
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id")); //getColumnIndex에서 getColumnIndexOrThrow로 변경
                String postDate = cursor.getString(cursor.getColumnIndexOrThrow("postDate"));
                String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
                String picture = cursor.getString(cursor.getColumnIndexOrThrow("picture"));

                StairItem stairItem = new StairItem();
                stairItem.setId(id);
                stairItem.setPostDate(postDate);
                stairItem.setContent(content);
                stairItem.setPicture(picture);

                stairItems.add(stairItem);
            }
        }

        cursor.close(); // Warning:(54, 28) This `Cursor` should be freed up after use with `#close()`
        return stairItems;
    }
}
