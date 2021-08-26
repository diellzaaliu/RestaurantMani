package com.example.RestaurantMani;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table user(email Text primary key, password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists user");
    }
    public Boolean insertData(String email, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = myDB.insert("user", null, contentValues);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    //checking if email exists;
    public Boolean checkEmail(String email){
        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from user where email = ?", new String[] {email});
        if(cursor.getCount()>0){
            return false;
        }
        else{
            return true;
        }
    }
    //checking email and password;
    public Boolean emailPassword(String email1, String password1){
        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from user where email = ? and password = ?", new String[]{email1,password1});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }

    }

}
