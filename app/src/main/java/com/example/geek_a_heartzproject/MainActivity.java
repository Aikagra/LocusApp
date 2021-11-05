package com.example.geek_a_heartzproject;


import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class MainActivity extends AppCompatActivity {

  TextView registerBtn;
  ExtendedFloatingActionButton loginBtn;
  SoundPool soundPool;
  float volume;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
        }
        setContentView(R.layout.activity_main);

        registerBtn = findViewById(R.id.registerBtn);
        loginBtn = findViewById(R.id.loginBtn);
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);




        registerBtn.setOnClickListener(view -> {
            soundPool.play(R.raw.click, volume, volume, 1, 0, 1);
            Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

            }else {
                startActivity(intent);
            }

        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(R.raw.click, volume, volume, 1, 0, 1);
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                }

        });
        }

    }

