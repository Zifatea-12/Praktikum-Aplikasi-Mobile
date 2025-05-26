package com.example.aplikasiinputnama;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView lblNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        lblNama = findViewById(R.id.Lbl_NamaTampil);
        String nama = getIntent().getStringExtra("NAMA_PENGGUNA");
        lblNama.setText("Halo, " + nama + " 💖");
    }

    public void Kembali(View view) {
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right); // animasi kembali
    }
}
