package com.android.nyundaasapopoe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class SQLHelper extends SQLiteOpenHelper {

    private static String NAMA_DATABASE = "kosakataDB.DB";
    private static final String NAMA_TABEL = "kosakkata";

    static final String KEY_ID = "id";
    static final String KEY_KATA = "kata";
    static final String KEY_ARTI = "arti";

    SQLHelper(@Nullable Context context) {
        super(context, NAMA_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String BUAT_TABEL = "CREATE TABLE  IF NOT EXISTS " + NAMA_TABEL + " (" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_KATA + " VARCHAR , " + KEY_ARTI + " VARCHAR)";
        db.execSQL(BUAT_TABEL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABEL);
        onCreate(db);
    }

}
