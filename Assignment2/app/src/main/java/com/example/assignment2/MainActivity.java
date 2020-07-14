package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    int a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.tv1);
        t2=findViewById(R.id.tv2);
    }

    public void b3(View view) {
        b+=3;
        t2.setText(""+b);
    }

    public void b2(View view) {
        b+=2;
        t2.setText(""+b);
    }

    public void b1(View view) {
        b+=1;
        t2.setText(""+b);
    }

    public void a3(View view) {
        a+=3;
        t1.setText(""+a);
    }

    public void a2(View view) {
        a+=2;
        t1.setText(""+a);
    }

    public void a1(View view) {
        a+=1;
        t1.setText(""+a);
    }

    public void reset(View view) {
        a=0;
        b=0;
        t1.setText(""+a);
        t2.setText(""+b);
    }
}