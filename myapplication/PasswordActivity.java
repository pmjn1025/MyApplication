package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PasswordActivity extends AppCompatActivity {
    Button intent_btn;
    Button intent_btn1;
    Button intent_btn2;
    Button intent_btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        intent_btn = findViewById(R.id.passwordok_button);

        intent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordActivity.this, LoginActivity.class);
                Toast toast = Toast.makeText(getApplicationContext(),"비밀번호가 변경되었습니다.",Toast.LENGTH_SHORT); toast.show();

                startActivity(intent);
            }
        });

        intent_btn1 = findViewById(R.id.password_delete);

        intent_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordActivity.this, LoginActivity.class);
                Toast toast = Toast.makeText(getApplicationContext(),"비밀번호 변경에 실패했습니다.",Toast.LENGTH_SHORT); toast.show();

                startActivity(intent);
            }
        });

        intent_btn2 = findViewById(R.id.passwordcheck_button);

        intent_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"코드가 확인되었습니다. 비밀번호를 변경해주세요.",Toast.LENGTH_SHORT); toast.show();
            }
        });

        intent_btn3 = findViewById(R.id.password_codedelivery);
        intent_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"코드가 메일로 발송되었습니다.",Toast.LENGTH_SHORT); toast.show();
            }
        });

    }
}
