package com.example.miw.easykku;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by MIW-PC on 11/12/2016.
 */

public class MyAlert {
    //Explicit
    private Context context;
    private int anInt;
    private String titileString, messageString;

    public MyAlert(Context context, int anInt, String titileString, String messageString) {
        this.context = context;
        this.anInt = anInt;
        this.titileString = titileString;
        this.messageString = messageString;
    }

    public void myDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(anInt);
        builder.setTitle(titileString);
        builder.setMessage(messageString);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    } //myDialog
} //Main class
