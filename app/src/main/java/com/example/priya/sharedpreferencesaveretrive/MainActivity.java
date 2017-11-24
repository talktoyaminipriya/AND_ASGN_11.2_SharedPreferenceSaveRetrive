package com.example.priya.sharedpreferencesaveretrive;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editname;
    EditText editphone;
    EditText editage;
    public static final String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editname = (EditText) findViewById(R.id.editname);
        editphone = (EditText) findViewById(R.id.editphone);
        editage = (EditText) findViewById(R.id.editage);

    }

    public void save(View view){

       // returns a SharedPreference instance pointing to the file that contains the values of preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);

        // Saves data into file
        SharedPreferences.Editor editor =sharedPreferences.edit();

        // put multiple values into file
        editor.putString("editname",editname.getText().toString());
        editor.putString("editphone",editphone.getText().toString());
        editor.putString("editage",editage.getText().toString());
        editor.commit();

        Toast.makeText(this,"Data Saved Sucessfully",Toast.LENGTH_LONG).show();
    }

    //displays data from  shared preference files
    public void display(View view) {


        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);

        //Retrives data from shared preference file
        String editname = sharedPreferences.getString("editname", DEFAULT);// put default if data not entered
        String editphone = sharedPreferences.getString("editphone", DEFAULT);
        String editage = sharedPreferences.getString("editage", DEFAULT);

        Toast.makeText(this," Name:  "+editname+" Phone:  "+editphone+" Age:  "+editage,
                Toast.LENGTH_SHORT).show();


    }
}
