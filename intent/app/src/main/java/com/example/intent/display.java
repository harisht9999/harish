package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class display extends AppCompatActivity {
      TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        t=findViewById(R.id.textView2);
        String d=getIntent().getStringExtra("name");
        String h=getIntent().getStringExtra("harish");
        String e=getIntent().getStringExtra("roll");
        String p=getIntent().getStringExtra("phone");
        String ema=getIntent().getStringExtra("email");
        String pass=getIntent().getStringExtra("password");
        String gen=getIntent().getStringExtra("gender");
        t.setText("name:"+d+"\n"+"roll no:"+e+"\n"+"phone no:"+p+"\n"+"email:"+ema+"\n"+"password:"+pass+"\n"+"gender:"+gen+"group:"+h);

    }
}