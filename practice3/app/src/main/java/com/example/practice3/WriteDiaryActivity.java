/*
두 번째 탭을 선택했을 경우 실행되는 Activity.
SQLite insert into 문법를 사용해서 날짜와 메모 내용을 diaryTB 테이블에 저장하도록 했다.
 */
package com.example.practice3;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WriteDiaryActivity extends Activity {
    private DBManager dbmgr;

    @Override
    public void onCreate(Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
        setContentView(R.layout.writediary);

        //Button button = (Button) findViewById(R.id.store_button);
        //button.setOnClickListener(this);
    }

    public void saveData(View v){
        EditText et_name = (EditText) findViewById(R.id.edit_name);
        String diary_date = et_name.getText().toString();

        EditText et_name2 = (EditText) findViewById(R.id.edit_diary);
        String diary_content = et_name2.getText().toString();

        try{
            dbmgr = new DBManager(this);

            SQLiteDatabase sdb = dbmgr.getWritableDatabase();

            sdb.execSQL("insert into diaryTB values('" + diary_date +"', '" + diary_content + "');");
            dbmgr.close();
        } catch(SQLiteException e){}
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }
}
