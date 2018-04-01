package edu.wmich.lab4lperez9518;
/*
*************************************
* Programmer: Luis Perez
* Class ID: lperez9518
* Lab 4 - Perez Auto service
* CIS 2610: Business Mobile Programming
* Spring 2017
* Due date: 04/06/17
* Date completed: 04/06/17
*************************************
* Program Explanation
* The purpose of this app is to have user who need to have their car fix. They will make an
* appointment to decide when to bring the car. Now i did level 2 by adding a second button to have
* the user select a backup date to bring their car.
*************************************
*/
//This important as they bring files and things that will make codes work. Auto make as I code
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private TextView txtViewResult;//private variable
    private TextView txtViewBackup;//this is TextView


    //Message for the radios
    final String strMessage = "Bring your car on ";//general message that will be in all messages
    final String strBrakeMsg = "for brake service ";//Message for brake service radio button
    final String strTubeMsg = "To get full Tune-up service ";//message for tube radio button
    final String strEngineMsg = "To get the engine of you car checked ";//message for engine
    final String strInspectionMsg = "before buying to have someone take a look at it ";//message
    String strOutput;//empty string message to hold information that will display later. used in "if"
    String strSpinner;//empty string message to use in the spinner to hold the information
    String strSpace = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Show the logo of the app in the bar code
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        //Radios Button from xml connecting to java(Located in RadioGroup in xml)
        final RadioButton RadButtonBrake = (RadioButton) findViewById(R.id.radioButtonBrake);
        final RadioButton RadButtonTune = (RadioButton) findViewById(R.id.radioButtonTune);
        final RadioButton RadButtonEngine = (RadioButton) findViewById(R.id.radioButtonEngine);
        final RadioButton RadButtonInspection = (RadioButton)findViewById(R.id.radioButtonInspection);

        //Connecting xml to java in this spinner
        final Spinner spinQuestions = (Spinner)findViewById(R.id.spinQuestion);


        //Connecting the button from the xml
        Button btnAppointment = (Button) findViewById(R.id.buttonAppointment);//Main button
        Button btnBackup = (Button) findViewById(R.id.buttonBackup);//Backup (2nd) Button
        Button btnFinal = (Button) findViewById(R.id.buttonFinal);//button for last action


        //Empty textView where answer will show
        txtViewResult = (TextView) findViewById(R.id.textViewResult);//for first button result
        txtViewBackup = (TextView) findViewById(R.id.textViewBackup);//backup (second) button results


        //Here we start working on the first button. Once user click follow next codes
        btnAppointment.setOnClickListener(new View.OnClickListener() {//When button is click
            @Override
            public void onClick(View v) {
                //Check when user clicks ome of the radio button. only one can be clicked at a time.
                if (RadButtonBrake.isChecked()) {//when brake radio is checked
                    strOutput = strMessage + strBrakeMsg;//will hold information from both string
                } else if (RadButtonEngine.isChecked()) {//when engine radio is checked
                    strOutput = strEngineMsg + strMessage;//will hold information from both string
                } else if (RadButtonTune.isChecked()) {//when tune-up radio is checked
                    strOutput = strTubeMsg + strMessage;//will hold information from both string
                } else //The last option will be Inspection in which is not coded because is last
                    strOutput = strInspectionMsg + strMessage;//will hold information from both string
                //code for the spinner
                //will get information from selected item in drop down and hold in the strSpinner
                strSpinner = spinQuestions.getSelectedItem().toString();
                //Bring the calender when click the button. shows month, day, and year
                new DatePickerDialog(MainActivity.this, mainRepair, RepairDay.get(Calendar.YEAR),
                        RepairDay.get(Calendar.MONTH), RepairDay.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        //Second button function. This is going to do the same as first button (btnAppointment) but
        //to work on the second button.
        btnBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Same code as before. Very helpful for second button as it will keep separate input
                //away from the first button
                if (RadButtonBrake.isChecked()) {
                    strOutput = strMessage + strBrakeMsg;
                } else if (RadButtonEngine.isChecked()) {
                    strOutput = strEngineMsg + strMessage;
                } else if (RadButtonTune.isChecked()) {
                    strOutput = strTubeMsg + strMessage;
                } else
                    strOutput = strInspectionMsg + strMessage;
                strSpinner = spinQuestions.getSelectedItem().toString();
                new DatePickerDialog(MainActivity.this, second, RepairDay.get(Calendar.YEAR),
                        RepairDay.get(Calendar.MONTH), RepairDay.get(Calendar.DAY_OF_MONTH)+4).show();
            }
        });

        //Will wait until the user finish selecting all possible options to show the results
        btnFinal.setOnClickListener(new View.OnClickListener(){ //third button to display final text
            @Override
            public void onClick(View v)
            {
                //the .setText will display the text on the empty TextView
                txtViewResult.setText(strOutput + strSpinner + strSpace + DtFormat.format
                        (RepairDay.getTime()));//message

                //the .setText will display the text on the empty TextView
                txtViewBackup.setText(strOutput + strSpinner + strSpace + DtFormat.format
                        (Backup.getTime()));//message


            }
        });
    }


    //The ".get" code will gathered information from android
    Calendar RepairDay = Calendar.getInstance();//will return calendar information
    Calendar Backup = Calendar.getInstance();//For second calendar
    DateFormat DtFormat = DateFormat.getDateInstance();//Telling the user what they selected

    //DatePickerDialog will show the current day
    //Wait for user to chose year, month, and day to move forward.
    //DatePicker for the fist button & textView
    //mainRepair is the key to differential from second textview result
    DatePickerDialog.OnDateSetListener mainRepair = new DatePickerDialog.OnDateSetListener() {
        @Override//Getting feedback from the user information
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            //".set" will display the information that the user selects to show back to them
            RepairDay.set(Calendar.YEAR, year);//year information
            RepairDay.set(Calendar.MONTH, month);//Month information
            RepairDay.set(Calendar.DAY_OF_MONTH, dayOfMonth);//the day information

        }
    };


    //Second DatePicker for the Backup button & textView
    DatePickerDialog.OnDateSetListener second = new DatePickerDialog.OnDateSetListener() {
        @Override//Getting feedback from the user information
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            //".set" will display the information that the user selects to show back to them
            Backup.set(Calendar.YEAR, year);//year information
            Backup.set(Calendar.MONTH, month);//Month information
            Backup.set(Calendar.DAY_OF_MONTH, dayOfMonth);//the day information

        }
    };
}