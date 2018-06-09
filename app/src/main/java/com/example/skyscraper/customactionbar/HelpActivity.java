package com.example.skyscraper.customactionbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }
}
