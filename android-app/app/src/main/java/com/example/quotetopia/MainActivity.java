package com.example.quotetopia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.dkim.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickGenMotivational(View v) {
        Intent it = new Intent(this, MotivationalQuotes.class);
        startActivity(it);
    }

    public void onClickGenEntrepreneur(View v) {
        Intent it = new Intent(this, EntrepreneursQuotes.class);
        startActivity(it);
    }

    public void onClickGenInspirational(View v) {
        Intent it = new Intent(this, InspirationalQuotes.class);
        startActivity(it);
    }

    public void onClickGenBooks(View v) {
        Intent it = new Intent(this, BooksQuotes.class);
        startActivity(it);
    }

    public void onClickGenAuthors(View v) {
        Intent it = new Intent(this, AuthorsQuotes.class);
        startActivity(it);
    }

    public void onClickGenFitness(View v) {
        Intent it = new Intent(this, FitnessQuotes.class);
        startActivity(it);
    }
}
