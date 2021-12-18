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

public class FundingActivity extends AppCompatActivity {

    CardView cardViewInvestor1, cardViewInvestor2, cardViewInvestor3, cardViewInvestor4
            ,cardViewVenture1, cardViewVenture2, cardViewVenture3, cardViewVenture4
            ,cardViewFunding1, cardViewFunding2, cardViewFunding3
            ,cardViewBank1, cardViewBank2, cardViewBank3;
    BottomNavigationView bottomNavigationView;
    ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funding);

        cardViewInvestor1 = findViewById(R.id.cardViewInvestor1);
        cardViewInvestor2 = findViewById(R.id.cardViewInvestor2);
        cardViewInvestor3 = findViewById(R.id.cardViewInvestor3);
        cardViewInvestor4 = findViewById(R.id.cardViewInvestor4);

        cardViewVenture1 = findViewById(R.id.ventureCapitalFirm1);
        cardViewVenture2 = findViewById(R.id.ventureCapitalFirm2);
        cardViewVenture3 = findViewById(R.id.ventureCapitalFirm3);
        cardViewVenture4 = findViewById(R.id.ventureCapitalFirm4);

        cardViewFunding1 = findViewById(R.id.crowdFunding1);
        cardViewFunding2 = findViewById(R.id.crowdFunding2);
        cardViewFunding3 = findViewById(R.id.crowdFunding3);

        cardViewBank1 = findViewById(R.id.cardviewBank1);
        cardViewBank2 = findViewById(R.id.cardviewBank2);
        cardViewBank3 = findViewById(R.id.cardviewBank3);

        CircleImageView profileDetails = findViewById(R.id.profilePicFunding);



        bottomNavigationView = findViewById(R.id.bottomNavBar);

        arrayList = new ArrayList<String>();

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


        //change image and name through clicking from the searchview items

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.searchBarFunding);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Index", "" + i);
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
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

        //change name and image when cardview is clicked

        //investors
        cardViewInvestor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "Roger Ehrenberg");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.angelinvestor1);
                startActivity(intent);
            }
        });

        cardViewInvestor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "Keith Rabois");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.angelinvestor2);
                startActivity(intent);
            }
        });

        cardViewInvestor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "Marc Andreessen");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.angelinvestor3);
                startActivity(intent);
            }
        });

        cardViewInvestor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "Anupam Mittal");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.angelinvestor4);
                startActivity(intent);
            }
        });

        //Venture Capital Firms

        cardViewVenture1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "Accel");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.venturecapitalfirm1);
                startActivity(intent);
            }
        });

        cardViewVenture2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "Andreessen Horowitz");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.venturecapitalfirm2);
                startActivity(intent);
            }
        });

        cardViewVenture3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "Index Ventures");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.venturecapitalfirm3);
                startActivity(intent);
            }
        });

        cardViewVenture4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "Sequoia");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.venturecapitalfirm4);
                startActivity(intent);
            }
        });

        //Crowdfunding sites

        cardViewFunding1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "KickStarter");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.crowdfunding1);
                startActivity(intent);
            }
        });

        cardViewFunding2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "IndieGogo");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.crowdfunding2);
                startActivity(intent);
            }
        });

        cardViewFunding3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "CrowdSupplu");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.crowdfunding3);
                startActivity(intent);
            }
        });

        //Banks

        cardViewBank1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "Bank of America");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.bank1);
                startActivity(intent);
            }
        });

        cardViewBank2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "JPMorgan Chase and Co.");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.bank2);
                startActivity(intent);
            }
        });

        cardViewBank3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ExpandedCardView.class);
                //change name
                intent.putExtra("name_transition", "Wells Fargo");
                //may need later
                //intent.putExtra("text_transition", "homeTextTransition");
                //change image
                intent.putExtra("imgTransition", R.drawable.bank3);
                startActivity(intent);
            }
        });

        //adding functionality to the profile button
        profileDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FundingActivity.this, ProfileActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(FundingActivity.this, profileDetails,  ViewCompat.getTransitionName(bottomNavigationView));
                startActivity(intent, options.toBundle());
            }
        });

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