package com.example.mozeeb.biodata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "biodata.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE biodata(no integer PRIMARY KEY, nama TEXT null, tgl TEXT null, kelas TEXT null,  alamat TEXT null, jurusan TEXT null );";
        Log.d("Data","onCreate" + sql);
        db.execSQL(sql);
        sql = "INSERT INTO biodata (no , nama , tgl, kelas, alamat, jurusan)VALUES('01', 'Mujiburrohman', '05-11-2000','10','Kelet Rt 02 Rw 01 Keling Jepara', 'RPL');";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
