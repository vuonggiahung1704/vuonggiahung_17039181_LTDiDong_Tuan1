package com.example.bai3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnChuyenDoi;
    EditText edtDuong;
    EditText edtAm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        btnChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkNhapSo(edtDuong)){
                    String namAmLich;
                    String can;
                    String chi;
                    int nam = getNam(edtDuong);
                    can = getCan(nam);
                    chi = getChi(nam);
                    namAmLich = can + " " + chi;
                    edtAm.setText(namAmLich);

                }else{
                    Toast.makeText(MainActivity.this,"Vui lòng nhập năm",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AnhXa(){
        edtAm = (EditText) findViewById(R.id.edtAm);
        edtDuong = (EditText) findViewById(R.id.edtDuong);

        btnChuyenDoi = (Button) findViewById(R.id.btnChuyenDoi);
    }

    public boolean checkNhapSo(EditText edt){
        String nam = edt.getText().toString();

        if( nam.equals("")){
            return false;
        }
        return true;
    }

    public int getNam(EditText edt){
        String Nam = edt.getText().toString();
        int a = Integer.parseInt(Nam);
        return a;
    }

    public String getCan(int nam){
        String can = null;
        switch (nam % 10){
            case 0 : can ="Canh";
                break;

            case 1 : can ="Tân";
                break;

            case 2 : can ="Nhâm";
                break;

            case 3 : can ="Quý";
                break;

            case 4 : can ="Giáp";
                break;

            case 5 : can ="Ất";
                break;

            case 6 : can ="Bính";
                break;

            case 7 : can ="Đinh";
                break;

            case 8 : can ="Mậu";
                break;

            case 9 : can ="Ky";
                break;
        }
        return can;
    }

    public String getChi(int nam){
        String chi = null;
        switch (nam % 12){
            case 0 : chi ="Thân";
                break;

            case 1 : chi ="Dậu";
                break;

            case 2 : chi ="Tất";
                break;

            case 3 : chi ="Hợi";
                break;

            case 4 : chi ="Tý";
                break;

            case 5 : chi ="Sửu";
                break;

            case 6 : chi ="Dần";
                break;

            case 7 : chi ="Mão";
                break;

            case 8 : chi ="Thìn";
                break;

            case 9 : chi ="Tỵ";
                break;

            case 10 : chi ="Ngọ";
                break;

            case 11 : chi ="Mùi";
                break;
        }
        return chi;
    }
}
