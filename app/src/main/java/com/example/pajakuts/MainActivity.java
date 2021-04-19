package com.example.pajakuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DataPajak> arrDataPajak = new ArrayList<>();

    EditText etNama, etMobil1, etMobil2, etMobil3;
    Button btnSave, btnView;

    private int jumlahData = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Edit Text
        etNama = (EditText) findViewById(R.id.etNama);
        etMobil1 = (EditText) findViewById(R.id.etMobil1);
        etMobil2 = (EditText) findViewById(R.id.etMobil2);
        etMobil3 = (EditText) findViewById(R.id.etMobil3);
        // Button
        btnSave = (Button) findViewById(R.id.btnSave);
        btnView = (Button) findViewById(R.id.btnView);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etNama.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Nama harus diisi!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(etMobil1.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Nilai Jual Mobil 1 harus diisi!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(etMobil2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Nilai Jual Mobil 2 harus diisi!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(etMobil3.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Nilai Jual Mobil 3 harus diisi!", Toast.LENGTH_SHORT).show();
                    return;
                }

                saveDataPajak(etNama.getText().toString(), Integer.parseInt(etMobil1.getText().toString()),
                        Integer.parseInt(etMobil2.getText().toString()),
                        Integer.parseInt(etMobil3.getText().toString()));
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jumlahData == 0) {
                    Toast.makeText(getApplicationContext(), "Data dalam Array masih kosong, silahkan input data terlebih dahulu!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent totalPajak = new Intent(MainActivity.this, TotalPajakActivity.class);
                    totalPajak.putParcelableArrayListExtra("dataPajak", arrDataPajak);
                    totalPajak.putExtra("jumlahData", jumlahData);
                    startActivity(totalPajak);
                }
            }
        });
    }

    private void saveDataPajak(String username, int mobil1, int mobil2, int mobil3) {
        if(jumlahData < 10) {
            try {
                arrDataPajak.add(new DataPajak(username, mobil1, mobil2, mobil3));

                Toast.makeText(getApplicationContext(), "Data Berhasil di Simpan!", Toast.LENGTH_SHORT).show();
                jumlahData = arrDataPajak.size();

                etNama.setText("");
                etMobil1.setText("");
                etMobil2.setText("");
                etMobil3.setText("");
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Data Gagal di Simpan!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Data Array sudah Penuh!", Toast.LENGTH_SHORT).show();
        }
    }
}