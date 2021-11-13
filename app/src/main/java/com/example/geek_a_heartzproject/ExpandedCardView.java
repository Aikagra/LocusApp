package com.example.geek_a_heartzproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

public class ExpandedCardView extends AppCompatActivity {

    TextView nameTransition, textTransition;
    ShapeableImageView imgTransition;
    AppCompatImageButton appCompatImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_card_view);

        //assigning id's

        nameTransition = findViewById(R.id.nameTransition);
        textTransition = findViewById(R.id.textTransition);

        imgTransition = findViewById(R.id.imgTransition);

        appCompatImageButton = findViewById(R.id.backBtnCardView);

        appCompatImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        String nameTransition1 = getIntent().getStringExtra("name_transition");

        String textTransition1 = getIntent().getStringExtra("text_transition");

        int imgTransition1 = getIntent().getIntExtra("imgTransition", 0);

        nameTransition.setText(nameTransition1);
       // textTransition.setText(textTransition1);
        imgTransition.setImageDrawable(getResources().getDrawable(imgTransition1));

        imgTransition.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}