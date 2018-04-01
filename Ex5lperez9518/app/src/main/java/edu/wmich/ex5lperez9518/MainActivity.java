package edu.wmich.ex5lperez9518;
/*
*************************************
* Programmer: Luis Perez
* Class ID: lperez9518
* EX5 - Top 4 Advertisement
* CIS 2610: Business Mobile Programming
* Spring 2017
* Due date: 03/16/17
* Date completed: 03/16/17
*************************************
* Program Explanation
*The programming of this exercise is connecting my application to four different websites.
*My task of my app is to provide the user with internet links. Using a listView to display the
* name of the title of the website. The links are my four of my favorites tv/social media adv.
*************************************
*/
//imports to allow functions to the code
import android.app.ListActivity;//List connected to the array
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;//The ability to type websites url and make android know is uri
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;//Use for the TextView to ListView

public class MainActivity extends ListActivity {//change the activity to allow the TextView as ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//The name of the String will be arrAdvertisement, to connect to other codes. The information inside
//the array are values in which they will be shown in order of how they are in the java.
        String[] arrAdvertisement = {"Coca-Cola's | It's Beautiful ", "Jarritos | The Journal",
                "Kodak | Understanding", "Budweiser | Born the Hard Way"};
//We are telling the information that it will show, grabbing the values as the information
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrAdvertisement));
//Connecting the xml with java. Show the values of the array in the widget
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.
                textViewAdvertisement, arrAdvertisement));
    }
//Listen when user clicks on the item.
//Position is telling the android device what item was selected
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
//In the four cases, the app will be paused and the internet/browser app will launched
//The order of the cases will have to match with the list values in the array
//In this exercise the following cases are the same, ONLY different websites.
        switch (position){//Multiple actions to select required to determine the integers was used
            case 0:{//Will test the first case. Use 0 because is the first one in the list
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse//Know is a website url
                        ("http://time.com/3773/coca-colas-its-beautiful-super-bowl-ad-brings-out-" +
                                "some-ugly-americans/")));//link to the website of Coca-Cola
                break;//End the of the case
            }
            case 1:{//start activity 1: Jarritos The Journal
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www." +
                        "lansingstatejournal.com/story/news/immigration/2016/10/19/diego-luna-" +
                        "jarritos-unveil-immigration-video/92428758/")));
                break;//End case 1
            }
            case 2:{//Open website for Kodak Understanding
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.huffingtonpost."+
                        "com/entry/kodak-understanding-film_us_585d90c7e4b0eb58648662e7")));
                break;//End
            }
            case 3:{//Last case. Open Budweiser Born The Hard Way
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www." +
                        "superbowlcommercials.co/budweiser/")));
                break;
            }
            default:{//In case one of the websites fail, it will go to google.com
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")));
                break;//End default
            }
        }
    }
}
