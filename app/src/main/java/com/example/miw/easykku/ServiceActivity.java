package com.example.miw.easykku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ServiceActivity extends AppCompatActivity {

    //Explicit
    private ListView listView;
    private String[] nameStrings,phoneStrings,imageStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //Bind widget
        listView = (ListView) findViewById(R.id.livFriend);

        //Receive value from intent
        nameStrings = getIntent().getStringArrayExtra("Name");
        phoneStrings = getIntent().getStringArrayExtra("Phone");
        imageStrings = getIntent().getStringArrayExtra("Image");

        //create ListView
        myAdapter myAdapter = new myAdapter(ServiceActivity.this,nameStrings,phoneStrings,imageStrings);
        listView.setAdapter(myAdapter);

    }//Main method

}//Main Class
