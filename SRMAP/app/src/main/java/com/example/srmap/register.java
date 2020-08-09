package com.example.srmap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.regex.Pattern;
import java.util.zip.CheckedOutputStream;

public class register extends AppCompatActivity {
    Context ct;
    TextView textView;
    FirebaseAuth auth;
    EditText Name,Lastname,Email,Phone,Password,Cpassword;
    FirebaseDatabase database;
    DatabaseReference reference;
    String name,lastname,email,phone,pass;
    private static final Pattern PASSWORD_PATTERN=Pattern.compile( "^(?=.*[0-9])"
            + "(?=.[a-z])(?=.[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$" );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name=findViewById(R.id.name);
        Lastname=findViewById(R.id.lastname);
        Email=findViewById(R.id.email);
        Phone=findViewById(R.id.phone);
        Password=findViewById(R.id.password);
        Cpassword=findViewById(R.id.confirmpassword);
        textView=findViewById(R.id.signin);
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(register.this,login.class);
                startActivity(intent);
            }
        });

    }

    private boolean validName(){
         name=Name.getText().toString().trim();
        if(name.isEmpty()){
            Name.setError("Field can't be empty");
            return false;
        }else {
            Name.setError(null);
            return true;
        }
    }

    private boolean validLastname(){
         lastname=Lastname.getText().toString().trim();
        if(lastname.isEmpty()){
            Lastname.setError("Field cant't be empty");
            return false;
        }
        else {
            Lastname.setError(null);
            return true;
        }
    }

    private boolean validEmail(){
         email=Email.getText().toString().trim();
        if(email.isEmpty()){
            Email.setError("Field can't be empty");
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Please enter a valid SRM mail");
            return false;
        }
        if(!email.endsWith("@srmap.edu.in")){
            Email.setError("Valid only SRM Mail");
            return false;
        }
        else{
            Email.setError(null);
            return true;
        }
    }

    private boolean validPhone(){
         phone=Phone.getText().toString().trim();
        if(phone.isEmpty()){
            Phone.setError("Field cant't be empty");
            return false;
        }
        else if(phone.length()>10){
            Phone.setError("Invalid Number !");
            return false;
        }
        else {
            Phone.setError(null);
            return true;
        }
    }

    private boolean validPassword(){
        pass=Password.getText().toString().trim();
        if (pass.isEmpty()){
            Password.setError("Field can't be empty");
            return false;
        }
       /* else if(!PASSWORD_PATTERN.matcher(password).matches()){
            Password.setError("Password too weak");
            return false;
        }*/
        else {
            Password.setError(null);
            return true;
        }
    }
    private boolean validcpassword(){
        String password=Password.getText().toString().trim();
        String cpassword=Cpassword.getText().toString().trim();
        if (cpassword.isEmpty()){
            Cpassword.setError("Password doesn't match");
            return false;
        }
        else if(!cpassword.equals(password)){
            Cpassword.setError("Password do not match");
            return false;

        }
        else {
            Cpassword.setError(null);
            return true;
        }
    }




    public void signup(View view) {
        if(!validName() | !validLastname() | !validEmail() | !validPhone() |!validPassword() | !validcpassword()){

            return;
        }
        else{
        auth.createUserWithEmailAndPassword(Email.getText().toString(),Password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                auth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        users u=new users(name,lastname,email,phone,pass);
                        reference.child("users").push().setValue(u);
                        startActivity(new Intent(register.this,login.class));
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                   Log.i("error",""+e);
            }
        });
        }
    }

    public void rsign(View view) {
        Intent intent=new Intent(register.this,login.class);
        startActivity(intent);
    }
}