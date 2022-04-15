package com.clarence.recaptchademo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
  To Improve this application I want you to add the following.
  TODO LIST:

  * When validating the username field, I want be able to enter Uppercase("Admin") or Lowercase("admin") and still be able to log in with correct password.

  * Add for password Hint "Must be numeric" disable the input of letters.

  * Change the background wall paper, text color of the username and password, and when attempts = 0 make the text field red.

  * Change the app name at the top

  * When attempts are equal to zero, show a sadface smiley image and hide the username and password textview (set their visibility to "none")

*/


public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks {

    // Initialize the variables
    CheckBox checkBox;
    GoogleApiClient googleApiClient;
    private EditText name;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter = 8;
    private ImageView smileImage;


    // Put SiteKeyas as a String variable
    String sitekey = "6LeFrmgfAAAAAAecS7iAdD0_fqotQItNwLvmztOL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning the variables

        name = (EditText) findViewById(R.id.etname);
        password = (EditText) findViewById((R.id.etpassword));
        info = (TextView) findViewById(R.id.tvinfo);
        login = (Button) findViewById(R.id.btnlogin);
        smileImage = (ImageView) findViewById(R.id.imageView);

        info.setText("Number attempts remaining: 8");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callreCaptchatoCheckUser();

            }
        });


        // Create a google api client
        googleApiClient = new GoogleApiClient.Builder(this).addApi(SafetyNet.API).addConnectionCallbacks(MainActivity.this).build();
        googleApiClient.connect();
    }

    @SuppressLint("SetTextI18n")
    private void validate(String userName, String userPassword) {
        // When validated is successful the SecondActivity will be displayed
        if ((userName.toLowerCase().equals("admin")) && userPassword.equals("1234")) {

            Intent intent2 = new Intent(this, SecondActivity.class);
            startActivity(intent2);
        } else {
            password.setText("");

            //on Unsuccessful validation the incorrect attempts counter will update
            counter--;

            info.setText("Number of attempts remaining:" + String.valueOf(counter));

            if (counter == 0) {
                name.setTextColor(Color.RED);
                password.setTextColor(Color.RED);
                name.setVisibility(View.INVISIBLE);
                password.setVisibility(View.INVISIBLE);
                smileImage.setVisibility(View.VISIBLE);
                login.setEnabled(false);
            }
        }
    }


    private void callreCaptchatoCheckUser() {
        //Set if condition when checkbox is checked
        SafetyNet.SafetyNetApi.verifyWithRecaptcha(googleApiClient, sitekey).setResultCallback(new ResultCallback<SafetyNetApi.RecaptchaTokenResult>() {
            @Override
            public void onResult(@NonNull SafetyNetApi.RecaptchaTokenResult recaptchaTokenResult) {

                Status status = recaptchaTokenResult.getStatus();
                if (status.isSuccess()) {
                    validate(name.getText().toString(), password.getText().toString());
                }
            }
        });
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {


    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}
