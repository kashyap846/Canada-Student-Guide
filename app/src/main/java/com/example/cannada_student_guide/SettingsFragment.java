package com.example.cannada_student_guide;


import android.content.SharedPreferences;

import android.os.Bundle;



import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.canada_student_guide.util.LocaleHelper;



public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {


    private SharedPreferences prefs;
    private boolean rememberPercent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Instead of using a layout, we can use the preferences.xml file as a layout
        // which did a lot more work for us
        addPreferencesFromResource(R.xml.preferences);
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Log.e("pref_languages: ", "pref_languages");
        switch(key)
        {
            case "pref_languages":
                // DO STUFF
                Log.e("pref_languages: ", "pref_languages");
                LocaleHelper.setLocale(MainActivity.this, "fr");

                //It is required to recreate the activity to reflect the change in UI.
                recreate();
                break;

            case "KEY2":
                // DO STUFF
                break;
        }
    }
}
