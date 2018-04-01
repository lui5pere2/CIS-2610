package edu.wmich.lab3lperez9518;
/*
*************************************
* Programmer: Luis Perez
* Class ID: lperez9518
* Lab 3 - Paw Angel
* CIS 2610: Business Mobile Programming
* Spring 2017
* Due date: 03/23/17
* Date completed: 03/26/17
*************************************
* Program Explanation
* The purpose of ImageActivity is to have an image as background, the widgets are two buttons
* one to return to MainActivity and other is to get results. Also, a spinner which has a drop-down
* where user has to select and answer.
*************************************
*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity {

    //string to the Spinner
    String spinGroup;
    //String to the message of the Toast
    String ToastMsg = "We all needed each other";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        //Display app icon on bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //Connecting button xml to java
        Button btnBackImageActivity = (Button) findViewById(R.id.buttonBackImageActivity);
        //Codes to make app return to mainActivity using a button
        btnBackImageActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                startActivity(new Intent(ImageActivity.this, MainActivity.class));
            }
        });
        //Connecting spinner on xml to java
        final Spinner spinQuestions = (Spinner)findViewById(R.id.spinQuestion);
        //Connecting button on xml to java
        Button btnResult = (Button) findViewById(R.id.buttonSubmit);
        //When button is clicked it will active the following codes
        btnResult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //getSelectedItem reads the option selected in the spinner
                spinGroup = spinQuestions.getSelectedItem().toString();//Read spinner
                Toast.makeText(getApplicationContext(),ToastMsg,Toast.LENGTH_LONG).show();//show Toast
            }
        });
    }
}