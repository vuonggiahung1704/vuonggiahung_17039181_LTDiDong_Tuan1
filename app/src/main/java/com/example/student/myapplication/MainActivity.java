package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnTong,btnHieu,btnTich,btnThuong,btnUocChung,btnThoat;
    TextView textViewKQ;
    EditText edtSoA;
    EditText edtSoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkNhapSo() == true){
                    Float a = getA();
                    Float b = getB();
                    float KQ = a+b;
                    textViewKQ.setText(""+KQ);
                }else{
                    Toast.makeText(MainActivity.this,"Vui lòng nhập số",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkNhapSo() == true){
                    Float a = getA();
                    Float b = getB();
                    float KQ = a-b;
                    textViewKQ.setText(""+KQ);
                }else{
                    Toast.makeText(MainActivity.this,"Vui lòng nhập số",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkNhapSo() == true){
                    Float a = getA();
                    Float b = getB();
                    float KQ = a*b;
                    textViewKQ.setText(""+KQ);
                }else{
                    Toast.makeText(MainActivity.this,"Vui lòng nhập số",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkNhapSo() == true){
                    Float a = getA();
                    Float b = getB();
                    float KQ = a/b;
                    textViewKQ.setText(""+KQ);
                }else{
                    Toast.makeText(MainActivity.this,"Vui lòng nhập số",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnUocChung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkNhapSo() == true){
                    Float a = getA();
                    Float b = getB();
                    float KQ = tinhUocChung(a,b);
                    textViewKQ.setText(""+KQ);
                }else{
                    Toast.makeText(MainActivity.this,"Vui lòng nhập số",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void AnhXa(){
        edtSoA = (EditText) findViewById(R.id.edtSoA);
        edtSoB = (EditText) findViewById(R.id.edtSoB);

        textViewKQ = (TextView) findViewById(R.id.textViewKQ);

        btnTong = (Button) findViewById(R.id.btnTong);
        btnHieu = (Button) findViewById(R.id.btnHieu);
        btnTich = (Button) findViewById(R.id.btnTich);
        btnThuong = (Button) findViewById(R.id.btnThuong);
        btnUocChung = (Button) findViewById(R.id.btnUocChung);
        btnThoat = (Button) findViewById(R.id.btnThoat);
    }

    public boolean checkNhapSo(){
        String SoA = edtSoA.getText().toString();
        String SoB = edtSoB.getText().toString();

        if( SoA.equals("") || SoB.equals("")){
            return false;
        }
        return true;
    }
    public float getA(){
        String SoA = edtSoA.getText().toString();
        Float a = Float.parseFloat(SoA);
        return a;
    }
    public float getB(){
        String SoB = edtSoB.getText().toString();
        Float b = Float.parseFloat(SoB);
        return b;
    }

    public float tinhUocChung(float a, float b){
        if(a==0 || b==0)
            return a+b;
        while(a != b){
            if(a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }
        return a;
    }
}
