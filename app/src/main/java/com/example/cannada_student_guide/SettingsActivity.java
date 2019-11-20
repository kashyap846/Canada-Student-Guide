package com.example.cannada_student_guide;

import android.os.Bundle;
import android.app.Activity;

import androidx.annotation.NonNull;

public class SettingsActivity extends Activity {

    @Override
    public void onCreate(Bundle sIS) {
        super.onCreate(sIS);
        getFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content,new SettingsFragment())
                .commit();
    }
}
