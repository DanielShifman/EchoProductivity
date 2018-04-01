package com.example.morgansmith.echoproductivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

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



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);


        final ListView listView = view.findViewById(R.id.settingsList);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, settings);

        Button button = view.findViewById(R.id.resetSettings);
        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSettings();
                arrayAdapter.clear();
                arrayAdapter.addAll(settings);
                arrayAdapter.notifyDataSetChanged();
            }
        };
        button.setOnClickListener(buttonListener);
        listView.setAdapter(arrayAdapter);


        return view;
    }

    private void createSettings()
    {
        settings = new ArrayList<>(Arrays.asList("xyz", "abc", "dicks", "more dicks"));
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


    public void createSettings(View view) {
        createSettings();
    }
}
