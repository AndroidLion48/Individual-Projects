package com.clarence.workoutselector;

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
    TextView chosenExerciseTextView;
    Button chosenButton;
    Button addExerciseButton;
    EditText addExerciseEditText;

    ArrayList<String> exerciseList;

    Random random;
    // List for program to randomly select an entered value
    ArrayList<Integer> repslist;

    //Initiations are bellow
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topImageImageView = findViewById(R.id.topimage_imageview);
        appTitleTextView = findViewById(R.id.apptitle_textview);
        chosenExerciseTextView = findViewById(R.id.chosenexercise_textview);
        chosenButton = findViewById(R.id.chosen_button);
        addExerciseButton = findViewById(R.id.addexercise_button);
        addExerciseEditText = findViewById(R.id.addexercise_edittext);

        //Initiations of random foods
        exerciseList = new ArrayList<>();
        exerciseList.add("Squats");
        exerciseList.add("Squats");
        exerciseList.add("Pushups");
        exerciseList.add("Pushups");
        exerciseList.add("Burpies");
        exerciseList.add("Burpies");
        exerciseList.add("Body Builders");
        exerciseList.add("Steam Engines");

        repslist = new ArrayList<>();
        repslist.add(5);
        repslist.add(10);
        repslist.add(15);
        repslist.add(20);

        chosenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random = new Random();
                int reps = random.nextInt(repslist.size());
                String randomExercise = exerciseList.get(random.nextInt(exerciseList.size()));
                StringBuilder displayString = new StringBuilder();
                displayString.append(randomExercise);
                displayString.append(" x ");
                displayString.append(repslist.get(reps));
                chosenExerciseTextView.setText(displayString.toString());
            }
        });

        //User input of Text
        addExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If Else Statements can be used to check edit txt
                String userInputFood = addExerciseEditText.getText().toString();
                if (userInputFood.isEmpty()) {
                    addExerciseEditText.setText("");
                    Toast.makeText(getApplicationContext(), "No Entry, Enter Workout." + userInputFood, Toast.LENGTH_SHORT).show();
                } else {
                    exerciseList.add(userInputFood);
                    addExerciseEditText.setText("");
                    Toast.makeText(getApplicationContext(), "Workout Added, LETS GO!!!  " + userInputFood, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}