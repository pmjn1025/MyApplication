package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Profile2Activity extends AppCompatActivity {

    FloatingActionButton intent_btn;
    android.widget.CompoundButton intent_btn1;
    Button intent_btn2;
    Button intent_btn3;
    ImageButton intent_btn4;
    Button intent_btn5;
    TextView receiveView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        intent_btn = findViewById(R.id.Qrfab);
        intent_btn1 = findViewById(R.id.Qrswitch);
        intent_btn2 = findViewById(R.id.qrbutton);
        //intent_btn3= findViewById(R.id.locationhistory);
        intent_btn4= findViewById(R.id.profile2share);
        //intent_btn5 = findViewById(R.id.profile2logout);
        receiveView = findViewById(R.id.profile2textView);

        SharedPreferences sharedPreferences= getSharedPreferences("test", MODE_PRIVATE);    // test 이름의 기본모드 설정, 만약 test key값이 있다면 해당 값을 불러옴.
        String inputText = sharedPreferences.getString("inputText","");
        receiveView.setText(inputText);    // TextView에 SharedPreferences에 저장되어있던 값 찍기.


        intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile2Activity.this, Photo2Activity.class);
                startActivity(intent);

            }
        });

        intent_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile2Activity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        intent_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile2Activity.this,IntersectionActivity.class);
                startActivity(intent);
            }
        });

        /*intent_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile2Activity.this, History2Activity.class);
                startActivity(intent);
            }
        });*/
        intent_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"전달할 메시지");
                startActivity(Intent.createChooser(intent,"공유하기"));
            }
        });

       /* intent_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile2Activity.this, LoginActivity.class);
                startActivity(intent);
            }
        });*/


    }
}
