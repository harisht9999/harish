package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
     RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int images[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,};
        String names[]={"aa","bahubali","chirutha","dookudu","ega","fidha","gabarsingh","discosingh","i","jayam"};
        rv=findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter=new MyAdapter(images,names,MainActivity.this);
        rv.setAdapter(adapter);
    }
}