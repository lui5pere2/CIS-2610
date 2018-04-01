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
*The MainActivity contains a ListView in which is connected to to other activities and also internet
*websites. MainActivity is like a index where user gets to choose where and what they want to do next.
* All the images and the youtube video are from my dogs. I rescued Bu a year ago in Yucatan, Mexico.
*************************************
*/

import android.app.ListActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;//The ability to type websites url and make android know is uri
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;//Use for the TextView to ListView

public class MainActivity extends ListActivity {//change from AppCompatActivity to support ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Strings to put everything like in a folder. Helpful to make quick changes if is repetitive.
        //The titles of the ListView will come from these strings
        String[]arrAdoptList={"Kent County Animal Shelter","Human Society of West Michigan",
                "Youtube Rescue Video", "Change a Life","Know their Behavior","Bu & Max"};//elements
        //Connecting XML files with java
        //Adapter links data from layout
        setListAdapter(new ArrayAdapter<String>//Use of ArrayAdapter because it can hold more value
                (this, android.R.layout.simple_list_item_1, arrAdoptList));
        setListAdapter(new ArrayAdapter<String>//SetListAdapter shows data to the ListView screen
                (this, R.layout.activity_main, R.id.textViewAdoption,arrAdoptList));
    }
    //Sections and rules for when user click it will read and understand
    //onListItemClick is the code to tell that an option is going to be selected in the ListView
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        //Switch is allowing us to select and action in from any statements
        switch (position){//Position is knowing where user click
            case 0:{//When click it will open the internet app
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse//Action_View requesting action
                        ("https://www.accesskent.com/Health/AnimalControl/")));//website
                break;//Finish the work once clicked
            }
            case 1:{//Open browser app and load website
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://hswestmi.org")));
                break;//End statement
            }
            case 2:{//Uri.Parse will identified that is an website URL and will open proper app
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse
                        ("https://www.youtube.com/watch?v=jA-GZSArPyA&feature=share")));
                break;//end switch to continue to the next one
            }
            case 3:{//Open ImageActivity when user clicks on Change a Life
                startActivity(new Intent(MainActivity.this, ImageActivity.class));
                break;
            }
            case 4:{//Open MusicActivity or selecting Know their Behavior in the ListView
                startActivity(new Intent(MainActivity.this, MusicActivity.class));
                break;
            }
            case 5:{//Connecting two activities when click is will open GridView (Max & Bu)
                startActivity(new Intent(MainActivity.this, GridViewActivity.class));
                break;
            }
            default: {//In case one of the websites fail, it will go to google.com
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")));
                break;//End default
            }
        }
    }

}
