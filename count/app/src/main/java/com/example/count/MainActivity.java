package com.example.count;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.FillEventHistory;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     TextView cu;
     int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cu=findViewById(R.id.cu);

    }

    public void display(View view) {
        a++;
        cu.setText(""+a);
    }

    public void toast(View view) {
        Toast.makeText(this,"click on button to count",Toast.LENGTH_SHORT).show();
    }
}