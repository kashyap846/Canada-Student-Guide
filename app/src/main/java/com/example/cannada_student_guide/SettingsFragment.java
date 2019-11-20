package com.example.cannada_student_guide;



import android.os.Bundle;
import android.preference.PreferenceFragment;
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        addPreferencesFromResource(R.xml.preferences);
    }

}
