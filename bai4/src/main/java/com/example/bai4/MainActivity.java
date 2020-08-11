package com.example.bai4;

import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText edtTT;
    EditText edtHoTen;
    EditText edtCMND;
    Button btnGui;
    RadioButton radio1,radio2,radio3;
    CheckBox checkbox1,checkbox2,checkbox3;

    String bangcap;
    String sothich;
    List<String> listSoThich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        listSoThich = new ArrayList<>();

        radio1.setOnCheckedChangeListener(listenerRadio);
        radio2.setOnCheckedChangeListener(listenerRadio);
        radio3.setOnCheckedChangeListener(listenerRadio);

        checkbox1.setOnCheckedChangeListener(m_listener);
        checkbox2.setOnCheckedChangeListener(m_listener);
        checkbox3.setOnCheckedChangeListener(m_listener);

        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = edtHoTen.getText().toString();
                String CMND = edtCMND.getText().toString();
                String regexHoTen = "^[A-Za-z]{3}([A-Za-z ]*)";
                String regexCMND = "[0-9]{9}";
                if(checkNhap(edtHoTen,regexHoTen)== -1){
                    Toast.makeText(MainActivity.this,"Vui lòng nhập họ tên",Toast.LENGTH_LONG).show();
                }
                else if(checkNhap(edtHoTen,regexHoTen)== 1){
                    Toast.makeText(MainActivity.this,"Vui lòng nhập họ tên đúng",Toast.LENGTH_LONG).show();
                }
                else if(checkNhap(edtCMND,regexCMND)== -1){
                    Toast.makeText(MainActivity.this,"Vui lòng nhập số CMND",Toast.LENGTH_LONG).show();
                }
                else if(checkNhap(edtCMND,regexCMND)== 1){
                    Toast.makeText(MainActivity.this,"Vui lòng nhập số CMND đúng",Toast.LENGTH_LONG).show();
                }
                else if(listSoThich.size() < 1){
                    Toast.makeText(MainActivity.this,"Vui lòng chọn sở thích",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,hoTen + CMND + bangcap + listSoThich.get(0),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AnhXa(){
        edtHoTen = (EditText) findViewById(R.id.edtHoTen);
        edtCMND = (EditText) findViewById(R.id.edtCMND);
        edtTT = (EditText) findViewById(R.id.edtCMND);

        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        radio3 = (RadioButton) findViewById(R.id.radio3);

        checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkbox3 = (CheckBox) findViewById(R.id.checkbox3);

        btnGui = (Button) findViewById(R.id.btnGui);
    }

    public int checkNhap(EditText edt,String regex){
        String chuoi = edt.getText().toString();
        if(chuoi.equals("")){
            return -1;
        }
        if(Pattern.matches(regex,chuoi)==false){
            return 1;
        }
        return 0;
    }

    CompoundButton.OnCheckedChangeListener listenerRadio = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                bangcap = compoundButton.getText().toString();
            }
        }
    };


    CompoundButton.OnCheckedChangeListener m_listener
            = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            sothich = compoundButton.getText().toString();
            listSoThich.add(sothich);
            Toast.makeText(compoundButton.getContext(),
                        compoundButton.getText() + " | "
                                + compoundButton.isChecked(),
                        Toast.LENGTH_SHORT).show();
            }
    };


}
