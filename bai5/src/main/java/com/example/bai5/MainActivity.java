package com.example.bai5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnTinhTT,btnTiep,btnThongKe,btnEnd;
    EditText edtHoTen;
    EditText edtSoLuong;

    TextView TongKH,VIP,DoanhThu;
    TextView TTTen,TTSoLuong,TTTongTien;
    TextView TongTien;
    List<Double> listTT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listTT = new ArrayList<>();

        AnhXa();

        btnTinhTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String soluong= edtSoLuong.getText().toString();
                 int so = Integer.parseInt(soluong);
                 double tongTien = so * 20000;
                 listTT.add(tongTien);
                 TongTien.setText(""+tongTien);
            }
        });

        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TTTongTien.setText(TongTien.getText());
            }
        });


        btnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double tongDoangThu = 0;
                for(double tien : listTT){
                    tongDoangThu += tien;
                }
                DoanhThu.setText(""+tongDoangThu);
            }
        });
    }

    public void AnhXa(){
        btnTinhTT = (Button) findViewById(R.id.btnTinhTT);
        btnTiep = (Button) findViewById(R.id.btnTiep);
        btnThongKe = (Button) findViewById(R.id.btnThongKe);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        edtHoTen = (EditText) findViewById(R.id.edtHoTen);
        edtSoLuong = (EditText) findViewById(R.id.edtSoLuong);

        TongTien = (TextView) findViewById(R.id.TongTien);
        TongKH = (TextView) findViewById(R.id.TongKH);
        VIP = (TextView) findViewById(R.id.VIP);
        DoanhThu = (TextView) findViewById(R.id.DoanhThu);
        TTTen = (TextView) findViewById(R.id.TTTen);
        TTSoLuong = (TextView) findViewById(R.id.TTSoLuong);
        TTTongTien = (TextView) findViewById(R.id.TTTongTien);
    }
}
