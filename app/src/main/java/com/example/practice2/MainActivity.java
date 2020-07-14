package com.example.practice2;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Chronometer chr;
    Button but1, but2;
    RadioButton rdo1, rdo2;
    CalendarView cal;
    TimePicker tp;
    TextView tv1, tv2, tv3, tv4, tv5;
    int selectYear, selectMonth, selectDay; // 캘린더뷰에서 선택할 연, 월, 일에 해당하는 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 에약!!");

        // 12개의 위젯 변수에 대입
        but1 = (Button) findViewById(R.id.start_button);
        but2 = (Button) findViewById(R.id.end_button);
        chr = (Chronometer) findViewById(R.id.res);
        rdo1 = (RadioButton) findViewById(R.id.rdoCal);
        rdo2 = (RadioButton) findViewById(R.id.rdoTime);
        tp = (TimePicker) findViewById(R.id.tp);
        cal = (CalendarView) findViewById(R.id.cal);
        tv1 = (TextView) findViewById(R.id.year);
        tv2 = (TextView) findViewById(R.id.month);
        tv3 = (TextView) findViewById(R.id.day);
        tv4 = (TextView) findViewById(R.id.hour);
        tv5 = (TextView) findViewById(R.id.min);

        // 타임피커와 캘린더뷰를 보이지 않게 설정
        tp.setVisibility(View.INVISIBLE);
        cal.setVisibility(View.INVISIBLE);

        rdo1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ // 날짜 선택 라디오 버튼을 클릭하면 캘린더뷰만 보이도록 설정
                tp.setVisibility(View.INVISIBLE);
                cal.setVisibility(View.VISIBLE);
            }
        });
        rdo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {// 시간 선택 라디오 버튼을 클릭하면 타임피커만 보이도록 설정
                tp.setVisibility(View.VISIBLE);
                cal.setVisibility(View.INVISIBLE);
            }
        });
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chr.setBase(SystemClock.elapsedRealtime()); // 크로미터를 0으로 초기화
                chr.start(); // 크로미터 시작
                chr.setTextColor(Color.RED); // 타이머가 시작되면 글자를 빨간색으로 설정
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chr.stop(); // 크로미터 정지
                chr.setBackgroundColor(Color.BLUE); // 타이머가 정지도면 글자를 파란색으로 설정
                // 캘린더에서 선택한 연,월,일을 해당하는 택스트뷰에 채움
                tv1.setText(Integer.toString(selectYear));
                tv2.setText(Integer.toString(selectMonth));
                tv3.setText(Integer.toString(selectDay));
                // 타임피커에서 설정한 시간과 분을 구해서 해당하는 텍스트뷰에 채움
                tv4.setText(Integer.toString(tp.getCurrentHour()));
                tv5.setText(Integer.toString(tp.getCurrentMinute()));
            }
        });
        // 1. 캘린더뷰를 클릭하면 클릭한 연월일이 전역변수에 대입
        // 2. 월은 0부터 시작해서 1을 더함
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                selectYear = i;
                selectMonth = i1+1;
                selectDay = i2;
            }
        });
    }
}