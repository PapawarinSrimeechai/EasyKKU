package com.example.miw.easykku;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MainActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private Button signInButton , signUpButton;
    private EditText userEditText,passwordEditText;
    private String userString , passwordString;
    private myConstante myConstante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myConstante = new myConstante();

        //Bind widget
        signInButton = (Button) findViewById(R.id.button2);
        signUpButton = (Button) findViewById(R.id.button);
        userEditText = (EditText) findViewById(R.id.editText6);
        passwordEditText = (EditText) findViewById(R.id.editText5);

        //Sigm In controller
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get Value from EditText
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                //Check space
                if (userString.equals("") || passwordString.equals("")) {
                    //Have sapce
                    MyAlert myAlert = new MyAlert(MainActivity.this, R.drawable.bird48,
                            getResources().getString(R.string.title_HaveSpace),
                            getResources().getString(R.string.message_HaveSpace));
                    myAlert.myDialog();
                } else {
                    //No Space
                    SynUser synUser = new SynUser(MainActivity.this);
                    synUser.execute(myConstante.getUrlGetJson());
                }
            } // onclick
        });
        //Sign Up Controller
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }
        });

    }//Main Method

    private class SynUser extends AsyncTask<String, Void, String> {

        //Explicit
        private Context context;

        public SynUser(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(strings[0]).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                Log.d("13novV2", "e doIn ==> " + e.toString());
                return  null;
            }
        }//doInBack

        @Override
        protected void onPostExecute(String s) {
            Log.d("13novV2","Json ==> "+s);
            super.onPostExecute(s);
        }//onPost
    }


} //Main class นี่คิอ คลาสหลัก
