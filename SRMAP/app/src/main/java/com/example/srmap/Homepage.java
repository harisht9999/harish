package com.example.srmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Homepage extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        t=findViewById(R.id.textView);
        t.setText(user+"");
    }

    public void signout(View view) {
        auth.getInstance().signOut();
        startActivity(new Intent(Homepage.this,login.class));
    }
}