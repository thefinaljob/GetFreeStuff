package com.example.mapwithmarker;

        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.support.design.widget.NavigationView;
        import android.support.v4.widget.DrawerLayout;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button SignUp;
    public Button bLogin;
    public EditText username;
    public EditText password;
    public TextView checkWorking;
    private DrawerLayout mDrawerLayout;

    public static String getMyPassword(Context context, String usernameEntered) {
        SharedPreferences prefs = context.getSharedPreferences("myAppPackage", 0);
        return prefs.getString(usernameEntered, "");

    }

    //authentication of the login information
    public boolean auth(){
        String usernameEntry;
        String passwordEntry;
        //gets the values from the shared preferences
        usernameEntry = username.getText().toString();
        passwordEntry = password.getText().toString();
        //if nothing there, then return false and make user enter something
        if (usernameEntry.length() < 1 || passwordEntry.length() < 1) {
            checkWorking.setText("Please Enter Username or Password");
            return false;
        }
        else{
            String password = getMyPassword(this, usernameEntry);
            if(password ==  null || password.length() == 0){
                checkWorking.setText("No Such Username");
                return false;
            }
            else{
                if(password.equals(passwordEntry)){
                    checkWorking.setText("Authentication Successful!");
                    return true;
                }
                else{
                    checkWorking.setText("Authentication Failed!");
                    return false;
                }
            }
        }

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SignUp = (Button) findViewById(R.id.Sign);
        bLogin = (Button) findViewById(R.id.bLogin);
        username = (EditText) findViewById(R.id.getUsername);
        password = (EditText) findViewById(R.id.getPassword);
        checkWorking = (TextView) findViewById(R.id.CheckIfWorking);



    }

    public void onLoginAuthClick(View v){
        auth();
        if (auth() == true){
            //returns true? then go ahead and go to the AboutUs activity
            Intent registerBtn = new Intent(this, AboutUs.class);
            startActivity(registerBtn);
        }
        else{}
    }

    public void onSignUpClick(View v){
        Intent registerBtn = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(registerBtn);
    }
}


















