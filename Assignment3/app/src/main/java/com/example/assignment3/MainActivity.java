package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void register(View view) {
        Intent i=new Intent(this,registerpage.class);
        startActivity(i);
    }

    public void login(View view) {
        Intent j=new Intent(this,welcome.class);
        startActivity(j);
    }
}