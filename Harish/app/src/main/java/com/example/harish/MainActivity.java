package com.example.harish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
      EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.roll);
    }

    public void submit(View view) {
        Intent i=new Intent(MainActivity.this,Display.class);
        String roll=t.getText().toString();
        i.putExtra("roll",roll);
        startActivity(i);
    }
}