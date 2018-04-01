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
*For my last activity I am only coding to make the button work
*
* When running the app, and user click "Return to Home" button it will go back the main activity
* very slowly. Did not found any serious trouble, other than slow.
*************************************
*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FamilyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_page);

        //Finding buttonReturn_Family which is the button to return to home
        Button btnFamily = (Button) findViewById(R.id.buttonReturn_Family) ;
        //Listen when user clicks Return to Home
        btnFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When click Button the activity will return to MainActivity.
                startActivity(new Intent(FamilyPage.this, MainActivity.class));
            }
        });


    }
}
