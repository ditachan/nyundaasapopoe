package com.android.nyundaasapopoe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import com.google.android.material.textfield.TextInputEditText;

public class tambahkata extends AppCompatActivity {

    TextInputEditText GetKata, GetArti;
    Button btnTambah, btnTampilData;
    String isidata, isiarti;
    Boolean CekIsi;
    String SQLiteQuery;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_kata);

        GetKata = findViewById(R.id.isikan_kata);
        GetArti = findViewById(R.id.isikan_arti);

        btnTambah = findViewById(R.id.btntambah);
        btnTambah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BuatDatabase();
                    KirimDataKeDB();
                } });

        btnTampilData = findViewById(R.id.btnTampilData);
        btnTampilData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tambahkata.this, tampilkan.class);
                startActivity(intent);
            }
        });
    }
        private void BuatDatabase() {
            //Database akan dibuat setelah tombol di tekan
            sqLiteDatabase = openOrCreateDatabase("kosakataDB.DB", Context.MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS kosakkata (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, kata VARCHAR, arti varchar);");
        }

        private void KirimDataKeDB() {
                isidata = GetKata.getText().toString() ;
                isiarti = GetArti.getText().toString();

                //CekIsi(isidata,;

            //Boolean empty;
            if (isidata!=null && !isidata.trim().isEmpty()  && isiarti!=null && !isiarti.trim().isEmpty()) {
                    //Jika edit teks tidak kosong, maka disimpan
                    SQLiteQuery = "INSERT INTO kosakkata (kata,arti) VALUES ('" + isidata + "','" + isiarti + "');";
                    sqLiteDatabase.execSQL(SQLiteQuery);
                    Toast.makeText(tambahkata.this, "Data Berhasil di Simpan", Toast.LENGTH_SHORT).show();

                    GetKata.getText().clear();
                    GetArti.getText().clear();

                } else {
                    //Jika kosong, maka tampilkan toast
                    Toast.makeText(tambahkata.this, "Masukkan Data", Toast.LENGTH_SHORT).show();
                }
    }

}






            
        


