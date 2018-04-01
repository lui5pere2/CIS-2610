package edu.wmich.ex3lperez9518;

/*
*************************************
* Programmer: Luis Perez
* Class ID: lperez9518
* EX
* CIS 2610: Business Mobile Programming
* Spring 2017
* Due date: 01/19/17
* Date completed: 01/15/17
*************************************
* Program Explanation
* On this exercise I only have one activity with the purpose to have the use select one of the
*options using Radio Button
*************************************
*/

//Import files into java
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Code to show icon image on action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);//Enable action bar
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);//Link to the picture
        getSupportActionBar().setDisplayUseLogoEnabled(true);//use as a logo

        //By using Final we are not longer going to be making changes to the text in the program.
        //Making commands to tell the computer what to display for each radio on the Toast
        final String strEuropean = "The power of German engineering";//text will be shown when click
        final String strJapanese = "Long lasting vehicles";//if selected this will show
        final String strAmerican = "select another option";//Last option to chose from
        //Three radio button that were declared to link to Java final variables
        final RadioButton RatButtonEuropean = (RadioButton) findViewById(R.id.RadioButtonEuropean);
        final RadioButton RatButtonJapanese = (RadioButton) findViewById(R.id.RadioButtonJapanese);
        final RadioButton RatButtonAmerican = (RadioButton) findViewById(R.id.RadioButtonAmerican);

        //Coding to make everything work. Connecting the button with the radio button.
        Button btnResult = (Button) findViewById(R.id.ButtonResult);//Link btnResult with ButtonResult
        btnResult.setOnClickListener(new View.OnClickListener() { //Computer listen when user clicks
            //@Override
            public void onClick(View v) {//All the radio buttons go a one single button click event.
                //Using if codes to tell the computer if user uses one radio button then show message
                if (RatButtonEuropean.isChecked()) {//if user selects European car show message
                    Toast.makeText(MainActivity.this, strEuropean, Toast.LENGTH_LONG).show();
                } else {//else do not do anything
                }
                if (RatButtonJapanese.isChecked()) {//if user select Japanese car, show message
                    Toast.makeText(MainActivity.this, strJapanese, Toast.LENGTH_LONG).show();
                } else {//else do not do anything
                }
                if (RatButtonAmerican.isChecked()) {//if selects American in radio button show message
                    Toast.makeText(MainActivity.this, strAmerican, Toast.LENGTH_LONG).show();
                } else {//do not do anything if is not selected
                }
            }
        });
    }
}




