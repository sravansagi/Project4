package com.sravan.and.jokeviewlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivityJokeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jokeview);
        Intent intent = getIntent();
        if (intent!=null && intent.hasExtra(Intent.EXTRA_TEXT)){
            TextView jokeTextView = (TextView) findViewById(R.id.joke_textview);
            jokeTextView.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
        }
    }
}
