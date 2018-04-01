package edu.wmich.lab3lperez9518;
/*
*************************************
* Programmer: Luis Perez
* Class ID: lperez9518
* Lab 3 - Paw Angel
* CIS 2610: Business Mobile Programming
* Spring 2017
* Due date: 03/23/17
* Date completed: 03/26/17
*************************************
* Program Explanation
* The purpose of the SplashActivity is to display an image when user opens the app. The image will
* last for 5 seconds. After SplashActivity the next app will continue with the app.
* SplashActivity only happens at the beginning of the app.
*************************************
*/

//Imports to make app run
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;//Keep track of the time of the timer
import java.util.TimerTask;//is the timer import

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Display app icon on bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        TimerTask task = new TimerTask(){//Starting the code for time that SplashActivity will run
            @Override
            public void run(){
                finish();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));//Connecting xml
            }
        };
        Timer opening = new Timer();//Time is a one time task it can also pause a running app
        opening.schedule(task,5000);//5 seconds to play SplashScreen
    }
}
