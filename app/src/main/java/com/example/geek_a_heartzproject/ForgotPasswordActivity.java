package com.example.geek_a_heartzproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.regex.Pattern;

public class ForgotPasswordActivity extends AppCompatActivity {


    private EditText emailEditText;
    private Button resetPwButton, goToLogin;
    LottieAnimationView lottieAnimationView;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        emailEditText = findViewById(R.id.forgotPwEmail);
        resetPwButton = findViewById(R.id.resetPasswordButton);
        lottieAnimationView = findViewById(R.id.animationLottieFP);
        goToLogin = findViewById(R.id.goToLogin);

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPasswordActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        auth = FirebaseAuth.getInstance();

        resetPwButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }

            private void resetPassword() {

                String email = emailEditText.getText().toString().trim();

                if (email.isEmpty()){
                    emailEditText.setError("Email is required");
                    emailEditText.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    emailEditText.setError("Please provide a valid email");
                    emailEditText.requestFocus();
                    return;
                }
                lottieAnimationView.setVisibility(View.VISIBLE);
                auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            FancyToast.makeText(ForgotPasswordActivity.this, "Password Reset Email Sent", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true);
                            lottieAnimationView.setVisibility(View.GONE);
                        } else {
                            FancyToast.makeText(ForgotPasswordActivity.this, "Error Occurred, Please Try Again", FancyToast.LENGTH_LONG, FancyToast.ERROR, true);
                            lottieAnimationView.setVisibility(View.GONE);
                        }
                    }
                });
            }

        });



    }
}