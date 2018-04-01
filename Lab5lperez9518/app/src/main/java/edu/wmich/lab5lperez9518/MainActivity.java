package edu.wmich.lab5lperez9518;


/*
*************************************
* Programmer: Luis Perez
* Class ID: lperez9518
* Lab 5 - Health Tracker
* CIS 2610: Business Mobile Programming
* Spring 2017
* Due date: 04/21/17
* Date completed: 04/21/17
*************************************
* Program Explanation
* The work of the java will be to wait till user inputs the information (name, number, email) once that
* happens when the user clicks the button. SharedPreferences will hold the data and move it over
* to an activity in which we decide.
*************************************
*/

//Imports to make the codes work
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.preference.PreferenceManager; //Support the information we collected
import android.content.SharedPreferences; //Used to store values
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //String will be used to hold the input information from the user
    String strHoldName = ""; //Hold the name of the user
    String strHoldEmail = ""; //Hold the email information
    int intHoldAmount = 0; //Hold the amount entered by the user


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Show the logo of the app in the bar code
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        /*By using Final we are not longer going to be making changes to the text in the program.
        //Making commands to tell the computer what to display Toast. If the user does not enter
        any information in the EditText, Toast will show     */
        final String strToastName = "Please provide us with your name";
        final String strToastEmail = "Email is required";
        final String strToastDonation = "Please tell us how much you want to donate";

        //Connecting the EditText widgets from xml to java
        final EditText UserName = (EditText) findViewById(R.id.editTextName);//Name box
        final EditText UserAmount = (EditText) findViewById(R.id.editTextDonation);//exercise box
        final EditText UserEmail = (EditText) findViewById(R.id.editTextEmail);//Email box

        //Connecting Button from xml to java
        final Button btnMove = (Button) findViewById(R.id.buttonSwitch);//Button to move to next activity

        //ShareValues is the name of the object in which will hold the data to used later
        final SharedPreferences ShareValues = PreferenceManager.getDefaultSharedPreferences(this);

        //know when the button is clicked. If clicked it will continue the following codes
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Checking if the user entered the information in the box
                if (UserName.getText().toString().equals("")){//if the filed is empty
                    Toast.makeText(MainActivity.this, strToastName, Toast.LENGTH_LONG).show();//toast
                }

                //Toast message will deploy if editText is empty
                else if (UserEmail.getText().toString().equals("")) {//checking for email editText is empty
                    Toast.makeText(MainActivity.this, strToastEmail, Toast.LENGTH_LONG).show();
                }

                //If the field is empty then it will show a toast message
                else if (UserAmount.getText().toString().equals("")) {//checking if the user entered a number
                    Toast.makeText(MainActivity.this, strToastDonation, Toast.LENGTH_LONG).show();
                }
                else {//if everything is entered the move to next activity
                    startActivity(new Intent(MainActivity.this, ResultActivity.class));

                    //Insert the input
                    strHoldName = UserName.getText().toString(); //The name of the user
                    intHoldAmount = Integer.parseInt(UserAmount.getText().toString());//remember number
                    strHoldEmail = UserEmail.getText().toString(); //hold the email of the user

                    //The editor allow to make changes. I name mine "ShrEdit"
                    SharedPreferences.Editor ShrEdit = ShareValues.edit();

                    //Assigning a key to the data. Need to match with ResultActivity to work.
                    ShrEdit.putString("KeyName", strHoldName);
                    ShrEdit.putInt("KeyAmount", intHoldAmount);
                    ShrEdit.putString("KeyEmail", strHoldEmail);


                    ShrEdit.commit(); //Keeps updating every time the user input new information
                }
            }
        });
    }
}