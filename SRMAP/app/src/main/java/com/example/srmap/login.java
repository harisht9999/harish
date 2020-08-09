package com.example.srmap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity implements FirebaseAuth.AuthStateListener{
    EditText username,password;
    ImageView imageView;
    TextView textView;
    FirebaseAuth auth;
    Snackbar snackbar;
    View ct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.lusername);
        password=findViewById(R.id.lpassword);
        imageView=findViewById(R.id.loginlogo);
        textView=findViewById(R.id.lsignup);
        auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,register.class);
                startActivity(intent);


            }
        });
    }


    public void lsignin(final View view) {
        auth.signInWithEmailAndPassword(username.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                if(auth.getCurrentUser().isEmailVerified())
                {
                    startActivity(new Intent(login.this,Homepage.class));
                }
                else{
                    snackbar=Snackbar.make(view,"please verify your mail.An activation mail sent to your account",Snackbar.LENGTH_LONG);
                    snackbar.show();
                    snackbar.setAction("ok", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            snackbar.dismiss();
                        }
                    });
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                snackbar=Snackbar.make(view,"Invalid Cradentials",Snackbar.LENGTH_LONG);
                snackbar.show();
                snackbar.setAction("retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
       auth.addAuthStateListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        auth.removeAuthStateListener(this);
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        if(firebaseAuth.getCurrentUser()!=null && firebaseAuth.getCurrentUser().isEmailVerified())
        {
            startActivity(new Intent(login.this,Homepage.class));
        }
    }
}