package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileActivity extends AppCompatActivity {



    FloatingActionButton intent_btn;
    android.widget.CompoundButton intent_btn1;
    TextView receiveView;
    Button intent_btn2;
    Button intent_btn3;
    ImageButton intent_btn4;
    Button intent_btn5;
    ImageButton intent_btn6;
    MenuItem mSearch;
    SearchView searchView;



    @Override
    protected void onCreate( Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);




        receiveView = findViewById(R.id.profiletextView);
        intent_btn = findViewById(R.id.fab1);
        intent_btn1 = findViewById(R.id.switch1);
        intent_btn2 = findViewById(R.id.profilebutton);
        intent_btn3 = findViewById(R.id.profilehistory);
        intent_btn4 = findViewById(R.id.profilesharebtn);
        intent_btn5 = findViewById(R.id.profilelogout);
        intent_btn6 = findViewById(R.id.profilesearchbtn3);

        SharedPreferences sharedPreferences= getSharedPreferences("test", MODE_PRIVATE);    // test 이름의 기본모드 설정, 만약 test key값이 있다면 해당 값을 불러옴.
        String inputText = sharedPreferences.getString("inputText","");
        receiveView.setText(inputText);    // TextView에 SharedPreferences에 저장되어있던 값 찍기.

        /*Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        receiveView.setText(name);*/

        intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, Photo1Activity.class);
                startActivity(intent);


            }
        });

        intent_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, Profile2Activity.class);
                startActivity(intent);


            }
        });

        intent_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, IntersectionActivity.class);
                startActivity(intent);

            }
        });

        intent_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HistoryActivity.class);
                startActivity(intent);

            }
        });
        intent_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "전달할 메시지");
                startActivity(Intent.createChooser(intent, "공유하기"));
            }
        });

        intent_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

       /* Intent intent = getIntent();
        String receiveStr =intent.getExtras().getString("send_data");

        receiveView = (TextView) findViewById(R.id.profiletextView);
        receiveView.setText(receiveStr);*/



    }

    }

