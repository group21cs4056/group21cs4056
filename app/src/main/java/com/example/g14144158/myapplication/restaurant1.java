package com.example.g14144158.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;


public class restaurant1 extends ActionBarActivity {

    private Button savenotebutton1;
    private SharedPreferences savednotes;
    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant1);

        Button rbutton1 = (Button) findViewById(R.id.rest1);
        rbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), mappage1.class);
                startActivity(intent);
            }
        });

        Button Randombuton = (Button) findViewById(R.id.randombutton);
        Randombuton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int x=rnd.nextInt(5)+1;
                Intent myIntent = new Intent();
                switch(x){
                    case 1:
                        myIntent.setClass(v.getContext(),restaurant1.class);
                        break;
                    case 2:
                        myIntent.setClass(v.getContext(), restaurant2.class);
                        break;
                    case 3:
                        myIntent.setClass(v.getContext(), restaurant3.class);
                        break;
                    case 4:
                        myIntent.setClass(v.getContext(), restaurant4.class);
                        break;
                    case 5:
                        myIntent.setClass(v.getContext(), restaurant5.class);
                }
                startActivity(myIntent);


            }
        });

        savenotebutton1 = (Button) findViewById(R.id.savenotebutton1);
        editText1 = (EditText) findViewById(R.id.noteEditText1);
        savednotes = getSharedPreferences("notes",MODE_PRIVATE);

        editText1.setText(savednotes.getString("tag", "Enter details")); //add this line

        savenotebutton1.setOnClickListener(saveButtonListener);

    }

    private void makeTag(String tag){
        String or = savednotes.getString(tag, null);
        SharedPreferences.Editor preferencesEditor = savednotes.edit();
        preferencesEditor.putString("tag", tag); //change this line to this
        preferencesEditor.commit();
    }

    public View.OnClickListener saveButtonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (editText1.getText().length() > 0) {
                makeTag(editText1.getText().toString());

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editText1.getWindowToken(), 0);

            }
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurant1, menu);
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
}
