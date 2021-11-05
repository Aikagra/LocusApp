package com.example.geek_a_heartzproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FundingActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funding);

        bottomNavigationView = findViewById(R.id.bottomNavBar);

        bottomNavigationView.setSelectedItemId(R.id.fundingItem);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.fundingItem:
                        return true;
                    case R.id.homeItem:
                        startActivity(new Intent(getApplicationContext(),
                                HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.learnItem:
                        startActivity(new Intent(getApplicationContext(),
                                LearnActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}