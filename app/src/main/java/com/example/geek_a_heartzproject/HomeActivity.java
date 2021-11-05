package com.example.geek_a_heartzproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class HomeActivity extends AppCompatActivity {

    private int[] images;
    private String[] text;
    private SliderAdapter adapter;
    private SliderView sliderView;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       bottomNavigationView = findViewById(R.id.bottomNavBar);

       bottomNavigationView.setSelectedItemId(R.id.homeItem);

       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               switch (menuItem.getItemId()) {
                   case R.id.fundingItem:
                       startActivity(new Intent(getApplicationContext(),
                               FundingActivity.class));
                       overridePendingTransition(0,0);
                       return true;
                   case R.id.homeItem:
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

        sliderView = findViewById(R.id.sliderView);
        images = new int[]{R.drawable.dhar, R.drawable.fo};
        text = new String[]{"First Image", "Second Image"};

        adapter = new SliderAdapter(images, text);

        sliderView.setSliderAdapter(adapter);

        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.startAutoCycle();



    }
}