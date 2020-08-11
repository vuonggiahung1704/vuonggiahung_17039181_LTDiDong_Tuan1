package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnF,btnC,btnClear;
    EditText edtF;
    EditText edtC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkNhapSo(edtC)==true){
                    float C = getA(edtC);
                    float F = C * (9/5) + 32 ;
                    edtF.setText(""+F);
                }else{
                    Toast.makeText(MainActivity.this,"Vui lòng nhập nhiệt độ C",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkNhapSo(edtF)==true){
                    float F = getA(edtF);
                    float C = (F - 32) * (5/9) ;
                    edtC.setText(""+C);
                }else{
                    Toast.makeText(MainActivity.this,"Vui lòng nhập nhiệt độ F",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtF.setText("");
                edtC.setText("");
            }
        });
    }

    public void AnhXa(){
        edtF = (EditText) findViewById(R.id.edtF);
        edtC = (EditText) findViewById(R.id.edtC);
        btnC = (Button) findViewById(R.id.btnC);
        btnF = (Button) findViewById(R.id.btnF);
        btnClear = (Button) findViewById(R.id.btnClear);
    }

    public boolean checkNhapSo(EditText edt){
        String So = edt.getText().toString();

        if( So.equals("")){
            return false;
        }
        return true;
    }
    public float getA(EditText edt){
        String So = edt.getText().toString();
        Float a = Float.parseFloat(So);
        return a;
    }
}
