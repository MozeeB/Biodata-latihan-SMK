package com.example.mozeeb.biodata;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatBiodata extends AppCompatActivity {
    //deklarasi variable
    DataHelper dbHelper;
    Button simpan, kembali;
    EditText nomor, namamu, tgl_lahir, kelas, alamat, jurusan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        dbHelper = new DataHelper(this);
        nomor = (EditText)findViewById(R.id.nomor);
        namamu = (EditText)findViewById(R.id.nama);
        tgl_lahir = (EditText)findViewById(R.id.tgl_lahir);
        kelas = (EditText)findViewById(R.id.kelas);
        alamat = (EditText)findViewById(R.id.alamat);
        jurusan = (EditText)findViewById(R.id.jurusan);

        simpan = (Button)findViewById(R.id.simpan);
        kembali = (Button)findViewById(R.id.kembali);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO biodata(no, nama, tgl, kelas, alamat, jurusan) VALUES ('" +
                        nomor.getText().toString() +"','"+
                        namamu.getText().toString() +"','"+
                        tgl_lahir.getText().toString()+"','"+
                        kelas.getText().toString() + "','"+
                        alamat.getText().toString()+"','"+
                        jurusan.getText().toString()+"')");
                Toast.makeText(getApplicationContext(), "Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                MainActivity.mainActivity.RefreshLink();
                finish();
            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
