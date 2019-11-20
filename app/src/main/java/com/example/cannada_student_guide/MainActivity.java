package com.example.cannada_student_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_menu_preferences,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//respond to menu item selection

        switch(item.getItemId()){
            case R.id.menu_settings:
                Toast.makeText(this,R.string.menu_settings,Toast.LENGTH_SHORT);
                return true;
            case R.id.menu_about:
                Toast.makeText(this,R.string.about_summary,Toast.LENGTH_LONG);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
