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
*The Java activity is where we write the codes... For this Lab I am only making codes to give two
* button widgets a job. Each button will take the user to a different activity.
*************************************
*/

//Brings the class to create new objects
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//The code will be applied to MainActivity and extends the AppCompatActivity
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Next 3 lines of code are enabling to show the launcher icon on the action bar
        //The image is coming from ic_launcher mipmap folder
        getSupportActionBar().setDisplayShowHomeEnabled(true);//Telling the computer to show image
        getSupportActionBar().setLogo(R.mipmap.ic_launcher); //Locating the image
        getSupportActionBar().setDisplayUseLogoEnabled(true); 

//btnCulture is the name I gave to a button that when click it will move to CulturePage
        //This line is guiding to find the properties a the button.
        Button btnCulture = (Button) findViewById(R.id.buttonCulture);
        //Button will pay attention to user once it clicks
        btnCulture.setOnClickListener(new View.OnClickListener() {
            @Override //Overriding the parent class
            //Public means that is going to be public. Void means to not expect something in return
            public void onClick(View v) {
                //Stating what to do when click. it will move to CulturePage
                startActivity(new Intent(MainActivity.this, CulturePage.class));
        }
        });

//Same as previous using same code just changing the button will take the user to different location.
        //btnFamily is the string for ButtonFamily.
        Button btnFamily = (Button) findViewById(R.id.buttonFamily);
        btnFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Once click the activity will move to FamilyPage
                startActivity(new Intent(MainActivity.this, FamilyPage.class));
            }
        });
    }
}
