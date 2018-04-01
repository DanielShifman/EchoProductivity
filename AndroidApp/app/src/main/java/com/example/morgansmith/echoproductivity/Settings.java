package com.example.morgansmith.echoproductivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * This is the settings activity where the user can configure
 * the app to their liking
 */
public class Settings extends AppCompatActivity {
    String name;
    String number;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

    }

    /**
     * This function pulls any extras in the intent out to be used
     * in case this activity is resumed by the EditNameAndNumber activity
     */
    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();

        if(intent.getExtras() != null)
        {
            Bundle extras = getIntent().getExtras();
             name = extras.getString("name");
             number = extras.getString("number");
             message = extras.getString("message");
        }
    }

    public void openMain(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public String getName()
    {
        return name;
    }

    public String getNumber()
    {
        return number;
    }

    public String getMessage()
    {
        return message;
    }
}
