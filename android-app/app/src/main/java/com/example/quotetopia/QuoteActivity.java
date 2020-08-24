package com.example.quotetopia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class QuoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        Intent it = getIntent();
        String msg = it.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView tv = findViewById(R.id.editText1);
        tv.setText(msg);
    }
}
