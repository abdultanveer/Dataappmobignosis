package com.spot.dataapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.spot.dataapp.database.FeedReaderContract.FeedEntry;

/**
 * this class handles create read update and delete
 */
public class DbAccessObject {
    SQLiteDatabase database;
    DbHelper dbHelper;

    public DbAccessObject(Context context) {//1a
        dbHelper = new DbHelper(context);//1b
    }

    public  void openDb(){//2a
        database = dbHelper.getWritableDatabase();//2b

    }
    public  void closeDb(){}

    public void createRow(String title, String subtitle){//3b
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE,title);
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,subtitle);
        database.insert(FeedEntry.TABLE_NAME,null,values);

    }
    public void readRow(){}
    public void updateRow(){}
    public void deleteRow(){}

}
