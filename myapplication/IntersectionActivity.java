package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntersectionActivity extends AppCompatActivity {

    Button intent_btn;
    Button intent_btn1;
    Button intent_btn2;
    Button intent_btn3;
    TextView intent_btn4;
    TextView intent_btn5;
    TextView intent_btn6;
    TextView intent_btn7;

    protected void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_intersection);

        intent_btn = findViewById(R.id.intersectionbarcode);
        intent_btn1 = findViewById(R.id.intersectionqr);
        intent_btn2 = findViewById(R.id.intersectionmypage);
        intent_btn3 = findViewById(R.id.intersectiononoff);
        intent_btn4 = findViewById(R.id.intertext);
        intent_btn5 = findViewById(R.id.intertext1);
        intent_btn6 = findViewById(R.id.intertext2);
        intent_btn7 = findViewById(R.id.intertext3);

        intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntersectionActivity.this, Photo1Activity.class);
                startActivity(intent);

            }
        });

        intent_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntersectionActivity.this,Photo2Activity.class);
                startActivity(intent);
            }
        });

        intent_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntersectionActivity.this, MyPageActivity.class);
                startActivity(intent);
            }
        });

        intent_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        intent_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntersectionActivity.this,Photo1Activity.class);
                startActivity(intent);
            }
        });

        intent_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntersectionActivity.this,Photo2Activity.class);
                startActivity(intent);
            }
        });

        intent_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntersectionActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        intent_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

    }
}
