package com.example.geek_a_heartzproject;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    Button editProfileBtn, logoutBtn, resendEmail;
    AppCompatImageButton imageButton;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        editProfileBtn = findViewById(R.id.editProfileBtn);
        logoutBtn = findViewById(R.id.logoutBtnProfile);
        imageButton = findViewById(R.id.backBtnProfile);
        CircleImageView profileDetails = findViewById(R.id.profilePicProfile);
        resendEmail = findViewById(R.id.resendEmail);
        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = mAuth.getCurrentUser();
        CustomDialogClass cdd = new CustomDialogClass(ProfileActivity.this);

        //check if email is verified
        if (!user.isEmailVerified()){
            resendEmail.setVisibility(View.VISIBLE);

            resendEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    cdd.show();
                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            FancyToast.makeText(view.getContext(), "Verification Email Sent", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();
                            cdd.dismiss();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            FancyToast.makeText(view.getContext(), "Verification Email Failed", FancyToast.LENGTH_SHORT, FancyToast.ERROR, true).show();
                            Log.d(TAG, "on Failure : email not sent" + e.getMessage());
                            cdd.dismiss();
                        }
                    });
                }
            });
        }

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