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

    EditText lecName_ed, proName_ed, detail_lecRoom_ed;
    String lecName, proName, detail_lecRoom;
    Spinner startLec_sp, finshLec_sp, lecRoom_sp, lecDay_sp;
    String startTime, finishTime, lecLoc, lecDay;
    TextView cancelBtn, addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기.
        setContentView(R.layout.activity_timetalble_add);

        // EditText 값 저장.
        lecName_ed = (EditText)findViewById(R.id.lecName);
        proName_ed = (EditText)findViewById(R.id.proName);
        detail_lecRoom_ed = (EditText)findViewById(R.id.detail_lecRoom);
        lecName = lecName_ed.getText().toString();
        proName  = proName_ed.getText().toString();
        detail_lecRoom = detail_lecRoom_ed.getText().toString();

        // 스피너.
        startLec_sp = (Spinner)findViewById(R.id.StartLec_sp);
        finshLec_sp = (Spinner)findViewById(R.id.FinishLec_sp);
        lecRoom_sp = (Spinner)findViewById(R.id.LecRoom_sp);
        lecDay_sp = (Spinner)findViewById(R.id.LecDay_sp);
        // 스피너 아이템 클릭 이벤트.
        startLec_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                startTime = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        finshLec_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                finishTime = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lecDay_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lecDay = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lecRoom_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lecLoc = String.valueOf(parent.getItemAtPosition(position));
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
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("lecName", lecName);
                intent.putExtra("proName", proName);
                intent.putExtra("lecDay", lecDay);
                intent.putExtra("startLec", startTime);
                intent.putExtra("finishLec", finishTime);
                intent.putExtra("detail_lecRoom", detail_lecRoom);
                intent.putExtra("lecLoc", lecLoc);
                startActivity(intent);
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