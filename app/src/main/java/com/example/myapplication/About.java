package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class About extends AppCompatActivity {

    private DrawerLayout du;
    private ActionBarDrawerToggle abdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("About");


        du = (DrawerLayout)findViewById(R.id.du);
        abdt = new ActionBarDrawerToggle(this,du,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);


        du.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if(id == R.id.about)
                {
                    Toast.makeText(About.this, "About", Toast.LENGTH_SHORT).show();

                }
                else if(id == R.id.main)
                {
                    Toast.makeText(About.this, "Main", Toast.LENGTH_SHORT).show();
                    openMainActivity();
                }
                else if(id == R.id.second)
                {
                    Toast.makeText(About.this, "Second", Toast.LENGTH_SHORT).show();
                    openActivity2();
                }

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return abdt.onOptionsItemSelected(item)  || super.onOptionsItemSelected(item);
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);

    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
