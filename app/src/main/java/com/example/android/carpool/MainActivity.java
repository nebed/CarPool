package com.example.android.carpool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    int images[]={R.drawable.connect, R.drawable.early, R.drawable.save};
    TextView signup;
    private TextView login;
    private FirebaseAuth auth;
    private static final int RC_SIGN_IN = 200;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String PATH_TOS ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup=findViewById(R.id.signup);
        login=findViewById(R.id.login);

        auth = FirebaseAuth.getInstance();
        if (isUserLogin()){
            loginUser();
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, signUpActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
                .setTosUrl(PATH_TOS)
                .build(),RC_SIGN_IN);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RC_SIGN_IN){
            if(resultCode==RESULT_OK){
                loginUser();
            }
        }
        if (resultCode==RESULT_CANCELED){
            displayMessage("Log In Failed");
        }
        displayMessage("Unknown Response");

    }

    private boolean isUserLogin(){
        if(auth.getCurrentUser() !=null){
            return true;
        }
        return false;
    }

    private void loginUser(){
        Intent loginIntent= new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }
    private void displayMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }


}

