package edu.wmich.lab1lperez9518;

/*
*************************************
* Programmer: Luis Perez
* Class ID: lperez9518
* Lab1: North America Life
* CIS 2610: Business Mobile Programming
* Spring 2017
* Due date: 02/2/17
* Date completed: 02/2/17
*************************************
* Program Explanation
*To gain more experience I added a extra button with the purpose to take the user back to
*MainActivity. Usimg same codes from MainActivity.java to make the button work.
*************************************
*/

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CulturePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_culture_page);

        //Creating a new import for button and locating the button using string
        Button btnReturnCulture = (Button) findViewById(R.id.buttonReturn_Culture);
        //Listen to when user clicks button
        btnReturnCulture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                //Once click the activity will switch from CulturePage to MainActivity.
                startActivity(new Intent(CulturePage.this, MainActivity.class));
            }
        });
    }
}
