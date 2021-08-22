package com.example.pizzaon;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class SQLiteDBHelper extends SQLiteOpenHelper {

    final static String DATABASE_NAME = "PizzaOnDataBase.db" ;
    final static int DATABASE_VERSION = 1 ;


    public SQLiteDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase SqlDB) {
        SqlDB.execSQL(
                "CREATE TABLE usersOrder " +
                        "(id integer PRIMARY KEY autoincrement, " +
                        "userName text, " +
                        "mobileNumber text, " +
                        "itemName text, " +
                        "itemPrice integer, " +
                        "itemQuantity integer, " +
                        "itemDescription text, " +
                        "itemImage integer)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase SqlDB, int oldVersion, int newVersion) {
        SqlDB.execSQL("DROP TABLE if exists usersOrder");
        onCreate(SqlDB);
    }


    public boolean insertOrder(String userName, String mobileNumber, String itemName, int itemPrice, int itemQuantity, String itemDescription, int itemImage) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("userName", userName);
        contentValues.put("mobileNumber", mobileNumber);
        contentValues.put("itemName", itemName);
        contentValues.put("itemPrice", itemPrice);
        contentValues.put("itemQuantity", itemQuantity);
        contentValues.put("itemDescription", itemDescription);
        contentValues.put("itemImage", itemImage);

        long id = sqLiteDatabase.insert("usersOrder", null, contentValues);
        return id > 0;
    }

}
