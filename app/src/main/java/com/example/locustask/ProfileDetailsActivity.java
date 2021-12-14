package com.example.locustask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.shashank.sony.fancytoastlib.FancyToast;

public class ProfileDetailsActivity extends AppCompatActivity {

    AppCompatImageButton imageButton;
    Button updateUser;
    EditText profileEditEmail, profileEditPassword, profileEditName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);


        //assigning id
        updateUser = findViewById(R.id.updateUser);
        imageButton = findViewById(R.id.backBtnProfileDetails);
        profileEditEmail = findViewById(R.id.profileEditEmail);
        profileEditPassword = findViewById(R.id.profileEditPassword);
        profileEditName = findViewById(R.id.profileEditName);

        //Toast for functionality not yet added when update button is clicked

        updateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FancyToast.makeText(ProfileDetailsActivity
                                .this, "Functionality not yet added",
                        FancyToast.LENGTH_LONG,
                        FancyToast.INFO, true).show();
            }
        });



        //adding functionality to back button

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



    }
}