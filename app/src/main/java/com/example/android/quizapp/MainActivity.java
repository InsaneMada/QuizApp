package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Quiz image
    ImageView quizImage;

    // Quiz user name
    EditText nameEditText;

    // Quiz submit button
    Button submitButton;

    // Quiz score
    int score = 0;

    // Question 1
    RadioButton q1A1;
    RadioButton q1A2;      // correct answer
    RadioButton q1A3;

    // Question 2
    RadioButton q2A1;      // correct answer
    RadioButton q2A2;
    RadioButton q2A3;

    // Question 3
    CheckBox q3A1;
    CheckBox q3A2;         // correct answer
    CheckBox q3A3;         // correct answer

    // Question 4
    CheckBox q4A1;         // correct answer
    CheckBox q4A2;
    CheckBox q4A3;         // correct answer

    // Question 5
    EditText q5EditText;   // Australia is the correct answer

    // Question 6
    EditText q6EditText;   // Istanbul is the correct answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizImage = (ImageView) findViewById(R.id.quiz);
        nameEditText = (EditText) findViewById(R.id.user_name);
        submitButton = (Button) findViewById(R.id.submit_button);
        q1A1 = (RadioButton) findViewById(R.id.q1_a1);
        q1A2 = (RadioButton) findViewById(R.id.q1_a2);
        q1A3 = (RadioButton) findViewById(R.id.q1_a3);
        q2A1 = (RadioButton) findViewById(R.id.q2_a1);
        q2A2 = (RadioButton) findViewById(R.id.q2_a2);
        q2A3 = (RadioButton) findViewById(R.id.q2_a3);
        q3A1 = (CheckBox) findViewById(R.id.q3_a1);
        q3A2 = (CheckBox) findViewById(R.id.q3_a2);
        q3A3 = (CheckBox) findViewById(R.id.q3_a3);
        q4A1 = (CheckBox) findViewById(R.id.q4_a1);
        q4A2 = (CheckBox) findViewById(R.id.q4_a2);
        q4A3 = (CheckBox) findViewById(R.id.q4_a3);
        q5EditText = (EditText) findViewById(R.id.q5_answer);
        q6EditText = (EditText) findViewById(R.id.q6_answer);
    }
    /*
    * this method is used when the RadioButtons are checked
    */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q1_a1:
                if (checked)
                    break;

            case R.id.q1_a2:
                if (checked)
                    break;

            case R.id.q1_a3:
                if (checked)
                    break;

            case R.id.q2_a1:
                if (checked)
                    break;

            case R.id.q2_a2:
                if (checked)
                    break;

            case R.id.q2_a3:
                if (checked)
                    break;
        }
    }
    /**
     * This method is for the submit button and showing the final score
     *
     * @param v
     */
    public void submitScore(View v) {

        String name = nameEditText.getText().toString();

        int totalScore = score();

        if (score == 6) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.message_1) + " " + name + "\n" +
                            getString(R.string.message_2), Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.message_3) + " " + name + "\n" +
                            getString(R.string.message_4) + " " + totalScore + " " +
                            getString(R.string.message_5) + "\n" + getString(R.string.message_6), Toast.LENGTH_LONG).show();
        }
        submitButton.setEnabled(false);
    }
    /*
     * Calculating total score
     */
    public int score() {
        boolean isQ3A2 = q3A2.isChecked();
        boolean isQ3A3 = q3A3.isChecked();
        boolean isQ4A1 = q4A1.isChecked();
        boolean isQ4A3 = q4A3.isChecked();

        if (q1A2.isChecked()) {
            score += 1;
        }
        if (q2A1.isChecked()) {
            score += 1;
        }
        if (isQ3A2 && isQ3A3) {
            score += 1;
        }
        if (isQ4A1 && isQ4A3) {
            score += 1;
        }
        if ("Australia".equals(q5EditText.getText().toString())){
            score += 1;
        }
        if ("Istanbul".equals(q6EditText.getText().toString())) {
            score += 1;
        }
        else {
            score += 0;
        }
        return score;
    }
    /*
    * A method that resets the quiz
    */
    public void resetQuiz(View v) {
        score = 0;
        nameEditText.setText("");

        q1A1.setChecked(false);
        q1A2.setChecked(false);
        q1A3.setChecked(false);
        q2A1.setChecked(false);
        q2A2.setChecked(false);
        q2A3.setChecked(false);
        q3A1.setChecked(false);
        q3A2.setChecked(false);
        q3A3.setChecked(false);
        q4A1.setChecked(false);
        q4A2.setChecked(false);
        q4A3.setChecked(false);

        q5EditText.setText("");
        q6EditText.setText("");

        // Enable submitButton
        submitButton.setEnabled(true);
    }
}