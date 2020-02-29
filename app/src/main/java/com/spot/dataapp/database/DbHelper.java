package com.spot.dataapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.spot.dataapp.database.FeedReaderContract.FeedEntry;

/**
 * this class will help me create a db if it doesn't exist.
 * this class will also help me create a table in the above db
 */
public class DbHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                    FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

    public DbHelper(@Nullable Context context) {//1c
        super(context, "mobidb", null, 1);
    }

    /**
     * this method will be called when db is first created
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {//1d
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);//1e
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
