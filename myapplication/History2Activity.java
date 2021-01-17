package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
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

public class History2Activity extends AppCompatActivity {

    EditText name_et,age_et,price_et;
    Button add_bt;
    RecyclerView rv;
    ListAdapter1 adapter;
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
        setContentView(R.layout.activity_history2);

        name_et = findViewById(R.id.name_et1);
        age_et = findViewById(R.id.age_et1);
        price_et = findViewById(R.id.price_et1);
        add_bt = findViewById(R.id.add_bt1);
        intent_btn = findViewById(R.id.history2fab);
        intent_btn1 = findViewById(R.id.history2_btn);


        EditText et_Date = (EditText) findViewById(R.id.age_et1);
        et_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(History2Activity.this, myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        final EditText et_time = (EditText) findViewById(R.id.price_et1);
        et_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(History2Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String state = "AM";
                        // 선택한 시간이 12를 넘을경우 "PM"으로 변경 및 -12시간하여 출력 (ex : PM 6시 30분)
                        if (selectedHour > 12) {
                            selectedHour -= 12;
                            state = "PM";
                        }
                        // EditText에 출력할 형식 지정
                        et_time.setText(state + " " + selectedHour + "시 " + selectedMinute + "분");
                    }
                }, hour, minute, false); // true의 경우 24시간 형식의 TimePicker 출현
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });


        intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(History2Activity.this, Photo2Activity.class);
                startActivity(intent);
            }
        });

        intent_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(History2Activity.this, IntersectionActivity.class);
                startActivity(intent);
            }
        });

        add_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EditText 입력된 값 가져오기
                String name = name_et.getText().toString();
                String price = price_et.getText().toString();
                String age = age_et.getText().toString();

                //이미지 값 세팅
                int image;
                switch (name){
                    case "경복궁" : {
                        image = R.drawable.icon_gyeongbok;
                        break;
                    }
                    case "창덕궁" : {
                        image = R.drawable.icon_changdeok;
                        break;
                    }
                    case "태종대" : {
                        image = R.drawable.icon_taejong;
                        break;
                    }
                    case "월미도" : {
                        image = R.drawable.icon_jelly;
                        break;
                    }
                    default: image = R.drawable.icon_qr2;
                }

                //Person 객체 생성, 값 세팅
                Person person = new Person();
                person.setName(name);
                person.setAge(age);
                person.setPrice(price);
                person.setImage(image);

                //ListAdapter에 객체 추가
                adapter.addItem(person);
                adapter.notifyDataSetChanged();

                //EditText 초기화
                name_et.setText("");
                age_et.setText("");
                price_et.setText("");

                //데이터 추가 확인 토스트 띄우기
                Toast.makeText(History2Activity.this, "목록에 추가되었습니다", Toast.LENGTH_SHORT).show();
                name_et.requestFocus();

            }
        });

        rv = findViewById(R.id.rv1); //RecyclerView의 레이아웃 방식을 지정
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);

        //RecyclerView의 Adapter 세팅
        adapter = new ListAdapter1(this);
        rv.setAdapter(adapter);

        //ItemTouchHelper 생성
        helper = new ItemTouchHelper(new ItemTouchHelperCallback(adapter));
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

        EditText et_date = (EditText) findViewById(R.id.age_et1);
        et_date.setText(sdf.format(myCalendar.getTime()));
    }


}

