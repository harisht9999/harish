package com.example.statistics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;

public class District_data extends AppCompatActivity {
   int position=-1;
   RecyclerView rv;
   String statename;
   PieChart pc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_data);
        rv=findViewById(R.id.recycl);
        pc=findViewById(R.id.cha);
        position=getIntent().getIntExtra("position",-1);
        statename=getIntent().getStringExtra("state");
        task t=new task(this,position,rv,statename,pc);
        t.execute();
    }
}