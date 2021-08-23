package com.example.pizzaon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.pizzaon.Models.UsersOrderModel;

import java.util.ArrayList;


public class SQLiteDBHelper extends SQLiteOpenHelper {

    final static String DATABASE_NAME = "PizzaOnDataBase.db" ;
    final static int DATABASE_VERSION = 1 ;

    SQLiteDatabase sqLiteDatabase;
    Cursor queryCursor;
    ArrayList<UsersOrderModel> selectedOrdersList;

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


    public boolean insertOrder(String userName, String mobileNumber, String itemName, int itemPrice, int itemQuantity,
                                        String itemDescription, int itemImage) {
        sqLiteDatabase = getReadableDatabase();
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


    public ArrayList<UsersOrderModel> getSelectedOrdersList() {
        selectedOrdersList = new ArrayList<>();
        sqLiteDatabase = getWritableDatabase();

        queryCursor = sqLiteDatabase.rawQuery("SELECT id, itemName, itemPrice, itemQuantity, itemImage FROM usersOrder", null);
        if (queryCursor.moveToFirst()) {
            while(queryCursor.moveToNext()) {
                UsersOrderModel usersOrderModel = new UsersOrderModel();

                usersOrderModel.setEachOrderID(queryCursor.getInt(0)+"");
                usersOrderModel.setEachOrderName(queryCursor.getString(1));
                usersOrderModel.setEachOrderPrice(queryCursor.getString(2));
                usersOrderModel.setEachOrderQuantity(queryCursor.getString(3));
                usersOrderModel.setEachOrderImage(queryCursor.getInt(4));

                selectedOrdersList.add(usersOrderModel);
            }
        }
        queryCursor.close();
        sqLiteDatabase.close();

        return selectedOrdersList;
    }


    public Cursor getOrderByID(String orderID) {
        sqLiteDatabase = getWritableDatabase();
        queryCursor = sqLiteDatabase.rawQuery("SELECT * FROM usersOrder where id = "+orderID, null);

        if (queryCursor != null)
            queryCursor.moveToFirst();

        return queryCursor;
    }


    public boolean updateOrder(String userName, String mobileNumber, String itemName, int itemPrice, int itemQuantity,
                               String itemDescription, int itemImage, String orderID) {
        sqLiteDatabase = getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("userName", userName);
        contentValues.put("mobileNumber", mobileNumber);
        contentValues.put("itemName", itemName);
        contentValues.put("itemPrice", itemPrice);
        contentValues.put("itemQuantity", itemQuantity);
        contentValues.put("itemDescription", itemDescription);
        contentValues.put("itemImage", itemImage);

        long row = sqLiteDatabase.update("usersOrder", contentValues, "id = "+orderID, null);
        return row > 0;
    }


    public int deleteOrder(String orderID) {
        sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete("usersOrder", "id = "+orderID, null);
    }

}
