package com.clarence.recaptchademo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks {
    // Initialize the variables
    CheckBox checkBox;
    GoogleApiClient googleApiClient;

    // Put SiteKeyas as a String variable
    String sitekey = "6LeFrmgfAAAAAAecS7iAdD0_fqotQItNwLvmztOL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning the variables

        checkBox = findViewById(R.id.check_box);

        // Create a google api client
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(SafetyNet.API)
                .addConnectionCallbacks(MainActivity.this)
                .build();
        googleApiClient.connect();

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set if condition when checkbox is checked
                if (checkBox.isChecked()){
                    SafetyNet.SafetyNetApi.verifyWithRecaptcha(googleApiClient, sitekey)
                            .setResultCallback(new ResultCallback<SafetyNetApi.RecaptchaTokenResult>() {
                                @Override
                                public void onResult(@NonNull SafetyNetApi.RecaptchaTokenResult recaptchaTokenResult) {

                                    Status status = recaptchaTokenResult.getStatus();
                                    if ((status != null) && status.isSuccess()){
                                        //Display Successful Message
                                        Toast.makeText(MainActivity.this, "Successfully Varified...", Toast.LENGTH_SHORT).show();
                                        //Change Checkbox text color
                                        checkBox.setTextColor(Color.GREEN);
                                    }
                                }
                            });
                } else {
                    //Default Checkbox text color
                    checkBox.setTextColor(Color.BLACK);
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
