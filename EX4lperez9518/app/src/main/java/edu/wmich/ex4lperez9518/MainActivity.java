package edu.wmich.ex4lperez9518;

/*
*************************************
* Programmer: Luis Perez
* Class ID: lperez9518
* EX4 - Math Help
* CIS 2610: Business Mobile Programming
* Spring 2017
* Due date: 01/19/17
* Date completed: 01/15/17
*************************************
* Program Explanation
*
*
*************************************
*/
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //Rules for the math equation
    int DivideConversion = 2;//Number in which is going to be divided
    double UserInput;//The number that user will enter
    double Result;//The result of UserInput divided by DivideConversion

    //Rule of the maximun number user can enter
    final Double Max_Input = 10.0;//No numbers higher than 10

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Codes to allow the launcher icon to be show in the action bar of the app
        getSupportActionBar().setDisplayShowHomeEnabled(true);//stating what to do
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);//Looking for the image location
        getSupportActionBar().setDisplayUseLogoEnabled(true);//Allow permission

        //Using final method to make no changes in the entire program. It wont be overridden
        //edit TxtQuestion is the text field widget to insert user number
        //editTextQuestionBox is where user will write number
        final EditText editTxtQuestion = (EditText) findViewById(R.id.editTextQuestionBox);
        final TextView txtViewResult = ((TextView)findViewById(R.id.textViewAnswer));//Answer box
        final String badAnswer = "Follow the Directions";//Message for the Toast

        //Rules of actions to take once user clicks the button.
        Button btnSubmit = (Button) findViewById(R.id.buttonSubmit);//Locating the button
        btnSubmit.setOnClickListener(new View.OnClickListener(){//Listen when user clicks button
            public void onClick(View V) {//What to do after it was click

                DecimalFormat fixUp = new DecimalFormat("#");//Telling the number format I want.
                //the number that user wrote to the field text to a string to convert the number.
                UserInput = Double.parseDouble(editTxtQuestion.getText().toString());
                if (UserInput <= Max_Input){//look  the numbers user wrote to see if is less than 10.
                    Result = UserInput / DivideConversion;//When number follows rule, math continues.
                    txtViewResult.setText("When you Divided "+ fixUp.format(UserInput)+ " by "+
                            DivideConversion + " Your answers is "+Result);//Message to the user
                            //to show the answer. This message will be shown in the texview that is
                            //invisible in the design page.
                } else {//When user doesn't enter a number 1 through 10 a Toast message will show.
                    Toast.makeText(MainActivity.this, badAnswer, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}