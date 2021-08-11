package com.android.nyundaasapopoe;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SQLHelper SQLHelper;
    AlertDialog.Builder builder;
    Button katalog_benda, tebak_benda, petunjuk, papanPoint;
    Button tambah_kata, tampil_kata, tebak_kata, info_app;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //Toolbar toolbar = (Toolbar) findViewById(R.id.Toolbar);
            //setSupportActionBar(toolbar);
            //myDbHelper();

            tambah_kata = (Button) findViewById(R.id.btnTambahKata);
            tampil_kata = (Button) findViewById(R.id.btnTampilkan);
            tebak_kata = (Button) findViewById(R.id.btnTebakKata);
            info_app = (Button) findViewById(R.id.btnPetunjuk);

            tambah_kata.setOnClickListener(this);
            tampil_kata.setOnClickListener(this);
            tebak_kata.setOnClickListener(this);
            info_app.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.btnTambahKata:
                i = new Intent(this, tambahkata.class);
                startActivity(i);
                break;
            case R.id.btnTampilkan:
                i = new Intent(this, tampilkan.class);
                startActivity(i);
                break;
            case R.id.btnTebakKata:
                i = new Intent(this, tebakkata.class);
                startActivity(i);
                break;
            case R.id.btnPetunjuk:
                i = new Intent(this, infoapp.class);
                startActivity(i);
                break;
        }
    }
        public void onBackPressed() {
        keluar();
    }
        public void keluar() {
            builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Apakah kamu yakin ingin keluar ?")
                    .setCancelable(true)
                    .setPositiveButton("IYA", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                            System.exit(0);
                        }
                    })
                    .setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.setTitle("Keluar");
            dialog.show();
        }
}