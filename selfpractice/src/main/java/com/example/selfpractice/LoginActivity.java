package com.example.selfpractice;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText userName, password;
    Button userLoginBtn;
    private final int RC_SIGN_IN=100;
    private final String TAG=LoginActivity.class.getSimpleName();
    GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.userPwd);
        userLoginBtn = findViewById(R.id.loginBtn);
        TextView signupTxt = findViewById(R.id.signupTxt);

        findViewById(R.id.sign_in_button).setOnClickListener(this);


        userLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userName.getText().toString().contentEquals(password.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra(AppConstants.usernamekey, userName.getText().toString());
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "usernamekey and password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     startActivity(new Intent(LoginActivity.this, SignUpActivity.class));

             }
        });


        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestServerAuthCode("283739839662-be8r1mvv05vi2rr7aorj2obqnj076be4.apps.googleusercontent.com")
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
         mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    }


    @Override
    protected void onStart() {
        super.onStart();

        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);

    }

    private void updateUI(GoogleSignInAccount account) {

        if(account==null)
            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
         else {
            findViewById(R.id.sign_in_button).setVisibility(View.GONE);
            Intent gotoMainActivityIntent = new Intent(this, MainActivity.class);
            gotoMainActivityIntent.putExtra(AppConstants.usernamekey,account.getDisplayName());
            startActivity(gotoMainActivityIntent);
            finish();

        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;

    }
}


    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
            Toast.makeText(this, "Google signin is Sussfull", Toast.LENGTH_SHORT).show();



        }
        else {
            Toast.makeText(this, "Google signin failed. please try agian", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }


//    GoogleSignInAccount accountt = GoogleSignIn.getLastSignedInAccount(this);{
//
//        Log.d("email------->>>", String.valueOf(accountt));
////        if (accountt != null){
////
////            String personEmail = accountt.getEmail();
////
////            Log.d("email adress---->>>", personEmail);
////
////
////
////        }
//
//    }


}
