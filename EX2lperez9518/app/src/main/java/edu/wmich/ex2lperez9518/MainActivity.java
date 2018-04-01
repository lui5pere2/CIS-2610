package edu.wmich.ex2lperez9518;

/*
*************************************
* Programmer: Luis Perez
* Class ID: lperez9518
* EX2:
* CIS 2610: Business Mobile Programming
* Spring 2017
* Due date: 01/27/17
* Date completed: 01/26/17
*************************************
* Program Explanation
*
* The java code for this exercise was creating seven lines of code (33 - 39) to connect a button with the name of btnExplore
* for the user to use once click it will change to an activity containing two picture pgn files of cars with the name of ModelsActivity.
*
*
*************************************
*/

//The section of the imports is where I can store classes to use multiple times in the application
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*The next lines of code I am assigning a fuction to a button by using setOnClickListener which will listen when the user click the button
* to the btnExplorer which is the buttonExplorer on the MainActivity. Once click the layout will change to models activity.
*/
        Button btnExplore = (Button) findViewById(R.id.buttonExplore);
        btnExplore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                startActivity(new Intent(MainActivity.this, ModelsActivity.class));
            }
        });
    }
}
