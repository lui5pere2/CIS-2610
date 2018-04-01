package edu.wmich.ex7lperez9518;

/*
*************************************
* Programmer: Luis Perez
* Class ID: lperez9518
* EX7 - Rent A Bike
* CIS 2610: Business Mobile Programming
* Spring 2017
* Due date: 04/13/17
* Date completed: 04/13/17
*************************************
* Program Explanation
* This activity will show the results of MainActivty by using SharedPreferences
*
*************************************
*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//We need these two imports in both activities
import android.preference.PreferenceManager; //Support the information we collected
import android.content.SharedPreferences; //Used to store values


public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Show the logo of the app in the bar code
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //This TextView will show the results
        TextView txtResults = (TextView) findViewById(R.id.textViewResult);//Connecting xml to java

        //Connecting the Button xml to java
        Button btnReturn = (Button) findViewById(R.id.buttonReturn);

        //Destination in which the input from MainActivity will be display
        SharedPreferences ShareValues = PreferenceManager.getDefaultSharedPreferences(this);

        //String for the EditText
        String strName = ShareValues.getString("Name", "");//Name box
        String strAge = ShareValues.getString("Age", "");//Age
        String strEmail = ShareValues.getString("Email", "");//Email

        //Message to show in the empty TextView
        txtResults.setText("Thank you " + strName + ". we will review your information and make sure you are "
                + strAge + " years old. We will send you a confirmation email at " + strEmail
                + " to see if you are legible to rent a bike.");

        //Button to return to MainActivity
        btnReturn.setOnClickListener(new View.OnClickListener() {//check when clicked
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
            }
        });

        ImageView imgRotate = (ImageView)findViewById(R.id.imageViewOne);
        imgRotate.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotation));
    }
}
