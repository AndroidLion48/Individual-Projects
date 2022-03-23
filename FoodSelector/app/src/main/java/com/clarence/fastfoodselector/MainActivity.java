package com.clarence.fastfoodselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Declare Layout Variables
    ImageView topImageImageView;
    TextView appTitleTextView;
    TextView chosenFoodTextView;
    Button chosenButton;
    Button addFoodButton;
    EditText addFoodEditText;

    ArrayList<String> foodList;

    Random random;

    //Initiations are bellow
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topImageImageView = findViewById(R.id.topimage_imageview);
        appTitleTextView = findViewById(R.id.apptitle_textview);
        chosenFoodTextView = findViewById(R.id.chosenfood_textview);
        chosenButton = findViewById(R.id.chosen_button);
        addFoodButton = findViewById(R.id.addfood_button);
        addFoodEditText = findViewById(R.id.addfood_edittext);

        //Initiations of random foods
        foodList = new ArrayList<>();
        foodList.add("Wendy's");
        foodList.add("Burger King");
        foodList.add("Hardy's");
        foodList.add("McDonalds");

        chosenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random = new Random();
                String randomFood = foodList.get(random.nextInt(foodList.size()));
                chosenFoodTextView.setText(randomFood);
            }
        });

        //User input of Text
        addFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If Else Statements can be used to check edit txt
                String userInputFood = addFoodEditText.getText().toString();
                foodList.add(userInputFood);
                addFoodEditText.setText("");
                Toast.makeText(getApplicationContext() , "Food Added" + userInputFood, Toast.LENGTH_LONG).show();
            }
        });
    }
}