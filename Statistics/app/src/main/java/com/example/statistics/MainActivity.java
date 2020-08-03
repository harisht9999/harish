package com.example.statistics;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;

public class MainActivity extends AppCompatActivity {
    RecyclerView r;
    TextView k;
    PieChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=findViewById(R.id.recycle);
        k=findViewById(R.id.text);
        chart=findViewById(R.id.chart);
        Mytask t=new Mytask(this,r,chart);
        t.execute();
    }
}