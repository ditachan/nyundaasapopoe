package com.android.nyundaasapopoe;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Splashscreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pindah = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(pindah);
                finish();
            }
        },2000);
    }
}