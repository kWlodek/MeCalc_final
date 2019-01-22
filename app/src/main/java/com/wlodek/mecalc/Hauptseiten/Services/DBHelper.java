package com.wlodek.mecalc.Hauptseiten.Services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.wlodek.mecalc.Hauptseiten.Services.Contract.*;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Mecalc.db";
    public static final int DATABASE_VERSION = 1;

    public DBHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_SPEISEN_TABLE = "CREATE TABLE "+
                Entry.TABLE_NAME + "(" +
                Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                Entry.COLUMN_NAME + " TEYT NOT NULL, "+
                Entry.COLUMN_KCAL + " INTEGER NOT NULL"+
                ");";

        db.execSQL(SQL_CREATE_SPEISEN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + Entry.TABLE_NAME);
            onCreate(db);
    }
}
