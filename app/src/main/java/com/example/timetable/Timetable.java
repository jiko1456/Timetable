package com.example.timetable;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Timetable extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        text = (TextView) findViewById(R.id.mon9);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.text:
                        new AlertDialog.Builder(Timetable.this)
                                .setTitle("알람 팝업")
                                .setMessage("팝업 창의 내용입니다.\n\n TEST!!")
                                .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dlg, int sumthin) {
                                    }
                                })
                                .show(); // 팝업창 보여줌

                        break;
                }
            }
        });
    }
}

