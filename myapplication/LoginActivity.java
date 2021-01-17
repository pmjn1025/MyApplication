package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {


    Button intent_btn;
    EditText send_data;
    TextView sign_up;
    TextView sign_up1;

    @Override
    protected void onCreate( Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        send_data = findViewById(R.id.emailedittext);
        intent_btn = findViewById(R.id.loginbutton);
        sign_up = findViewById(R.id.signup);
        sign_up1 = findViewById(R.id.password);
        final EditText email_text = findViewById(R.id.emailedittext);
        final EditText password_text = findViewById(R.id.passwordedittext);


        intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String id = email_text.getText().toString();
                final String password = password_text.getText().toString();

                if (id.equals("teamNova@naver.com") && password.equals("1234")) {
                    Intent intent = new Intent(getApplicationContext(), IntersectionActivity.class);

                    SharedPreferences sharedPreferences= getSharedPreferences("test", MODE_PRIVATE);    // test 이름의 기본모드 설정
                    SharedPreferences.Editor editor= sharedPreferences.edit(); //sharedPreferences를 제어할 editor를 선언
                    editor.putString("inputText",send_data.getText().toString()); // key,value 형식으로 저장
                    editor.commit();    //최종 커밋. 커밋을 해야 저장이 된다.



                   
                    /*String name = email_text.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("name",name);

                    intent.putExtras(bundle);*/

                    //intent.putExtra("send_data",send_data.getText().toString());

                    Toast.makeText(LoginActivity.this,"로그인이 완료되었습니다.",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();


                }else{
                    Toast.makeText(LoginActivity.this,"이메일과 비밀번호를 입력해주세요",Toast.LENGTH_SHORT).show();


                }
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),JoinActivity.class);
                startActivity(intent);


            }
        });

        sign_up1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PasswordActivity.class);
                startActivity(intent);
            }
        });

    }
}
