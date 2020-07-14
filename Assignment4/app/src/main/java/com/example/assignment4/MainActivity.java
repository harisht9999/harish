package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText t,t1,t2,t3;
    RadioButton m,f,o;
    String gender;
    Spinner s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.name);
        t1=findViewById(R.id.roll);
        t2=findViewById(R.id.phone);
        t3=findViewById(R.id.email);
        m=findViewById(R.id.male);
        o=findViewById(R.id.others);
        f=findViewById(R.id.female);
        s=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> ha=ArrayAdapter.createFromResource(MainActivity.this,R.array.harish,android.R.layout.simple_spinner_item);
        s.setAdapter(ha);
    }
    public void submit(View view) {
        Intent i=new Intent(this,MainActivity2.class);
        String r=t1.getText().toString();
        String u=t.getText().toString();
        String e=t2.getText().toString();
        String p=t3.getText().toString();
        if(m.isChecked())
        {
             gender=m.getText().toString();
        }
        if(o.isChecked())
        {
             gender=o.getText().toString();
        }
        if(f.isChecked())
        {
             gender=f.getText().toString();
        }
        i.putExtra("name",u);
        i.putExtra("roll",r);
        i.putExtra("phone",e);
        i.putExtra("email",p);
        i.putExtra("gender",gender);
        startActivity(i);
    }
}