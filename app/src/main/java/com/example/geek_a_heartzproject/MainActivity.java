package com.example.geek_a_heartzproject;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    private Button registerBtn, loginBtn;
    private EditText loginEmail, loginPw;
    private LottieAnimationView lottieAnimationView;
    private FirebaseAuth mAuth;
    TextView forgotPassword;


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
        lottieAnimationView = findViewById(R.id.animationLottie);
        loginEmail = findViewById(R.id.loginEmail);
        loginPw = findViewById(R.id.loginPw);
        mAuth = FirebaseAuth.getInstance();
        forgotPassword = findViewById(R.id.forgotPassword);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ForgotPasswordActivity.class));
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }

            private void userLogin() {
                String email = loginEmail.getText().toString().trim();
                String password = loginPw.getText().toString().trim();

                if (email.isEmpty()){
                    loginEmail.setError("Email is Required");
                    loginEmail.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    loginEmail.setError("Add a valid email");
                    loginEmail.requestFocus();
                    return;
                }
                if (password.isEmpty()){
                    loginPw.setError("Password is Required");
                    loginPw.requestFocus();
                    return;
                }

                lottieAnimationView.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            startActivity(new Intent(MainActivity.this, HomeActivity.class));

                        } else {
                            Toast.makeText(MainActivity.this, "Failed to login, please check the credentials", Toast.LENGTH_LONG).show();
                            lottieAnimationView.setVisibility(View.GONE);

                        }
                    }
                });
            }
        });



        registerBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
            lottieAnimationView.setVisibility(View.VISIBLE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

            } else {

                lottieAnimationView.setVisibility(View.INVISIBLE);
            }

        });


    }



    }






