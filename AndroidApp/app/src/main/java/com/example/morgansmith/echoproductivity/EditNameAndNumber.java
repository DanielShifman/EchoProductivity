package com.example.morgansmith.echoproductivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditNameAndNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name_and_number);
    }

    public void submit(View view) {
        String name = ((TextView) findViewById(R.id.recipientsName)).getText().toString();
        String number = ((TextView) findViewById(R.id.recipientsNumber)).getText().toString();
        String message = ((TextView) findViewById(R.id.recipientsMessage)).getText().toString();
        Intent intent = new Intent(this, Settings.class);
        intent.putExtra("name",name);
        intent.putExtra("number",number);
        intent.putExtra("message",message);
        startActivity(intent);

    }
}
