package com.example.asami.loginapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declare your variables in class for scope
    EditText name, password;
    TextView attempts;
    Button login, cancel;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //write the main logic here
        //Assigning views to variables
        //(view casting)

        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        cancel = (Button) findViewById(R.id.cancel);


        attempts = (TextView) findViewById(R.id.attemptsLeft);
        attempts.setVisibility(View.INVISIBLE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("user") && password.getText().toString().equals("qwerty")){

                   //Toast.makeText(MainActivity.this, "Redirecting...", Toast.LENGTH_LONG).show();

                    //intent to open a new activity

                    Intent newActivity = new Intent(getApplicationContext(), FullScreenActivity.class);
                    startActivity(newActivity);

                }else{
                    Toast.makeText(MainActivity.this, "Wrong Username or Password", Toast.LENGTH_LONG).show();
                    attempts.setVisibility(View.VISIBLE);
                    attempts.setBackgroundColor(Color.WHITE);
                    counter--;

                    //converts counter from integer to string
                    //attempts.setText(Integer.toString(counter));

                    //check of counter is equal to zero then disable
                    if(counter == 0){
                        login.setEnabled(false);
                    }
                }
            }
        });

    }
}
