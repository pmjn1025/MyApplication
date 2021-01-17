package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CustomDialog extends Dialog {

    private OnDialogListener listener;
    private Context context;
    private Button mod_bt;
    private EditText mod_name, mod_age, mod_price;
    private String name;
    private int image;
    private String age;
    private String price;

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


    public CustomDialog(Context context,final int position, Person person){

        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.customdialog);
        name = person.getName();
        age = person.getAge();
        price = person.getPrice();
        image = person.getImage();

        //이름, 나이 EditText에 값 채우기
        mod_name = findViewById(R.id.mod_name);
        mod_name.setText(name);
        mod_age = findViewById(R.id.mod_age);
        mod_age.setText(String.valueOf(age));
        mod_price = findViewById(R.id.mod_price);
        mod_price.setText(String.valueOf(price));


        mod_bt = findViewById(R.id.mod_bt);
        mod_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    //EditText의 수정된 값 가져오기
                    String name = mod_name.getText().toString();
                    String age =  mod_age.getText().toString();
                    String price = mod_price.getText().toString();
                    Person person = new Person(image, name, age, price);
                    //Listener를 통해서 person객체 전달
                    listener.onFinish(position, person);
                    //다이얼로그 종료
                    dismiss();
                }
            }
        });

        EditText et_Date = (EditText) findViewById(R.id.mod_age);
        et_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CustomDialog.super.getContext(), myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }
    private void updateLabel() {
        String myFormat = "yyyy/MM/dd";    // 출력형식   2018/11/28
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);

        EditText et_date = (EditText) findViewById(R.id.mod_age);
        et_date.setText(sdf.format(myCalendar.getTime()));
    }
    public void setDialogListener(OnDialogListener listener){
        this.listener = listener;
    }







}
