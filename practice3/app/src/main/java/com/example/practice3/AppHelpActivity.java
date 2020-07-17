/*
세 번째 탭은 xml 파일 없이 자바코드만으로 간다히 화면을 설계했다.
앱 이름과 제작자 이름을 표시하기 위해 TextView 객체 textview를 만든 후에 setText 메소드를 사용하여 textview에 문자를 입력한다.
그리고 setContentView 메소드를 사용해서 textview를 화면에 나오도록 설정한다.
 */

package com.example.practice3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AppHelpActivity extends Activity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        TextView textview = new TextView(this);
        textview.setTextSize(20);
        textview.setText("피코메모장" + "\n" + "제작자 : 오현식");
        setContentView(textview);
    }
}
