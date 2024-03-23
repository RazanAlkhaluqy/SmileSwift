package com.example.smileswift;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBsmileswift extends SQLiteOpenHelper {

        public static final String DBNAME = "smileswift.db";
        public static final String TABLENAME = "user";
        public static final String COL1 = "username";
        public static final String COL2 = "password";

        public DBsmileswift(@Nullable Context context) {
            super(context, DBNAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE " + TABLENAME + "(" + COL1 + " TEXT PRIMARY KEY, " + COL2 + " TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
            onCreate(sqLiteDatabase);
        }

        public Boolean insertData(String username, String password) {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL1, username);
            contentValues.put(COL2, password);
            long result = MyDB.insert(TABLENAME, null, contentValues);
            return result != -1;
        }

        public Boolean checkUsername(String username) {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor cursor = MyDB.rawQuery("SELECT * FROM " + TABLENAME + " WHERE " + COL1 + " = ?", new String[]{username});
            return cursor.getCount() > 0;
        }

        public Boolean checkUsernamePassword(String username, String password) {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor cursor = MyDB.rawQuery("SELECT * FROM " + TABLENAME + " WHERE " + COL1 + " = ? AND " + COL2 + " = ?", new String[]{username, password});
            return cursor.getCount() > 0;
        }
    }

