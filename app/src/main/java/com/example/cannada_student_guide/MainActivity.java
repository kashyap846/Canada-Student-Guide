package com.example.cannada_student_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ScrollView guide1Body,guide2Body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guide1Body = (ScrollView) findViewById(R.id.guide1Body);
        guide2Body = (ScrollView) findViewById(R.id.guide2Body);
        guide1Body.setVisibility(View.GONE);
        guide2Body.setVisibility(View.GONE);
    }
    public void toggleContents(View view){
        guide1Body.setVisibility(guide1Body.isShown() ? View.GONE : View.VISIBLE);
        guide2Body.setVisibility(guide2Body.isShown() ? View.GONE : View.VISIBLE);
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
                Toast.makeText(this, R.string.about_summary, Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
