package com.example.morgansmith.echoproductivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class SettingsFragment extends Fragment {



    File file;
    Context context;
    ArrayList<String> settings;
    RelativeLayout relativeLayout;


    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        file = new File(context.getFilesDir(), "settings.txt");
        settings = readSettings();
        if(settings.size() == 0)
        {
            createSettings();
            writeSettings();
        }

        relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        for(int i = 0; i < settings.size(); i++)
        {
            TextView tv=new TextView(context);
            tv.setText(settings.get(i));
            relativeParams.addRule(RelativeLayout.BELOW, tv.getId());
            relativeLayout.addView(tv, relativeParams);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    private void createSettings()
    {
        settings = new ArrayList<>(Arrays.asList("xyz", "abc", "lkjsflkfds"));
        writeSettings();
    }

    private void writeSettings() {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("settings.txt", Context.MODE_PRIVATE));
            String data = "";
            for (String s : settings)
            {
                data += s + "\n";
            }

            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private ArrayList<String> readSettings() {

        ArrayList<String> ret = new ArrayList<>();

        try {
            InputStream inputStream = context.openFileInput("settings.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                int i = 0;
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    ret.add(i,receiveString);
                    i++;
                }

                inputStream.close();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }


    }
