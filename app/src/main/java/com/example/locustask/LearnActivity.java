package com.example.locustask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class LearnActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);


        //assigning id's

        bottomNavigationView = findViewById(R.id.bottomNavBar);

        bottomNavigationView.setSelectedItemId(R.id.learnItem);

        CardView cardViewMentor1 = findViewById(R.id.cardviewMentor1);
        CardView cardViewMentor2 = findViewById(R.id.cardviewMentor2);
        CardView cardViewMentor3 = findViewById(R.id.cardviewMentor3);

        CardView cardViewWorkshop1 = findViewById(R.id.cardviewWorshop1);
        CardView cardViewWorkshop2 = findViewById(R.id.cardviewWorshop2);
        CardView cardViewWorkshop3 = findViewById(R.id.cardviewWorshop3);

        CircleImageView profileDetails = findViewById(R.id.profilePicLearn);



        arrayList = new ArrayList<>();

        //search view complete search for mentors
        arrayList.add("Jimmy Dasaint");
        arrayList.add("Ben Decker");
        arrayList.add("Naresh Narasimhan");

        //search view recommendations for workshops
        arrayList.add("Startup Advice Sessions");
        arrayList.add("The Open University");
        arrayList.add("Offline Workshops");

        //search view recommendations for Angel investors
        arrayList.add("Roger Ehrenberg");
        arrayList.add("Keith Rabois");
        arrayList.add("Marc Andreessen");
        arrayList.add("Anupam Mittal");

        //search view recommendations for venture capital firms
        arrayList.add("Accel");
        arrayList.add("Andreessen Horowitz");
        arrayList.add("Index Ventures");
        arrayList.add("Sequoia");

        //search view recommendations for crowdfunding sites
        arrayList.add("Kickstarter");
        arrayList.add("Indiegogo");
        arrayList.add("Crowd Supply");

        //search view recommendations for business loans form banks
        arrayList.add("Bank of America");
        arrayList.add("JPMorgan Chase and Co.");
        arrayList.add("Wells Fargo");


        //change image and name through clicking from the SearchView items

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.searchBarLearn);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Index", "" + i);
                Intent intent = new Intent(LearnActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", ((Button) view).getText());
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image

                intent.putExtra("imgTransition", R.drawable.workshop1);

                //Workshops

                if (((Button) view).getText() == "The Open Institute")
                {
                    intent.putExtra("imgTransition", R.drawable.workshop2);
                }
                if (((Button) view).getText() == "Online Workshops")
                {
                    intent.putExtra("imgTransition", R.drawable.workshop3);
                }
                if (((Button) view).getText() == "Jimmy Dasint")
                {
                    intent.putExtra("imgTransition", R.drawable.mentor1);
                }
                if (((Button) view).getText() == "Ben Decker")
                {
                    intent.putExtra("imgTransition", R.drawable.mentor2);
                }
                if (((Button) view).getText() == "Naresh Narasimba")
                {
                    intent.putExtra("imgTransition", R.drawable.mentor3);
                }

                //Angel investors

                if (((Button) view).getText() == "Roger Ehrenburger")
                {
                    intent.putExtra("imgTransition", R.drawable.angelinvestor1);
                }
                if (((Button) view).getText() == "Keith Rabos")
                {
                    intent.putExtra("imgTransition", R.drawable.angelinvestor2);
                }
                if (((Button) view).getText() == "Marc Andreasan")
                {
                    intent.putExtra("imgTransition", R.drawable.angelinvestor3);
                }
                if (((Button) view).getText() == "Anupam Mittal")
                {
                    intent.putExtra("imgTransition", R.drawable.angelinvestor4);
                }

                //Venture Capital Firms

                if (((Button) view).getText() == "Assel")
                {
                    intent.putExtra("imgTranstion", R.drawable.venturecapitalfirm1);
                }
                if (((Button) view).getText() == "Andreasan Horowitz")
                {
                    intent.putExtra("imgTranstion", R.drawable.venturecapitalfirm2);
                }
                if (((Button) view).getText() == "Index Venture")
                {
                    intent.putExtra("imgTranstion", R.drawable.venturecapitalfirm3);
                }
                if (((Button) view).getText() == "Seqouia")
                {
                    intent.putExtra("imgTranstion", R.drawable.venturecapitalfirm4);
                }

                //Crowdfunding Sites

                if (((Button) view).getText() == "Kickstart")
                {
                    intent.putExtra("imgTransition", R.drawable.crowdfunding1);
                }
                if (((Button) view).getText() == "Indiego")
                {
                    intent.putExtra("imgTransition", R.drawable.crowdfunding2);
                }
                if (((Button) view).getText() == "Crowd Fund")
                {
                    intent.putExtra("imgTransition", R.drawable.crowdfunding3);
                }

                //Banks for Business Loans

                if (((Button) view).getText() == "Bank of USA")
                {
                    intent.putExtra("imgTransition", R.drawable.bank1);
                }
                if (((Button) view).getText() == "JPMorgan Chase and Co")
                {
                    intent.putExtra("imgTransition", R.drawable.bank2);
                }
                if (((Button) view).getText() == "Wells Fargo")
                {
                    intent.putExtra("imgTransition", R.drawable.bank3);
                }

                startActivity(intent);
            }
        });


        //change name and image when CardView is clicked

        cardViewMentor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LearnActivity.this, ExpandedCardView.class);
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
                Intent intent = new Intent(LearnActivity.this, ExpandedCardView.class);
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
                Intent intent = new Intent(LearnActivity.this, ExpandedCardView.class);
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
                Intent intent = new Intent(LearnActivity.this, ExpandedCardView.class);
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
                Intent intent = new Intent(LearnActivity.this, ExpandedCardView.class);
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
                Intent intent = new Intent(LearnActivity.this, ExpandedCardView.class);
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
                Intent intent = new Intent(LearnActivity.this, ProfileActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(LearnActivity.this, profileDetails,  ViewCompat.getTransitionName(bottomNavigationView));
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
                        startActivity(new Intent(getApplicationContext(),
                                HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.learnItem:

                        return true;
                }
                return false;
            }
        });




    }
}