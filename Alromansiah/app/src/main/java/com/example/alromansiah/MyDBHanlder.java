package com.example.alromansiah;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

class MyDBHandler extends SQLiteOpenHelper {
    //DB info

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "info2.db";
    //Tables and its columns
    public static final String TABLE_NAME = "tblAMIGO";
    public static final String COLUMN_RECID = "recID";
    public static final String COLUMN_m = "meet";
    public static final String COLUMN_mm = "meet2";
    public static final String COLUMN_c = "chk1";
    public static final String COLUMN_cc = "chk12";
    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // A SQL statement to create a table of three columns
        String sqlStmt = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_RECID + " INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                COLUMN_m + " TEXT," +
                COLUMN_mm + " TEXT," +
                COLUMN_c + " TEXT," +
                COLUMN_cc + " TEXT " + ");";
        db.execSQL(sqlStmt);


    }

    public void update(String id_no,String meStr1, String meStr2,String chStr1,String chStr2) {
        String[] whereArgs = {id_no};


        SQLiteDatabase db = getWritableDatabase();

        ContentValues updValues = new ContentValues();




            updValues.put("meet", meStr1);
            updValues.put("meet2", meStr2);
            updValues.put("chk1", chStr1);
            updValues.put("chk12", chStr2);



        db.update("tblAMIGO", updValues, "RECID=?", whereArgs);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        Log.d("DB", "The table has been removed!");
        onCreate(db);
    }


}
