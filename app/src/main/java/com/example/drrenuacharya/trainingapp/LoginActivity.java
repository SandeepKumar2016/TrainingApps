package com.example.drrenuacharya.trainingapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

//checking version control. Its working

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    GoogleSignInClient mGoogleSignInClient;

     EditText etForUserName,etForPwd;
    private final int RC_SIGN_IN=100;
    private final String TAG=LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etForUserName=findViewById(R.id.etForUserName);
          etForPwd =findViewById(R.id.etForPwd);
        Button btnForSignin=findViewById(R.id.btnForSignin);
        btnForSignin.setOnClickListener(this);
        findViewById(R.id.tvForSignUp).setOnClickListener(this);

        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .requestServerAuthCode("60409020247-na8nr055evi51i9tgcimcopd7unp9qrd.apps.googleusercontent.com")
//                .build();

        // Build a GoogleSignInClient with the options specified by gso.
       // mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        //findViewById(R.id.sign_in_button).setOnClickListener(this);


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LoginActivity.class.getSimpleName(),"onstart()");
        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        //GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        //updateUI(account);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LoginActivity.class.getSimpleName(),"onResume()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LoginActivity.class.getSimpleName(),"onstop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LoginActivity.class.getSimpleName(),"onDestroy()");

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnForSignin){
            if(etForUserName.getText().toString().contentEquals(etForPwd.getText().toString())) {
                Intent intentToMain = new Intent(this, MainActivity.class);//from current context to Ongoing Activity
                intentToMain.putExtra("username",etForUserName.getText().toString());//key,value pair
                startActivity(intentToMain);
                finish();// this will destroy the activity
            }else
                Toast.makeText(this,"Username and password mismatch",Toast.LENGTH_SHORT).show();
        }else if (v.getId()==R.id.tvForSignUp){

            startActivity(new Intent(this,SignUpActivity.class));
        }
//        }else if(v.getId()==R.id.sign_in_button){
//            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//            startActivityForResult(signInIntent, RC_SIGN_IN);
//        }

    }

//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            if(resultCode!=RESULT_OK) {
//                Toast.makeText(this, "Google signin failed. please try agian", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            // The Task returned from this call is always completed, no need to attach
//            // a listener.
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            handleSignInResult(task);
//        }
//    }

//    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
//        try {
//            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
//
//            // Signed in successfully, show authenticated UI.
//            updateUI(account);
//        } catch (ApiException e) {
//            // The ApiException status code indicates the detailed failure reason.
//            // Please refer to the GoogleSignInStatusCodes class reference for more information.
//            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
//        }
//    }


//    void updateUI(GoogleSignInAccount account){
//        if(account==null) // if no LastSigned user is there with google
//            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
//        else{ // if lastSignedIn user is exist
//            findViewById(R.id.sign_in_button).setVisibility(View.GONE);
//            Toast.makeText(this,"Welcome "+account.getDisplayName(),Toast.LENGTH_SHORT).show();
//        }
//    }
}
