package com.example.timerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1;
    ProgressBar t1;
    static boolean state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        t1=findViewById(R.id.p);
    }

    public void start(View view) {

        if(state==true)
        {
            state=false;
        }
        else{
            state=true;
        }
            Thread t = new Thread() {
                int i = 0;

                @Override
                public void run() {
                    for (; ; ) {
                        try {
                            sleep(1000);
                            if (i <=100) {
                                t1.setProgress(i);
                                b1.setText(""+i);
                                i++;
                            } else {
                                break;
                            }
                        } catch (Exception e) {

                        }
                    }
                }
            };
            t.start();
    }
}