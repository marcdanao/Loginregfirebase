package com.example.loginregfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private Button btnLogout;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        btnLogout = findViewById(R.id.btnlogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                logout();

            } }); }

    @Override

    public void onStart(){

        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser==null)

        { startActivity(new Intent(MainActivity.this, LoginActivity.class));

        } }

    public void logout() {

        FirebaseAuth.getInstance().signOut();

        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }}