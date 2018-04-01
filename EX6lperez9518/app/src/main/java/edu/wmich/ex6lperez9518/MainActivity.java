package edu.wmich.ex6lperez9518;
/*
*************************************
* Programmer: Luis Perez
* Class ID: lperez9518
* EX6 - Loop Coding Center
* CIS 2610: Business Mobile Programming
* Spring 2017
* Due date: 03/30/17
* Date completed: 03/30/17
*************************************
* Program Explanation
*With this java code wii will be able to click a button to bring up a calendar to select a date.
*In this exercise the user gets to schedule a day to attend a workshop to learn about LCC.
*************************************
*/

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;
import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {

    private TextView CalAppointment;//Keep track of the textview
    final String strMessage = "You Section has been schedule on ";//Message to the user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Show the logo of the app in the bar code
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //Telling java to connect to the widgets on the xml to make the code work with user reaction
        CalAppointment = (TextView) findViewById(R.id.textViewReservation);//connecting xml to java
        Button btnworkshop = (Button) findViewById(R.id.buttonAppointment);//Linking xml to java
        //Button from xml buttonAppoint. Once clicked it will open a calendar
        btnworkshop.setOnClickListener(new View.OnClickListener() {//Listen to the click of the button
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Calendar will open and user will be able to select a year, month, and day.
                //The dates of the calender are integer
                new DatePickerDialog(MainActivity.this, WorkshopDate, LearningDay.get(Calendar.YEAR),
                        LearningDay.get(Calendar.MONTH), LearningDay.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }//The ".get" code will gathered information from android
    Calendar LearningDay = Calendar.getInstance();//will return calendar information
    DateFormat DtFormat = DateFormat.getDateInstance();//Telling the user what they selected
    //DatePickerDialog will show the current day
    //Wait for user to chose year, month, and day to move forward.
    DatePickerDialog.OnDateSetListener WorkshopDate = new DatePickerDialog.OnDateSetListener() {
        @Override//Getting feedback from the user information
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            //".set" will display the information that the user selects to show back to them
            LearningDay.set(Calendar.YEAR, year);//year information
            LearningDay.set(Calendar.MONTH, month);//Month information
            LearningDay.set(Calendar.DAY_OF_MONTH, dayOfMonth);//the day information
            //the .setText will display the text on the empty TextView
            CalAppointment.setText(strMessage + DtFormat.format(LearningDay.getTime()));//message
        }
    };
}




