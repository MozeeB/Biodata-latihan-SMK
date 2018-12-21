package com.example.mozeeb.biodata;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBiodata extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    EditText nomor, nama, tgl_lahir, kelas, alamat, jurusan;
    Button update, kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);

        dbHelper = new DataHelper(this);

        nomor = (EditText)findViewById(R.id.update_nomor);
        nama = (EditText)findViewById(R.id.update_nama);
        tgl_lahir = (EditText)findViewById(R.id.update_tgl_lahir);
        kelas = (EditText)findViewById(R.id.update_kelas);
        alamat = (EditText)findViewById(R.id.update_alamat);
        jurusan = (EditText)findViewById(R.id.update_jurusan);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '"+
                getIntent().getStringExtra("nama") +"'", null);
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
        update = (Button)findViewById(R.id.update);
        kembali = (Button)findViewById(R.id.update_kembali);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                db.execSQL("UPDATE biodata SET nama = '"+
                        nama.getText().toString()+"', tgl='" +
                        tgl_lahir.getText().toString()+"',kelas=B'"+
                        kelas.getText().toString()+"', alamat='"+
                        alamat.getText().toString()+"', jurusan='"+
                        jurusan.getText().toString()+"' WHERE no ='"+
                        nomor.getText().toString()+"'");
                Toast.makeText(getApplicationContext(),"Update berhasil", Toast.LENGTH_SHORT).show();
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
