package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, 101);
            }
        });
    }

    //MenuActivity에서 응답을 받을 메서드를 정의

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //전달받은 intent 안에 들어 있는 데이터 확인
        if (requestCode == 101) { //메뉴화면에서 넘긴게 맞는지 확인
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(), "메뉴화면으로부터 응답 : " + name, Toast.LENGTH_SHORT).show();
        }

    }
}