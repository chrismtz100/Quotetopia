package com.example.quotetopia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MotivationalQuotes extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.dkim.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivational_quotes);

        Intent it = getIntent();
    }
}
