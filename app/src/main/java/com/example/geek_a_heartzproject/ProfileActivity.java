package com.example.geek_a_heartzproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    Button editProfileBtn, logoutBtn;
    AppCompatImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        editProfileBtn = findViewById(R.id.editProfileBtn);
        logoutBtn = findViewById(R.id.logoutBtnProfile);
        imageButton = findViewById(R.id.backBtnProfile);
        CircleImageView profileDetails = findViewById(R.id.profilePicProfile);

        //functionality for back button

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //intent with shared element transition for edit profile button

        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, ProfileDetailsActivity.class );
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(ProfileActivity.this, profileDetails,  ViewCompat.getTransitionName(profileDetails));
                startActivity(intent, options.toBundle());
            }
        });

        //logout button functionality

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class );
                startActivity(intent);
                FancyToast.makeText(ProfileActivity.this, "Logged Out", FancyToast.LENGTH_SHORT, FancyToast.DEFAULT, true).show();
            }
        });



    }
}