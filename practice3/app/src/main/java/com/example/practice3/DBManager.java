/*
    여기서는 csc 이름의 DB를 만들고 diaryTB 이름의 테이블을 설계했다.
    테이블은 2개의 텍스트 유형을 만들었고, 첫 번째 텍스트에는 날짜, 두 번째 텍스트에는 내용이 저장된다.

    SQLiteOpenHelper     onCreate()              Create Table 명령을 사용해 테이블을 생성한다.
                         getWritableDatabase()   쓰고 읽을 수 있는 db를 연다.
    SQLiteDatabase Class exeSQL()                Insert info 레코드를 테이블에 추가하기
                                                 Update SET  존재하는 레코드값 변경하기
                                                 Delete      테이블에서 레코드 삭제하기
                         close()                 DB 닫기     db 객체 닫기
                         query()                 query()를 실행 후 커서를 반환
    Cursor Interface     moveToFirst()           커서를 레코드 제일 첫 번째 행으로 이동
                         getString()             커서가 가리키는 곳의 데이터를 가져옴
                         moveToPosition(i)       커서를 원하는 위치에 놓음
                         close()                 커서 사용 후 커서를 반드시 닫아 주어야 함
*/

package com.example.practice3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {
    public DBManager(Context context){ super(context, "csc", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db){ db.execSQL("Create table diaryTB (datal text, data2 text);");}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}
}
