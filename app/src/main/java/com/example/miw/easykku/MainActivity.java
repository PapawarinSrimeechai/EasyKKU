package com.example.miw.easykku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private Button signInButton , signUpButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = (Button) findViewById(R.id.button2);
        signUpButton = (Button) findViewById(R.id.button);

        //Sign Up Controller
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }
        });

    }//Main Method

} //Main class นี่คิอ คลาสหลัก
