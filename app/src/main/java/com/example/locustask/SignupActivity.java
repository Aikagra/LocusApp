package com.example.locustask;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignupActivity extends AppCompatActivity {

    Button backBtnSignup, signupBtn;
    EditText passwordSignup, nameSignup, emailSignup;
    private FirebaseAuth mAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

        setContentView(R.layout.activity_signup);

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
        }



        backBtnSignup = findViewById(R.id.backBtnSignup);
        signupBtn = findViewById(R.id.signupButton);
        passwordSignup = findViewById(R.id.passwordSignup);
        nameSignup = findViewById(R.id.nameSignup);
        mAuth = FirebaseAuth.getInstance();
        emailSignup = findViewById(R.id.emailSignup);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Users");
        CustomDialogClass cdd = new CustomDialogClass(SignupActivity.this);


        //Toast for signup button

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }

            private void registerUser() {
                String email = emailSignup.getText().toString().trim();
                String password = passwordSignup.getText().toString().trim();
                String name = nameSignup.getText().toString().trim();

                if (name.isEmpty()){
                    nameSignup.setError("Full Name is required");
                    nameSignup.requestFocus();
                    return;
                }
                if (email.isEmpty()){
                    emailSignup.setError("Email is required");
                    emailSignup.requestFocus();
                    return;
                }
                if (!Patterns.WEB_URL.matcher(email).matches()){
                    emailSignup.setError("Provide a valid email");
                    emailSignup.requestFocus();
                    return;
                }

                if (password.isEmpty()){
                    passwordSignup.setError("Password is Required");
                    passwordSignup.requestFocus();
                    return;
                }

                if (password.length() < 4){
                    passwordSignup.setError("Provide a password with at least 4 characters");
                    passwordSignup.requestFocus();
                    return;
                }

                if (password.length() > 6){
                    passwordSignup.setError("Password cannot be more than 6 digits");
                    passwordSignup.requestFocus();
                    return;
                }

                cdd.show();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){

                                    UserHelperClass helperClass = new UserHelperClass(name, email);

                                    reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(password);

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (!task.isSuccessful())
                                            {
                                                FancyToast.makeText(SignupActivity.this, "Verification Email Sent", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();
                                                cdd.show();
                                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                            }else {
                                                Log.d(TAG, "on Failure : email not sent" + task.getException().getMessage());
                                                cdd.show();
                                            }
                                        }
                                    });
                                } else {
                                    FancyToast.makeText(SignupActivity.this, "Signup Unsuccessful", FancyToast.ERROR, FancyToast.LENGTH_SHORT, true).show();
                                    cdd.show();
                                }
                            }
                        });

            }
        });



        //functionality for login button on signup page

        backBtnSignup.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
            }else {
                startActivity(intent);
            }
        });
    }
}

