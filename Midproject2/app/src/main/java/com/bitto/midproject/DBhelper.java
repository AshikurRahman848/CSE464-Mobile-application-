package com.bitto.midproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;
import java.util.ArrayList;

class DBhelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "salaryDatabase3";
    public static final String CONTACTS_TABLE_NAME = "SalaryDetails";
    public DBhelper(Context context) {

        super(context,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(
                    "create table "+ CONTACTS_TABLE_NAME+"(id INTEGER PRIMARY KEY, name text)"
            );
        } catch (SQLiteException e){
            try{
                throw new IOException(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+CONTACTS_TABLE_NAME);
        onCreate(db);
    }

    public boolean insert(String s) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", s);
        db.replace(CONTACTS_TABLE_NAME, null, contentValues);
        return true;
    }



    public ArrayList getAllCotacts() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<String>();
        Cursor res = db.rawQuery("select * from "+ CONTACTS_TABLE_NAME, null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            arrayList.add(res.getString(res.getColumnIndex("name")));
            res.moveToNext();
        }
        return arrayList;
    }

    public boolean update(String s, String s1){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE "+CONTACTS_TABLE_NAME+" SET name = "+ "'"+ s + "'"+ "WHERE name = "+"'"+s1+"'");
        return true;
    }

    public void delete(String s){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+ CONTACTS_TABLE_NAME+ " WHERE name = '"+ s + "'");
    }
}