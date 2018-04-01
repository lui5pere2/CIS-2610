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
* In this activity the user have the option to select in between three buttons. One will take user
* back to main activity. Two buttons functions are to play music and paused the music.
* User will have control to which music to play and also to end music. Also, while one is playing
* the other will  hide.
*************************************
*/
//imports to make the codes of the app work
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MusicActivity extends AppCompatActivity {

    //Calling the buttons
    Button btnPlayfulDog, btnAngryDog;
    //identifying the music files name
    MediaPlayer mpPlayfulDog, mpAngryDog;
    //playing is starting when user clicks
    int playing = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //Display app icon on bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //Connecting the button xml to java
        Button btnBackMusicActivity = (Button) findViewById(R.id.buttonBackMusicActivity);
        //Following the actions after user click on the button
        //Back button to take user to MainActivity
        btnBackMusicActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                startActivity(new Intent(MusicActivity.this, MainActivity.class));
            }
        });
        //connecting xml to java for the buttons of music
        btnPlayfulDog = (Button)findViewById(R.id.buttonPlayful);
        btnAngryDog = (Button)findViewById(R.id.buttonAngry);
        //check for user to click on buttons
        btnPlayfulDog.setOnClickListener(buttonPlayful);
        btnAngryDog.setOnClickListener(buttonAngry);
        //controls for the music media
        mpPlayfulDog = new MediaPlayer();
        mpAngryDog = new MediaPlayer();
        //Connecting the identification of music to the music files in raw folder
        mpPlayfulDog = MediaPlayer.create(this, R.raw.playful_sound);
        mpAngryDog = MediaPlayer.create(this, R.raw.angry_sound);
    }
    //Actions when the button playful is selected
    Button.OnClickListener buttonPlayful = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            switch (playing) {//from the switch it will be playing the first in order
                case 0://start the actions for the first case(android begins at 0)
                    mpPlayfulDog.start();//play music with the name mpPlayfulDog
                    playing = 1;
                    btnPlayfulDog.setText("Pause Barking");//Message in the button after is clicked
                    btnAngryDog.setVisibility(View.INVISIBLE);//Visibility properties to show or not
                    break;//end case
                case 1:
                    mpPlayfulDog.pause();//when the music is paused
                    playing = 0;
                    btnPlayfulDog.setText("Start Barking");//display text while no sound playing
                    btnAngryDog.setVisibility(View.VISIBLE);//makes the other button show
                    break;//end case
            }
        }
    };
    //Actions to make when user clicks on the buttonAngry
    //Same purpose and code from the other button
    Button.OnClickListener buttonAngry = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            switch (playing){//begin
                case 0://while music is playing
                    mpAngryDog.start();//play music when button is click
                    playing = 1;
                    btnAngryDog.setText("Pause Barking");//Display text in button while playing
                    btnPlayfulDog.setVisibility(View.INVISIBLE);//not show other button  when play
                    break;//end
                case 1://while music is paused
                    mpAngryDog.pause();//paused audi
                    playing = 0;
                    btnAngryDog.setText("Start Barking");//show text in button
                    btnPlayfulDog.setVisibility(View.VISIBLE);//show both buttons
                    break;//end
            }
        }
    };
}
