package com.example.locustask;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.shashank.sony.fancytoastlib.FancyToast;


public class MainActivity extends AppCompatActivity {

    private Button registerBtn, loginBtn;
    private EditText loginEmail, loginPw;
    private FirebaseAuth mAuth;
    TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
        }


        registerBtn = findViewById(R.id.registerBtn);
        loginBtn = findViewById(R.id.loginBtn);
        loginEmail = findViewById(R.id.loginEmail);
        loginPw = findViewById(R.id.loginPw);
        mAuth = FirebaseAuth.getInstance();
        forgotPassword = findViewById(R.id.forgotPassword);
        CustomDialogClass cdd=new CustomDialogClass(MainActivity.this);



        //forgot password intent

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ForgotPasswordActivity.class));

            }

        });

        //login button functionality


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
                if (!Patterns.WEB_URL.matcher(email).matches()){
                    loginEmail.setError("Add a valid email");
                    loginEmail.requestFocus();
                    return;
                }
                if (password.isEmpty()){
                    loginPw.setError("Password is Required");
                    loginPw.requestFocus();
                    return;
                }

                cdd.show();

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
                            FancyToast.makeText(MainActivity.this, "Logged In Successfully",FancyToast.SUCCESS, FancyToast.LENGTH_SHORT, true).show();

                        } else {
                            FancyToast.makeText(MainActivity.this, "Failed to login, please check the credentials", FancyToast.ERROR, FancyToast.LENGTH_LONG, true).show();

                        }
                        cdd.dismiss();
                    }
                });
            }
        });


        //register button functionality

        registerBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SignupActivity.class);

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

            }

        });



    }



}






