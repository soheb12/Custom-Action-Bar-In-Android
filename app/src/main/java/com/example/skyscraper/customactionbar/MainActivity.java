package com.example.skyscraper.customactionbar;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toast mToastToShow;
    public void showToast(View view,String toastMessage,int durationInMilliSeconds) {

        // Set the toast and duration
        int toastDurationInMilliSeconds = durationInMilliSeconds;
        mToastToShow = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);

        // Set the countdown to display the toast
        CountDownTimer toastCountDown;
        toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000 /*Tick duration*/) {
            public void onTick(long millisUntilFinished) {
                mToastToShow.show();
            }
            public void onFinish() {
                mToastToShow.cancel();
            }
        };

        // Show the toast and starts the countdown
        mToastToShow.show();
        toastCountDown.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.Updates:
                Toast.makeText(getApplicationContext(),"Latest Verion Installed",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Help:
                Toast.makeText(getApplicationContext(),"Help",Toast.LENGTH_SHORT).show();
                Intent help_intent = new Intent(this , HelpActivity.class);
                startActivity(help_intent);
                break;
            case R.id.settings:
                View view = getWindow().getDecorView().getRootView();
                showToast(view,"Settings",2000);
                Intent settings_intent = new Intent(this,SettingsActivity.class);
                startActivity(settings_intent);
                break;
                default:

        }
        return super.onOptionsItemSelected(item);
    }
}
