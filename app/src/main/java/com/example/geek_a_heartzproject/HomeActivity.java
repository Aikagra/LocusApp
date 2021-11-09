package com.example.geek_a_heartzproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    private int[] images;
    private String[] text;
    private SliderAdapter adapter;
    private SliderView sliderView;
    BottomNavigationView bottomNavigationView;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //assigning id's

       bottomNavigationView = findViewById(R.id.bottomNavBar);

       bottomNavigationView.setSelectedItemId(R.id.homeItem);

        CardView cardViewMentor1 = findViewById(R.id.cardviewMentor1);
        CardView cardViewMentor2 = findViewById(R.id.cardviewMentor2);
        CardView cardViewMentor3 = findViewById(R.id.cardviewMentor3);

        CardView cardViewWorkshop1 = findViewById(R.id.cardviewWorshop1);
        CardView cardViewWorkshop2 = findViewById(R.id.cardviewWorshop2);
        CardView cardViewWorkshop3 = findViewById(R.id.cardviewWorshop3);

        CircleImageView profileDetails = findViewById(R.id.profilePic);



        arrayList = new ArrayList<String>();

        //search view complete search for mentors
        arrayList.add("Jimmy Dasaint");
        arrayList.add("Ben Decker");
        arrayList.add("Naresh Narasimhan");

        //search view recommendations for workshops
        arrayList.add("Startup Advice Sessions");
        arrayList.add("The Open University");
        arrayList.add("Offline Workshops");


        //change image and name through clicking from the searchview items

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.searchBar);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Index", "" + i);
                Intent intent = new Intent(HomeActivity.this, SharedElementMentorActivity.class);
                //change name
                intent.putExtra("name_transition", ((TextView) view).getText());
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.workshop1);
                if (((TextView) view).getText() == "The Open University")
                {
                    intent.putExtra("imgTransition", R.drawable.workshop2);
                }
                if (((TextView) view).getText() == "Offline Workshops")
                {
                    intent.putExtra("imgTransition", R.drawable.workshop3);
                }
                if (((TextView) view).getText() == "Jimmy Dasaint")
                {
                    intent.putExtra("imgTransition", R.drawable.mentor1);
                }
                if (((TextView) view).getText() == "Ben Decker")
                {
                    intent.putExtra("imgTransition", R.drawable.mentor2);
                }
                if (((TextView) view).getText() == "Naresh Narasimhan")
                {
                    intent.putExtra("imgTransition", R.drawable.mentor3);
                }

                startActivity(intent);
            }
        });


        //change name and image through clicking the cardview

        cardViewMentor2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(HomeActivity.this, SharedElementMentorActivity.class);
                                            //change name
                                            intent.putExtra("name_transition", "Ben Decker");
                                            //may need later
                                            //intent.putExtra("text_transition", "homeTextTransition");
                                            //change image
                                            intent.putExtra("imgTransition", R.drawable.mentor2);
                                            startActivity(intent);
                                        }
                                    });

        cardViewMentor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SharedElementMentorActivity.class);
                //change name
                intent.putExtra("name_transition", "Jimmy Dasaint");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.mentor1);
                startActivity(intent);
            }
        });

        cardViewMentor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SharedElementMentorActivity.class);
                //change name
                intent.putExtra("name_transition", "Naresh Narasimhan");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.mentor3);
                startActivity(intent);
            }
        });

        cardViewWorkshop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SharedElementMentorActivity.class);
                //change name
                intent.putExtra("name_transition", "Startup Advice Sessions");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.workshop1);
                startActivity(intent);
            }
        });

        cardViewWorkshop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SharedElementMentorActivity.class);
                //change name
                intent.putExtra("name_transition", "The Open University");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.workshop2);
                startActivity(intent);
            }
        });

        cardViewWorkshop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SharedElementMentorActivity.class);
                //change name
                intent.putExtra("name_transition", "Offline Workshops");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.workshop3);
                startActivity(intent);
            }
        });

        //adding functionality to the profile button

        profileDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(HomeActivity.this, profileDetails,  ViewCompat.getTransitionName(profileDetails));
                startActivity(intent, options.toBundle());
            }
        });

        //adding functionality to when bottom navigation is clicked


                bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.fundingItem:
                                startActivity(new Intent(getApplicationContext(),
                                        FundingActivity.class));
                                overridePendingTransition(0, 0);
                                return true;
                            case R.id.homeItem:
                                return true;
                            case R.id.learnItem:
                                startActivity(new Intent(getApplicationContext(),
                                        LearnActivity.class));
                                overridePendingTransition(0, 0);
                                return true;
                        }
                        return false;
                    }
                });

        sliderView = findViewById(R.id.sliderView);
        images = new int[]{R.drawable.carousel1, R.drawable.carousel2, R.drawable.carousel3};


        adapter = new SliderAdapter(images, text);

        sliderView.setSliderAdapter(adapter);

        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.startAutoCycle();



    }
}