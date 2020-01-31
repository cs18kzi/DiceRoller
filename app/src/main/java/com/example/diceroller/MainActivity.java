package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int s = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tv = this.findViewById(R.id.numberTextView);
        EditText et = this.findViewById(R.id.editText);
        TextView st = this.findViewById(R.id.score);

        et.setText("Pick a number from 1-10");
        tv.setText("Feeling lucky?");
        st.setText("Score");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void on_button_click(View view){


        EditText et = findViewById(R.id.editText);
        TextView tv = this.findViewById(R.id.numberTextView);
        TextView st = this.findViewById(R.id.score);

        int numberEntered = -1;

        try {
            numberEntered = Integer.parseInt(et.getText().toString());
        } catch (NumberFormatException nfe) {
            Toast.makeText(et.getContext(), "That's not a number!",
                    Toast.LENGTH_LONG).show();
        }

        try {
         int numberentered = Integer.parseInt(et.getText().toString());

         Random r = new Random();
         int number = r.nextInt(10);

         tv.setText(Integer.toString(number));


         if (numberentered == number) {
             Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();
             s++;
             st.setText(Integer.toString(s));
         }
     }
        catch (Exception ex){
            Log.e("ButtonErrors", ex.toString());
        }
         
        }

    public void on_icebreaker_click(View view){
        TextView q = this.findViewById(R.id.questionsTextView);

        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("if you could go anywhere in the world where would you go?");
        stringArrayList.add("if you were stranded on a desert island, what three things would you want to take with you?");
        stringArrayList.add("if you could eat only one food for the rest of your life, what would it be?");
        stringArrayList.add("If you won a million dollars, what is the first thing you would buy");
        stringArrayList.add("if you could spend the day with one fictional character, who would it be?");
        stringArrayList.add("if you found a magical lantern and a genie gave you three wishes, what would you wish?");
        stringArrayList.add("if you could rename yourself, what would you pick?");
        Random k = new Random();
        int random = k.nextInt((5+1));
        q.setText(stringArrayList.get(random));

    }

    }

