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


public class restaurant4 extends ActionBarActivity {

    private Button savenotebutton4;
    private SharedPreferences savednotes4;
    private EditText editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant4);

        Button rbutton4 = (Button) findViewById(R.id.rest4);
        rbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), mappage4.class);
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

        savenotebutton4 = (Button) findViewById(R.id.savenotebutton4);
        editText4 = (EditText) findViewById(R.id.noteEditText4);
        savednotes4 = getSharedPreferences("notes",MODE_PRIVATE);

        editText4.setText(savednotes4.getString("tag4", "enter details")); //add this line

        savenotebutton4.setOnClickListener(saveButtonListener);
    }
    private void makeTag(String tag4){
        String or = savednotes4.getString(tag4, null);
        SharedPreferences.Editor preferencesEditor = savednotes4.edit();
        preferencesEditor.putString("tag4", tag4); //change this line to this
        preferencesEditor.commit();
    }

    public View.OnClickListener saveButtonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (editText4.getText().length() > 0) {
                makeTag(editText4.getText().toString());

                ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(editText4.getWindowToken(), 0);

            }
        }};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurant4, menu);
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
