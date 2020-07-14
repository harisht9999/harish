package com.example.assainment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int a;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.et);
    }

    public void addition(View view) {
        a+=1;
        t.setText(""+a);
    }

    public void subtraction(View view) {
        if(a!=0) {
            a -= 1;
            t.setText("" + a);
        }
    }

    public void rt(View view) {
        a=0;
        t.setText(""+a);
    }

    public void toa(View view) {
        Toast.makeText(getApplicationContext(), "click +-> add - ->subtract 0->reset", Toast.LENGTH_LONG).show();
    }
}