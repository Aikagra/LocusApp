package com.example.geek_a_heartzproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shashank.sony.fancytoastlib.FancyToast;

import org.w3c.dom.Text;

public class SignupActivity extends AppCompatActivity {

    TextView backBtnSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
        }

        setContentView(R.layout.activity_signup);

        backBtnSignup = findViewById(R.id.backBtnSignup);


        backBtnSignup.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
            }else {
                startActivity(intent);
            }


        });






    }

    public void signUpBtn(View view) {
        FancyToast.makeText(SignupActivity.this,
                "name = misterx" +
                        " password = fortnite12",
                FancyToast.LENGTH_LONG,
                FancyToast.SUCCESS,
                false)
                .show();

    }
}
