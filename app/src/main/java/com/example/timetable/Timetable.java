package com.example.timetable;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Timetable extends AppCompatActivity {

    ImageButton timetablebtn;
    //임시 버튼( 각 시간표)
    Button mon1, mon2, mon3, mon4, mon5, mon6, mon7, mon8, mon9;
    Button tue1, tue2, tue3, tue4, tue5, tue6, tue7, tue8, tue9;
    Button wed1, wed2, wed3, wed4, wed5, wed6, wed7, wed8, wed9;
    Button thu1, thu2, thu3, thu4, thu5, thu6, thu7, thu8, thu9;
    Button fri1, fri2, fri3, fri4, fri5, fri6, fri7, fri8, fri9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        //시간표 버튼
        timetablebtn = (ImageButton) findViewById(R.id.timetablebtn);
        timetablebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class); //예비화면으로 전환
                startActivity(intent);
            }
        });

        //대표로 한가지만 구현
        mon1 = (Button) findViewById(R.id.mon1);
        mon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Timetable.this);
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

