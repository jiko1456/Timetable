package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TimetalbleADD extends Activity {

    EditText lecName, proName, detail_lecRoom;
    Spinner startLec, finshLec, lecRoom, lecDay;
    int startTime, finishTime;
    String lecLoc;
    TextView cancelBtn, addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기.
        setContentView(R.layout.activity_timetalble_add);

        // 스피너.
        startLec = (Spinner)findViewById(R.id.StartLec_sp);
        finshLec = (Spinner)findViewById(R.id.FinishLec_sp);
        lecRoom = (Spinner)findViewById(R.id.LecRoom_sp);
        lecDay = (Spinner)findViewById(R.id.LecDay_sp);
        // 스피너 아이템 클릭 이벤트.
        startLec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // 취소, 추가 버튼 구현.
        cancelBtn = (TextView)findViewById(R.id.timeAdd_cancel);
        addBtn = (TextView)findViewById(R.id.timeAdd_ok);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

}