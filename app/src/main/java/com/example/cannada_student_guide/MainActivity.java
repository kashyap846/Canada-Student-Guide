package com.example.cannada_student_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.canada_student_guide.util.LocaleHelper;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener {
    ScrollView guide1Body,guide2Body,guide3Body,guide4Body;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4;


    private SharedPreferences savedValues,prefs;
    private boolean rememberUserChnages =true;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guide1Body = (ScrollView) findViewById(R.id.guide1Body);
        guide2Body = (ScrollView) findViewById(R.id.guide2Body);
        guide3Body = (ScrollView) findViewById(R.id.guide3Body);
        guide4Body = (ScrollView) findViewById(R.id.guide4Body);
        guide1Body.setVisibility(View.GONE);
        guide2Body.setVisibility(View.GONE);
        guide3Body.setVisibility(View.GONE);
        guide4Body.setVisibility(View.GONE);

        //checkboxes
        checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox)findViewById(R.id.checkBox4);

        //bind onclick listener
        checkBox1.setOnClickListener(this);
        checkBox2.setOnClickListener(this);
        checkBox3.setOnClickListener(this);
        checkBox4.setOnClickListener(this);


        //preferences

        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
        PreferenceManager.setDefaultValues(this,R.xml.preferences,false);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);


    }
    public void toggleContents(View view){
        Log.e("toggleContents","toggleContents: "+view.getId() );
        switch(view.getId()){
            case R.id.guide1Layout:
                guide1Body.setVisibility(guide1Body.isShown() ? View.GONE : View.VISIBLE);
                break;
            case R.id.guide2Layout:
                guide2Body.setVisibility(guide2Body.isShown() ? View.GONE : View.VISIBLE);
                break;
            case R.id.guide3Layout:
                guide3Body.setVisibility(guide3Body.isShown() ? View.GONE : View.VISIBLE);
                break;
            case R.id.guide4Layout:
                guide4Body.setVisibility(guide4Body.isShown() ? View.GONE : View.VISIBLE);
                break;
            default:
                break;
        }

        //guide2Body.setVisibility(guide2Body.isShown() ? View.GONE : View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(
                R.menu.activity_menu_preferences, menu
        );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                startActivity(new Intent(
                        getApplicationContext(), SettingsActivity.class
                ));
                return true;
            case R.id.menu_about:
                Log.e("menu_about: ", "menu_about");
                Toast.makeText(this, R.string.about_summary, Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.checkBox1:
                if(checkBox1.isChecked())
                Toast.makeText(this, R.string.checkbox1_congrats, Toast.LENGTH_LONG).show();

                break;
            case R.id.checkBox2:
                if(checkBox2.isChecked())
                Toast.makeText(this, R.string.checkbox2_congrats, Toast.LENGTH_LONG).show();
                break;
            case R.id.checkBox3:
                if(checkBox3.isChecked())
                Toast.makeText(this, R.string.checkbox3_congrats, Toast.LENGTH_LONG).show();
                break;
            case R.id.checkBox4:
                if(checkBox4.isChecked())
                Toast.makeText(this, R.string.checkbox4_congrats, Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }



    }


    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = savedValues.edit();
        Log.e("onPause: ", "onPause");
        rememberUserChnages= prefs.getBoolean("pref_changes_saved",true);
        Log.e("rememberUserChnages", String.valueOf(rememberUserChnages));
        if(rememberUserChnages) {
            editor.putBoolean("checkbox1", checkBox1.isChecked());
            Log.e("checkbox1", String.valueOf(checkBox1.isChecked()));
            editor.putBoolean("checkbox2", checkBox2.isChecked());
            Log.e("checkbox2", String.valueOf(checkBox2.isChecked()));
            editor.putBoolean("checkbox3", checkBox3.isChecked());
            Log.e("checkbox3", String.valueOf(checkBox3.isChecked()));
            editor.putBoolean("checkbox4", checkBox4.isChecked());
            Log.e("checkbox4", String.valueOf(checkBox4.isChecked()));
            editor.commit();
        }else{
            editor.clear().commit();

        }



    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = savedValues.edit();
        Log.e("onPause: ", "onPause");
        rememberUserChnages= prefs.getBoolean("pref_changes_saved",true);
        Log.e("rememberUserChnages", String.valueOf(rememberUserChnages));
        if(rememberUserChnages) {
            editor.putBoolean("checkbox1", checkBox1.isChecked());
            Log.e("checkbox1", String.valueOf(checkBox1.isChecked()));
            editor.putBoolean("checkbox2", checkBox2.isChecked());
            Log.e("checkbox2", String.valueOf(checkBox2.isChecked()));
            editor.putBoolean("checkbox3", checkBox3.isChecked());
            Log.e("checkbox3", String.valueOf(checkBox3.isChecked()));
            editor.putBoolean("checkbox4", checkBox4.isChecked());
            Log.e("checkbox4", String.valueOf(checkBox4.isChecked()));
            editor.commit();
        }else{
            editor.clear().commit();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "onResume");
        rememberUserChnages= prefs.getBoolean("pref_changes_saved",true);
        Log.e("rememberUserChnages", String.valueOf(rememberUserChnages));
        if(rememberUserChnages) {
            boolean checkbox1Var = savedValues.getBoolean("checkbox1",false);
            boolean checkbox2Var = savedValues.getBoolean("checkbox2",false);
            boolean checkbox3Var = savedValues.getBoolean("checkbox3",false);
            boolean checkbox4Var = savedValues.getBoolean("checkbox4",false);
            if(checkbox1Var){checkBox1.setChecked(true);}
            if(checkbox2Var){checkBox2.setChecked(true);}
            if(checkbox3Var){checkBox3.setChecked(true);}
            if(checkbox4Var){checkBox4.setChecked(true);}

        }else{
            Log.e("false", "false");

        }
    }
}
