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
* The work of the java will be to wait till user inputs the information (name, age, email) once that
* happens when the user clicks the button SharedPreferences will hold the data and move it over
* to an activity in which we decide.
*************************************
*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.preference.PreferenceManager; //Support the information we collected
import android.content.SharedPreferences; //Used to store values

public class MainActivity extends AppCompatActivity {

    //String will be used to hold the input information from the user
    String strHoldName = ""; //Hold the name of the user
    String strHoldAge = ""; //Hold the age of the user
    String strHoldEmail = ""; //Hold the email information

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Show the logo of the app in the bar code
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //Connecting the EditText widgets from xml to java
        final EditText UserName = (EditText) findViewById(R.id.editTextName);//Name box
        final EditText UserAge = (EditText) findViewById(R.id.editTextAge);//Age box
        final EditText UserEmail = (EditText) findViewById(R.id.editTextEmail);//Email box

        //Connecting Button from xml to java
        Button btnMove = (Button) findViewById(R.id.buttonMove);//Button to move to next activity

        //ShareValues is the name of the object in which will hold the data to used later
        final SharedPreferences ShareValues = PreferenceManager.getDefaultSharedPreferences(this);

        //know when the button is clicked. If clicked it will continue the following codes
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Insert the input
                strHoldName = UserName.getText().toString(); //The name of the user
                strHoldAge = UserAge.getText().toString(); //Grab the age of th user
                strHoldEmail = UserEmail.getText().toString(); //hold the email of the user

                //The editor allow to make changes. I name mine "ShrEdit"
                SharedPreferences.Editor ShrEdit = ShareValues.edit();

                //Assigning a key to the data
                ShrEdit.putString("Name", strHoldName);
                ShrEdit.putString("Age", strHoldAge);
                ShrEdit.putString("Email", strHoldEmail);


                ShrEdit.commit(); //Keeps updating every time the user input new information

                //Move to the next activity
                startActivity(new Intent(MainActivity.this, ResultActivity.class));
            }
        });
    }
}
