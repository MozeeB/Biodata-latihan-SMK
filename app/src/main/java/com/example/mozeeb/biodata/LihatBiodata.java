package com.example.mozeeb.biodata;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LihatBiodata extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button kembali;
    TextView nomor, nama , tgl_lahir, kelas, alamat, jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);

        dbHelper = new DataHelper(this);

        nomor = (TextView)findViewById(R.id.lihat_nomor);
        nama = (TextView)findViewById(R.id.lihat_nama);
        tgl_lahir = (TextView)findViewById(R.id.lihat_tgl_lahir);
        kelas = (TextView)findViewById(R.id.lihat_kelas);
        alamat = (TextView)findViewById(R.id.lihat_alamat);
        jurusan = (TextView)findViewById(R.id.lihat_jurusan);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '"+
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            nomor.setText(cursor.getString(0).toString());
            nama.setText(cursor.getString(1).toString());
            tgl_lahir.setText(cursor.getString(2).toString());
            kelas.setText(cursor.getString(3).toString());
            alamat.setText(cursor.getString(4).toString());
            jurusan.setText(cursor.getString(5).toString());

        }
        kembali = (Button)findViewById(R.id.lihat_kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
