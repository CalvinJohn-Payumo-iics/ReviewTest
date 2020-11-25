package com.example.reviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUser, etPwd;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences("user", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_main);
    }

    public void saveUser(View v)    {
        SharedPreferences.Editor editor = sp.edit();
        etUser = findViewById(R.id.et_User);
        etPwd = findViewById(R.id.et_Password);
        String user = etUser.getText().toString();
        String password = etPwd.getText().toString();
        editor.putString("username", user);
        editor.putString("password", password);
        editor.commit();
        Toast.makeText(this, "user saved", Toast.LENGTH_SHORT).show();

    }

    public void login(View v)   {
        etUser = findViewById(R.id.et_User);
        etPwd = findViewById(R.id.et_Password);
        String user = sp.getString("username", "");
        String password = sp.getString("password", "");
        Intent intent = new Intent(this, Screen2.class);
        if(etUser.getText().toString().equals(user) && etPwd.getText().toString().equals(password)) {
            startActivity(intent);
        } else  {
            Toast.makeText(this, "invalid user", Toast.LENGTH_SHORT).show();
        }
    }
}