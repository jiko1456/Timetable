package com.example.timetable;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton timetablebtn;
    //임시 버튼( 각 시간표)
    TextView mon1, mon2, mon3, mon4, mon5, mon6, mon7, mon8, mon9;
    TextView tue1, tue2, tue3, tue4, tue5, tue6, tue7, tue8, tue9;
    TextView wed1, wed2, wed3, wed4, wed5, wed6, wed7, wed8, wed9;
    TextView thu1, thu2, thu3, thu4, thu5, thu6, thu7, thu8, thu9;
    TextView fri1, fri2, fri3, fri4, fri5, fri6, fri7, fri8, fri9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window win = getWindow();
        win.setContentView(R.layout.activity_main);

        LayoutInflater inflater = (LayoutInflater)getSystemService(

                Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout linear = (LinearLayout)inflater.inflate(R.layout.activity_timetable, null);

        linear.setBackgroundColor(Color.parseColor("#00ff0000"));
        linear.setGravity(Gravity.CENTER);
        linear.setPadding(100,100,100,100);

        //파라미터를 세팅해줌

        LinearLayout.LayoutParams paramlinear = new LinearLayout.LayoutParams(

                LinearLayout.LayoutParams.MATCH_PARENT,

                LinearLayout.LayoutParams.MATCH_PARENT

        );



        //윈도우에 추가시킴
        win.addContentView(linear, paramlinear);

        //시간표 추가
        timetablebtn = (ImageButton) findViewById(R.id.timetablebtn);
        timetablebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TimetalbleADD.class); //시간표 추가 화면 팝업.
                startActivity(intent);
            }
        });

        //대표로 한가지만 구현
        mon1 = (TextView) findViewById(R.id.mon1);
        mon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder
                        .setMessage("8_육영관") //예시로 하드코딩
                        .setCancelable(false)
                        .setPositiveButton("위치보기", new DialogInterface.OnClickListener() { //길찾기 기능 제외로 단어 변경
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class); //예비화면으로 전환
                                startActivity(intent);
                            }
                        })
                        .setNeutralButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

}

