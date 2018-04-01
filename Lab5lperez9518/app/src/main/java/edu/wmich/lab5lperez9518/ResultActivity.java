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
*   Few things happening in this lab: The purpose of ResultActivity is to display the input of the
* the user in which we are grabbing from MainActivity suing SharedPreferences. Based on the answers
* of the user it will display a Frame Animation.
*************************************
*/


//imports are important as it brings information to specific codes
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//We need these two imports in both activities
import android.preference.PreferenceManager; //Support the information we collected
import android.content.SharedPreferences; //Used to store values
import android.view.animation.AnimationUtils;


public class ResultActivity extends AppCompatActivity {

    //AnimationDrawable will allow us to make images animation to make a sequence of frame by frame
    AnimationDrawable FrameAnimation; //Adding a name to the AnimationDrawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Show the logo of the app in the bar code
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //This TextView will show the results. Both TextView are located in activity_result.xml
        final TextView txtResults = (TextView) findViewById(R.id.textViewResult);//Connecting xml to java
        final TextView txtAmount = (TextView) findViewById(R.id.textViewAmount);//text for amount

        //connecting the image from xml. ImageView in xml is empty waiting for java to enter image
        final ImageView ImageSolid = (ImageView) findViewById(R.id.imageViewFrame);
        final ImageView ImageTweet = (ImageView) findViewById(R.id.imageViewTweet);

        //Connecting the Button xml to java
        final Button btnReturn = (Button) findViewById(R.id.buttonReturn);

        //Destination in which the input from MainActivity will be display
        final SharedPreferences ShareValues = PreferenceManager.getDefaultSharedPreferences(this);

        //String for the EditText
        final String strName = ShareValues.getString("KeyName", "");//Name box
        int intDonation = ShareValues.getInt("KeyAmount", 0);//the number of times user exercise
        final String strEmail = ShareValues.getString("KeyEmail", "");//Email

        /*
        The job for the If statement will be to check the number, the user has entered and check to
        see if it match with the appropriate condition. If the intDonation (User input) match it will
        display AnimationDrawable, there a total of 5 different AnimationDrawable. The following codes
        from the five if statements are similar, the only thing change is the amount requirement
        and different drawable location.
         */
        if (intDonation <= 1) {//if the information of the user is 1 or less than 1
            //three lines of code to make the frame animation work
            ImageSolid.setBackgroundResource(R.drawable.animation_novice);//connecting to drawable
            FrameAnimation=(AnimationDrawable)ImageSolid.getBackground();//selecting where to display
            FrameAnimation.start();//start the AnimationDrawable
            //Tween animation lines of code
            ImageTweet.setBackgroundResource(R.drawable.lazy_tweet);//Selecting image to display
            ImageTweet.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));//animation
        }

        //if the number that user input is between 1 and 3 the following codes will apply
        else if (intDonation >= 1 && intDonation <= 3) {
            //Frame Animation
            ImageSolid.setBackgroundResource(R.drawable.animation_beginner);//drawable locator
            FrameAnimation=(AnimationDrawable)ImageSolid.getBackground();//image Widget on xml
            FrameAnimation.start();//begin showing image
        }

        //if the information of the user is in between 3 to 5 then these codes will apply
        else if (intDonation >=3 && intDonation <= 5) {
            //Frame Animation
            ImageSolid.setBackgroundResource(R.drawable.animation_competent);//connecting to folder
            FrameAnimation=(AnimationDrawable)ImageSolid.getBackground();
            FrameAnimation.start();//begin displaying
        }

        //if the user exercises 5 through 7 times a week
        else if (intDonation >= 5 && intDonation <= 7) {
            //Frame animation
            ImageSolid.setBackgroundResource(R.drawable.animation_proficient);//connecting drawable
            FrameAnimation=(AnimationDrawable)ImageSolid.getBackground();
            FrameAnimation.start();//start showing image
        }

        //if the input of the user is 9 or higher
        else if (intDonation >= 9) {
            //Frame Animation
            ImageSolid.setBackgroundResource(R.drawable.animation_expert);//AnimationDrawable animation
            FrameAnimation=(AnimationDrawable)ImageSolid.getBackground();
            FrameAnimation.start();//start the sequence
            //Tween Animation
            ImageTweet.setBackgroundResource(R.drawable.result_tween1);//Connecting to the image
            ImageTweet.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));//Animation
        }

        //Message to show in the empty TextView
        txtResults.setText(strName + ", we found your name linked to " + strEmail + " email address."
                + " Your new data information is now being transfer.");

        //Message to display how many times user exercise per week
        txtAmount.setText("Adding your new exercise record of " + intDonation + " to your account.");


        //Button to return to MainActivity
        btnReturn.setOnClickListener(new View.OnClickListener() {//check when clicked
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
            }
        });
    }
}