package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class HistoryActivity extends AppCompatActivity {
    EditText name_et,age_et,price_et;
    Button add_bt;
    RecyclerView rv;
    ListAdapter adapter;
    ItemTouchHelper helper;
    FloatingActionButton intent_btn;
    Button intent_btn1;

    Calendar myCalendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        name_et = findViewById(R.id.name_et);
        age_et = findViewById(R.id.age_et);
        price_et = findViewById(R.id.price_et);
        add_bt = findViewById(R.id.add_bt);
        intent_btn = findViewById(R.id.historyfab);
        intent_btn1 = findViewById(R.id.history_btn);

        EditText et_Date = (EditText) findViewById(R.id.age_et);
        et_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(HistoryActivity.this, myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this, Photo1Activity.class);
                startActivity(intent);
            }
        });

        intent_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this,IntersectionActivity.class);
                startActivity(intent);
            }
        });

        add_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EditText 입력된 값 가져오기
                String name = name_et.getText().toString();
                String price =price_et.getText().toString();
                String age = age_et.getText().toString();

                //이미지 값 세팅
                int image;
                switch (name){
                    case "커피" : {
                        image = R.drawable.icon_maxcoffee;
                        break;
                    }
                    case "초코파이" : {
                        image = R.drawable.icon_chocopie;
                        break;
                    }
                    case "사탕" : {
                        image = R.drawable.icon_candy;
                        break;
                    }
                    case "젤리" : {
                        image = R.drawable.icon_jelly;
                        break;
                    }
                    default: image = R.drawable.icon_b2;
                }

                //Person 객체 생성, 값 세팅
                Person person = new Person();
                person.setName(name);
                person.setAge(age);
                person.setPrice(price);
                person.setImage(image);

                //ListAdapter에 객체 추가
                adapter.additem(person);
                adapter.notifyDataSetChanged();

                //EditText 초기화
                name_et.setText("");
                age_et.setText("");
                price_et.setText("");

                //데이터 추가 확인 토스트 띄우기
                Toast.makeText(HistoryActivity.this, "목록에 추가되었습니다", Toast.LENGTH_SHORT).show();
                name_et.requestFocus();

            }
        });

        rv = findViewById(R.id.rv); //RecyclerView의 레이아웃 방식을 지정
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);

        //RecyclerView의 Adapter 세팅
        adapter = new ListAdapter(this);
        rv.setAdapter((RecyclerView.Adapter) adapter);

        //ItemTouchHelper 생성
        helper = new ItemTouchHelper(new ItemTouchHelperCallback((ItemTouchHelperListener) adapter));
        //RecyclerView에 ItemTouchHelper 붙이기
        helper.attachToRecyclerView(rv);
        //Adapter에 데이터 추가


    }
    private void setUpRecyclerView(){
        rv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state)
            {
                helper.onDraw(c,parent, state);
            }
        });
    }

    private void updateLabel() {
        String myFormat = "yyyy/MM/dd";    // 출력형식   2018/11/28
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);

        EditText et_date = (EditText) findViewById(R.id.age_et);
        et_date.setText(sdf.format(myCalendar.getTime()));
    }




}
