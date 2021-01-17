package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class JoinActivity extends AppCompatActivity {
    EditText join_email, join_password, join_name, join_pwck;
    Button intent_btn;
    Button intent_btn1;
    Button intent_btn2;
    AlertDialog dialog;
    boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        intent_btn = findViewById(R.id.joinok_button);
        intent_btn1 = findViewById(R.id.join_delete);
        intent_btn2 = findViewById(R.id.check_button1);
        join_email = findViewById( R.id.join_email );
        join_password = findViewById( R.id.join_password );
        join_name = findViewById( R.id.join_name );
        join_pwck = findViewById(R.id.join_pwck);

        final EditText join_text = findViewById(R.id.join_email);
        final EditText password_text = findViewById(R.id.join_password);

        intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String id = join_text.getText().toString();
                final String password = password_text.getText().toString();

                if (id.equals("teamNova@naver.com") && password.equals("1234")) {
                    Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                    Toast toast = Toast.makeText(getApplicationContext(), "회원가입이 완료 되었습니다.", Toast.LENGTH_SHORT);
                    toast.show();

                    startActivity(intent);
                }else{
                    Toast.makeText(JoinActivity.this,"이메일과 비밀번호를 입력해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

        intent_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String id = join_text.getText().toString();

                if (id.equals("")) {

                    Toast toast = Toast.makeText(getApplicationContext(), "아이디를 입력해주세요.", Toast.LENGTH_SHORT);
                    toast.show();





                } else if (id.equals("teamNova@naver.com")) {


                    Toast toast = Toast.makeText(getApplicationContext(), "중복되는 아이디가 없습니다. 계속 진행 해주세요.", Toast.LENGTH_SHORT);
                    toast.show();



                }
            }
        });

        intent_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(JoinActivity.this, LoginActivity.class);
                Toast toast = Toast.makeText(getApplicationContext(),"회원가입을 취소 하셨습니다.", Toast.LENGTH_SHORT); toast.show();

                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, "onResume 호출 됨",Toast.LENGTH_LONG).show();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);

        if(pref != null){
            pref.getString("name","");     // name이 없으면  "" 를 달라
            String name = pref.getString("name","");
            //Toast.makeText(this,"복구된 이름"+ name, Toast.LENGTH_LONG).show();

        }

        // 여기서 알수 있는것들 ->
        /* 화면이 중지 되는 시점-> Key , 소녀시대가 저장 된다 -> 그럼 다시 실행을 하면
        onResume()이 실행되는데, 복구된 이름이라고 뜨는지 확인을 해보자.
         */
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "onPause 호출 됨",Toast.LENGTH_LONG).show();
        // 저장할때와 복구할떄 동일한 이름으로 사용해야 한다.
        // 속성을 보면 보통 Activity.MODE_PRIVATE 를 쓴다
        //
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        // Activity.MODE_PRIVATE는 SharedPreferences객체 리턴
        // pref 으로 값을 저장 할 수 있다.
        SharedPreferences.Editor editor = pref.edit();      // edit()는 editer라는 객체가 나오게된다
        //editor라는 변수를 만들면 (해쉬 테이블과 비슷하다) put,get으로 빼준다
        editor.putString("name","소녀시대");
        editor.commit();        // commit()을 해주어야 값이 저장된다.


        // pref.edit() 메소드를 호출하면



    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, "onStop 호출 됨",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "onDestroy 호출 됨",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(this, "onStart 호출 됨",Toast.LENGTH_LONG).show();
    }


}