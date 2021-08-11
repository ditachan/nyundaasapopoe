package com.android.nyundaasapopoe;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class tampilkan extends AppCompatActivity {

    SQLiteDatabase SQLITEDATABASE;
    SQLHelper SQLHelper;
    SQLiteListAdapter ListAdapter;
    Cursor cursor;

    ArrayList<String> ID_ArrayList = new ArrayList<>();
    ArrayList<String> KATA_ArrayList = new ArrayList<>();
    ArrayList<String> ARTI_ArrayList = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampil_kata);

        listView = findViewById(R.id.list);

        SQLHelper = new SQLHelper(this);
    }

    @Override
    protected void onResume() {

        TampilSQLiteDBData();
        super.onResume();
    }

    private void TampilSQLiteDBData() {
        SQLITEDATABASE = SQLHelper.getWritableDatabase();
        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM kosakkata", null);

        ID_ArrayList.clear();
        KATA_ArrayList.clear();
        ARTI_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do {
               KATA_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLHelper.KEY_KATA)));
               ARTI_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLHelper.KEY_ARTI)));
            } while (cursor.moveToNext());
        }

        ListAdapter = new SQLiteListAdapter(tampilkan.this, ID_ArrayList, KATA_ArrayList, ARTI_ArrayList );

        listView.setAdapter(ListAdapter);
        cursor.close();
    }

}