package com.example.pajakuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TotalPajakActivity extends AppCompatActivity {

    ArrayList<DataPajak> arrDataPajak;
    Button btnPrevious, btnNext;
    TextView tvNama, tvMobil1, tvMobil2, tvMobil3, tvTotalPajak;
    int jumlahData = 0;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_pajak);

        tvNama = (TextView) findViewById(R.id.tvNama);
        tvMobil1 = (TextView) findViewById(R.id.tvMobil1);
        tvMobil2 = (TextView) findViewById(R.id.tvMobil2);
        tvMobil3 = (TextView) findViewById(R.id.tvMobil3);
        tvTotalPajak = (TextView) findViewById(R.id.tvTotalPajak);

        btnPrevious = (Button) findViewById(R.id.btnPrevious);
        btnNext = (Button) findViewById(R.id.btnNext);

        Intent intent = getIntent();
        arrDataPajak = intent.getParcelableArrayListExtra("dataPajak");
        jumlahData = intent.getIntExtra("jumlahData", 0);

        if(jumlahData>0) {
            showData(0);
        }

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((index-1) < 0) {
                    Toast.makeText(getApplicationContext(), "Data sudah Paling Awal!", Toast.LENGTH_SHORT).show();
                } else {
                    index--;
                    showData(index);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((index+1)<jumlahData) {
                    index++;
                    showData(index);
                } else {
                    Toast.makeText(getApplicationContext(), "Data sudah Paling Akhir!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showData(int index) {

        String nama = arrDataPajak.get(index).getNama();
        int mobil1 = arrDataPajak.get(index).getMobil1();
        int mobil2 = arrDataPajak.get(index).getMobil2();
        int mobil3 = arrDataPajak.get(index).getMobil3();
        double pkb_mobil_1, pkb_mobil_2, pkb_mobil_3;
        double hasil1, hasil2, hasil3, totalPajakBayar;
        int swdkllj = 25000;
        int admin = 10000;

        if(mobil1 == 0) {
            hasil1 = 0;
        } else {
            pkb_mobil_1 = mobil1 * 0.015;
            hasil1 = pkb_mobil_1 + swdkllj + admin;
        }

        if(mobil2 == 0) {
            hasil2 = 0;
        } else {
            pkb_mobil_2 = mobil2 * 0.02;
            hasil2 = pkb_mobil_2 + swdkllj + admin;
        }

        if(mobil2 == 0) {
            hasil3 = 0;
        } else {
            pkb_mobil_3 = mobil3 * 0.025;
            hasil3 = pkb_mobil_3 + swdkllj + admin;
        }

        totalPajakBayar = hasil1 + hasil2 + hasil3;

        tvNama.setText(nama);
        tvMobil1.setText(String.valueOf((int)hasil1));
        tvMobil2.setText(String.valueOf((int)hasil2));
        tvMobil3.setText(String.valueOf((int)hasil3));
        tvTotalPajak.setText(String.valueOf((int)totalPajakBayar));
    }
}