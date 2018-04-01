package edu.wmich.lab2lperez9518;
/*
*************************************
* Programmer: Luis Perez
* Class ID: lperez9518
* Lab2: Loop Coding Center (LCC)
* CIS 2610: Business Mobile Programming
* Spring 2017
* Due date: 02/28/17
* Date completed: 02/28/17
*************************************
* Program Explanation
*The purpose of this app to for schools (user) who want the student to code, they need to buy a
* subscription. Using radio widgets the user will be able to select what type of membership they want.
* Then user will be able input how many kids they want to enroll.
*************************************
*/
//Import to support the code & bring data to make it work
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    int UserInput ;//The number that user will enter
    double Result ;//The cost or the result of the multiplication
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Code to show icon image on action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);//Enable action bar
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);//Link to the picture
        getSupportActionBar().setDisplayUseLogoEnabled(true);//use as a logo

        //The following are final rules that the user will not change
        final int Min_Input = 3;//No numbers lower than 3
        final int Max_Input = 24;//No numbers higher than 24
        final String strError = "Please follow the directions";//Toast message
        final EditText editTxtStudents = (EditText) findViewById(R.id.editTextStudents);//input number
        final TextView TxtViewResults = (TextView) findViewById(R.id.textViewResults);//result text
        //connect the radio buttons from the xml with the java
        final RadioButton RadButtonBeginner = (RadioButton) findViewById(R.id.radioButtonBeginner);
        final RadioButton RadButtonBasic = (RadioButton) findViewById(R.id.radioButtonBasic);
        final RadioButton RadButtonAdvance = (RadioButton) findViewById(R.id.radioButtonAdvance);
        final RadioButton RadButtonPremium = (RadioButton) findViewById(R.id.radioButtonPremium);
        //These are the cost of the membership, it will be used to be multiplied by the UserInput
        final Double Beginner = 10.0;
        final Double Basic = 20.0;
        final Double Advance = 30.0;
        final Double Premium = 40.0;

        //Making the button work with all other functions
        Button BtnSubmit = (Button) findViewById(R.id.buttonSubmit);//Button java
        BtnSubmit.setOnClickListener(new View.OnClickListener(){ //Listen to user actions on button
            public void onClick(View v){ //when button is click
                DecimalFormat fixUp = new DecimalFormat("#"); //Make answer a single decimal
                UserInput = Integer.parseInt(editTxtStudents.getText().toString());
                if (RadButtonBeginner.isChecked()) {//Check if the beginner is click on the radios
                    if (UserInput >= Min_Input && UserInput <= Max_Input){//Check for min & max
                        Result = UserInput * Beginner;//when both if are correct then multiply
                        TxtViewResults.setText("The cost of subscribing "+fixUp.format(UserInput)+
                                " students will be $"+Result);//show message in the textViewResult
                    } else {//when the if statement fails the rule, then show a toast
                        Toast.makeText(MainActivity.this,strError, Toast.LENGTH_LONG).show();
                    }
                }
                //The following are the same, but each one is checking for different membership
                if (RadButtonBasic.isChecked()) {//when basic membership is check in radio button
                    if (UserInput >= Min_Input && UserInput <= Max_Input) {//input # is in the range
                        Result = UserInput * Basic;//multiply user input with the cost of basic
                        TxtViewResults.setText("The cost of subscribing " + fixUp.format(UserInput)+
                                " students will be $" + Result);//display message of the cost
                    } else {//when the user input number is not in range, show toast
                        Toast.makeText(MainActivity.this,strError, Toast.LENGTH_LONG).show();
                    }
                }
                if (RadButtonAdvance.isChecked()) {//checking for advance membership check
                    if (UserInput >= Min_Input && UserInput <= Max_Input) {//check numbers
                        Result = UserInput * Advance;//multiplication
                        TxtViewResults.setText("The cost of subscribing " + fixUp.format(UserInput)+
                                " students will be $" + Result);//show result
                    } else {//something wrong, show toast message
                        Toast.makeText(MainActivity.this,strError, Toast.LENGTH_LONG).show();
                    }
                }
                if (RadButtonPremium.isChecked()) {//if user wants premium membership
                    if (UserInput >= Min_Input && UserInput <= Max_Input) {//user input is 3 - 24
                        Result = UserInput * Premium;//multiply user input by 40
                        TxtViewResults.setText("The cost of subscribing " + fixUp.format(UserInput)+
                                " students will be $" + Result);//show the result of the equation
                    } else {//if user input is not in between 3 - 24 numbers show message.
                        Toast.makeText(MainActivity.this,strError, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
