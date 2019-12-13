package com.example.cannada_student_guide;


import android.content.SharedPreferences;

import android.os.Bundle;



import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.canada_student_guide.util.LocaleHelper;



public class SettingsFragment extends PreferenceFragment {


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


}
