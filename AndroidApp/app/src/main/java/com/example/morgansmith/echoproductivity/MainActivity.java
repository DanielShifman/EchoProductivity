package com.example.morgansmith.echoproductivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * This class is the main menu where you access other parts of the app
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This takes you to the settings page
     * @param view The current view
     */
    public void openSettings(View view) {
        startActivity(new Intent(this, Settings.class));
    }
}

