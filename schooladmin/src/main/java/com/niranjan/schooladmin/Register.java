package com.niranjan.schooladmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.niranjan.createschoolapp.Model.Usermodel;

public class Register extends AppCompatActivity {
ImageView gotologin;
    EditText regname,regemail,regpass;
    Button regbtn;
    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressBar regprogress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        gotologin=findViewById(R.id.gotologin);
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });
        auth=FirebaseAuth.getInstance();
        regprogress=findViewById(R.id.registerprogress);
        regprogress.setVisibility(View.GONE);
        database=FirebaseDatabase.getInstance();
        regname=findViewById(R.id.regname);
        regemail=findViewById(R.id.regemail);
        regpass=findViewById(R.id.regpass);
        regbtn=findViewById(R.id.registerbtn);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
                regprogress.setVisibility(View.VISIBLE);
            }
        });

    }
    private void createUser(){
        String userName = regname.getText().toString();
        String userEmail = regemail.getText().toString();
        String userPassword = regpass.getText().toString();
        if (TextUtils.isEmpty(userName)){
            Toast.makeText(this, "Name is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Email is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(userPassword)){
            Toast.makeText(this, "Password is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (userPassword.length()<6){
            Toast.makeText(this, "Password length must be gratter than 6 letter", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Usermodel usermodel=new Usermodel(userName,userEmail,userPassword);
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Admin").child(id).setValue(usermodel);
                            regprogress.setVisibility(View.GONE);
                            Toast.makeText(Register.this, "Success", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}