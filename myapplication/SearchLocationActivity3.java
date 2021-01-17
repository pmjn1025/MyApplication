package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SearchLocationActivity3 extends AppCompatActivity {

    FloatingActionButton intent_btn;
    android.widget.CompoundButton intent_btn1;
    Button intent_btn2;
    ImageButton intent_btn3;
    Button intent_btn4;
    Button intent_btn5;
    Button intent_btn6;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchlocation3);

        intent_btn = findViewById(R.id.searchlocation3fab);
        intent_btn1 = findViewById(R.id.searchlocation3switch);
        intent_btn2 = findViewById(R.id.location3qr);
        intent_btn3 = findViewById(R.id.location3share);
        intent_btn4 = findViewById(R.id.location3google);
        intent_btn5 = findViewById(R.id.location3timeline);
        intent_btn6 = findViewById(R.id.location3makeqr);

        intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchLocationActivity3.this, Photo2Activity.class);
                startActivity(intent);
            }
        });

        intent_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchLocationActivity3.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        intent_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchLocationActivity3.this, IntersectionActivity.class);
                startActivity(intent);
            }
        });

        intent_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"공유할 메시지");
                startActivity(Intent.createChooser(intent,"공유하기"));
            }
        });

        intent_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchLocationActivity3.this, SearchLocationActivity1.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        intent_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchLocationActivity3.this, SearchLocationActivity2.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        intent_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchLocationActivity3.this, SearchLocationActivity3.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });


    }
}
