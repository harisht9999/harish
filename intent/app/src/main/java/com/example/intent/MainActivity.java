package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText e,a,p,ema,pass;
    Spinner s;
    RadioButton m,f,o;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e=findViewById(R.id.et);
        a=findViewById(R.id.ha);
        s=findViewById(R.id.spinner);
        p=findViewById(R.id.phone);
        ema=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        m=findViewById(R.id.male);
        f=findViewById(R.id.female);
        o=findViewById(R.id.others);
        ArrayAdapter<CharSequence> th=ArrayAdapter.createFromResource(MainActivity.this,R.array.harish,android.R.layout.simple_spinner_item);
        s.setAdapter(th);
    }

    public void submit(View view) {
        Intent i=new Intent(this,display.class);
        String se=e.getText().toString();
        String ro=a.getText().toString();
        String po=a.getText().toString();
        String ea=ema.getText().toString();
        String pas=pass.getText().toString();
        if(m.isChecked())
        {
             gender=m.getText().toString();
        }
        if(f.isChecked())
        {
             gender=f.getText().toString();
        }
        if(o.isChecked())
        {
             gender=o.getText().toString();
        }
        i.putExtra("harish",s.getSelectedItem().toString());
        i.putExtra("roll",ro);
        i.putExtra("name",se);
        i.putExtra("phone",po);
        i.putExtra("email",ea);
        i.putExtra("password",pas);
        i.putExtra("gender",gender);
        startActivity(i);

    }
}