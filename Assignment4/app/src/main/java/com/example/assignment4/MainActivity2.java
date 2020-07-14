package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t=findViewById(R.id.textView);
        String name= getIntent().getStringExtra("name");
        String roll= getIntent().getStringExtra("roll");
        String ema=getIntent().getStringExtra("phone");
        String phone=getIntent().getStringExtra("email");
        String gender=getIntent().getStringExtra("gender");
        t.setText("name:"+name+"\n"+"roll no:"+roll+"\n"+"phone:"+ema+"\n"+"email:"+phone+"\n"+"gender:"+gender);

    }
}