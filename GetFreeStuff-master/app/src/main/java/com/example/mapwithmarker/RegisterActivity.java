package com.example.mapwithmarker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import junit.framework.TestCase;

public class RegisterActivity extends AppCompatActivity {


    //Sspecial setter to set username and password in Shared Preferences
    public static void setUsernamePassword(Context context, String userName, String password) {
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        SharedPreferences.Editor editor = prefs.edit();
        //puts in the local preferences
        editor.putString(userName, password);
        editor.commit();
    }



    private EditText etUsername;
    private EditText etPassword;
    private Button bRegister;
    private Button bBack;
    private String username;
    private String password;


    protected void onCreate(Bundle savedInstanceState) {
        //setting various values for the button and other variables
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = (EditText) findViewById(R.id.getUsername);
        etPassword = (EditText) findViewById(R.id.getPassword);

        bRegister = (Button) findViewById(R.id.bRegister);
        bBack = (Button) findViewById(R.id.bBack);

    }
    public void onRegisterClick(View v) {
        //Puts values in shared preferences, and then opens main activity
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();
        setUsernamePassword(this, username, password);
        Intent registerBtn = new Intent(this,com.example.mapwithmarker.MainActivity.class);
        startActivity(registerBtn);

    }
    public void onClickBack(View v){
        Intent bBack = new Intent(this,com.example.mapwithmarker.MainActivity.class);
        startActivity(bBack);

    }

}




