package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SearchActivity2 extends AppCompatActivity {

    FloatingActionButton intent_btn;
    android.widget.CompoundButton intent_btn1;
    Button intent_btn2;
    ImageButton intent_btn3;
    Button intent_btn4;
    Button intent_btn5;
    Button intent_btn6;
    Button intent_btn7;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);

        intent_btn = findViewById(R.id.search2fab);
        intent_btn1 = findViewById(R.id.search2switch);
        intent_btn2 = findViewById(R.id.search2button);
        intent_btn3 = findViewById(R.id.search2share);
        intent_btn4 = findViewById(R.id.search2_naver);
        intent_btn5 = findViewById(R.id.search2_junggo);
        intent_btn6 = findViewById(R.id.search2_google);
        intent_btn7 = findViewById(R.id.search2_amazon);

        intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity2.this, Photo1Activity.class);
                startActivity(intent);
            }
        });

        intent_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity2.this, Profile2Activity.class);
                startActivity(intent);
            }
        });

        intent_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity2.this,IntersectionActivity.class);
                startActivity(intent);
            }
        });

        intent_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"전달할 메시지");
                startActivity(Intent.createChooser(intent,"공유하기"));
            }
        });
        intent_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity2.this, SearchActivity1.class);
                intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        intent_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity2.this, SearchActivity2.class);
                intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        intent_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity2.this, SearchActivity3.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        intent_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity2.this, SearchActivity4.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            }
        });

    }

}
