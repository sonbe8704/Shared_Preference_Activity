package com.example.shared_preference_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et_save;
    String shared = "File";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);//저장하고싶은 데이터

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        //shared라는 변수로 연결되어있다.
        //shared에 저장하는  SharedPreference
        String value = sharedPreferences.getString("hong","");//키와 초기값
        et_save.setText(value);//저장
    }

    @Override//컨트롤 + o 하면 생명주기 생성가능
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        //shared라는 변수로 연결되어있다.
        //쉐어드에 쓰는 sp
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //sp를 저장에 사용하는 editor
        String value= et_save.getText().toString();
        //et_save 에서 받아온다.
        editor.putString("hong",value);//홍이라는 이름으로 value를 저장
        //editor에 넣어줌
        editor.commit();

    }
}