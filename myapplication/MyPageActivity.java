package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MyPageActivity extends AppCompatActivity {

    FloatingActionButton intent_btn;
    Button intent_btn1;
    ImageButton intent_btn2;
    Button intent_btn3;
    Button intent_btn4;
    Button intent_btn5;
    Button intent_btn10;
    TextView intent_btn6;
    TextView intent_btn7;
    TextView intent_btn8;
    TextView intent_btn9;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        intent_btn = findViewById(R.id.mypage_fab);
        intent_btn1 = findViewById(R.id.mypage_button);
        intent_btn2 = findViewById(R.id.mypage_sharebtn);
        intent_btn10 = findViewById(R.id.mypage_barcode);
        intent_btn3 = findViewById(R.id.mypgae_qr);
        intent_btn4 = findViewById(R.id.mypage_mylog);
        intent_btn5 = findViewById(R.id.mypage_logout);
        intent_btn6 = findViewById(R.id.mypge_text);
        intent_btn7 = findViewById(R.id.mypage_text1);
        intent_btn8 = findViewById(R.id.mypage_text2);
        intent_btn9 = findViewById(R.id.mypage_text3);

        intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this,Photo2Activity.class);
                startActivity(intent);
            }
        });

        intent_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, IntersectionActivity.class);
                startActivity(intent);
            }
        });

        intent_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"전달할 메시지");
                startActivity(Intent.createChooser(intent,"공유하기"));
            }
        });
        intent_btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });
        intent_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, History2Activity.class);
                startActivity(intent);
            }
        });
        intent_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        intent_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

        intent_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        intent_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, History2Activity.class);
                startActivity(intent);
            }
        });
        intent_btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        intent_btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}
