package com.example.practice1;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button but1, but2, but3, but4;
    TextView textResult;
    String num1, num2;  // 에디트텍스트에 입력한 문자열값을 저장할 변수 선언
    Integer result;     // 두 문자열을 계산한 결과 저장할 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("4칙연산 계산깅");

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        but1 = (Button) findViewById(R.id.add_button);
        but2 = (Button) findViewById(R.id.sub_button);
        but3 = (Button) findViewById(R.id.mul_button);
        but4 = (Button) findViewById(R.id.div_button);
        textResult = (TextView) findViewById(R.id.TextResult);

        but1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1!=null && num2!=null) {
                    result = Integer.parseInt(num1) + Integer.parseInt(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
                else
                    Toast.makeText(getApplicationContext(), "숫자를 입력하라.", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        but2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1!=null && num2!=null) {
                    result = Integer.parseInt(num1) - Integer.parseInt(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
                else
                    Toast.makeText(getApplicationContext(), "숫자를 입력하라.", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        but3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1!=null && num2!=null) {
                    result = Integer.parseInt(num1) * Integer.parseInt(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
                else
                    Toast.makeText(getApplicationContext(), "숫자를 입력하라.", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        but4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1!=null && num2!=null) {
                    result = Integer.parseInt(num1) / Integer.parseInt(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
                else
                    Toast.makeText(getApplicationContext(), "숫자를 입력하라.", Toast.LENGTH_SHORT).show();
                if(num2!="0"){
                    result = Integer.parseInt(num1) / Integer.parseInt(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
                else
                    Toast.makeText(getApplicationContext(), "0으로 못 나눔 ㅅㅅ", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}