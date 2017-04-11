package com.example.me74.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // This array should contain all the answers. will use it for another iteration of the app
    boolean[] answerArray =
            {false, true, false, true, true, false,
                    true, false, true, true, false, true,
                    true, false,
                    true, false, true, false,
                    false, false, false, true
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit answers button is clicked.
     */
    public void submitAnswers(View view) {

        int score = 0;
        int pointsPerRightAnswer = 1;
        int pointsPerWrongAnswer = -1;

        // Get the name which is input into EditText field
        EditText nameInput = (EditText) findViewById(R.id.name_input);
        String userName = nameInput.getText().toString();

        // a CompoundButton Object is declared which will be used for the Checkbox and Radiobutton answer checks
        CompoundButton answersToQuestions;

        // Check answers to question 1. Multiple can be checked. If wrong answers are checked, the points will decrease
        answersToQuestions = (CheckBox) findViewById(R.id.anwser_1);
        if (answersToQuestions.isChecked()) {
            score += pointsPerWrongAnswer;
        }
        answersToQuestions = (CheckBox) findViewById(R.id.anwser_2);
        if (answersToQuestions.isChecked()) {
            score += pointsPerRightAnswer;
        }
        answersToQuestions = (CheckBox) findViewById(R.id.anwser_3);
        if (answersToQuestions.isChecked()) {
            score += pointsPerWrongAnswer;
        }
        answersToQuestions = (CheckBox) findViewById(R.id.anwser_4);
        if (answersToQuestions.isChecked()) {
            score += pointsPerRightAnswer;
        }
        answersToQuestions = (CheckBox) findViewById(R.id.anwser_5);
        if (answersToQuestions.isChecked()) {
            score += pointsPerRightAnswer;
        }
        answersToQuestions = (CheckBox) findViewById(R.id.anwser_6);
        if (answersToQuestions.isChecked()) {
            score += pointsPerWrongAnswer;
        }

        // Check answers to question 2. Multiple can be checked. If wrong answers are checked, the points will decrease
        answersToQuestions = (CheckBox) findViewById(R.id.anwser_7);
        if (answersToQuestions.isChecked()) {
            score += pointsPerRightAnswer;
        }
        answersToQuestions = (CheckBox) findViewById(R.id.anwser_8);
        if (answersToQuestions.isChecked()) {
            score += pointsPerWrongAnswer;
        }
        answersToQuestions = (CheckBox) findViewById(R.id.anwser_9);
        if (answersToQuestions.isChecked()) {
            score += pointsPerRightAnswer;
        }
        answersToQuestions = (CheckBox) findViewById(R.id.anwser_10);
        if (answersToQuestions.isChecked()) {
            score += pointsPerRightAnswer;
        }
        answersToQuestions = (CheckBox) findViewById(R.id.anwser_11);
        if (answersToQuestions.isChecked()) {
            score += pointsPerWrongAnswer;
        }
        answersToQuestions = (CheckBox) findViewById(R.id.anwser_12);
        if (answersToQuestions.isChecked()) {
            score += pointsPerRightAnswer;
        }

        /** Check answers to question 3. Only one can be checked, so only the right one will increase score
         *  If the radio button wit the right answer is changed, then the ID has to be changed to the correct button
         */
        answersToQuestions = (RadioButton) findViewById(R.id.anwser_13);
        if (answersToQuestions.isChecked()) {
            score += pointsPerRightAnswer;
        }

        /** Check answers to question 4. Only one can be checked, so only the right one will increase score
         *  If the radio button wit the right answer is changed, then the ID has to be changed to the correct button
         */
        answersToQuestions = (RadioButton) findViewById(R.id.anwser_15);
        if (answersToQuestions.isChecked()) {
            score += pointsPerRightAnswer;
        }

        /** Check answers to question 6. Only one can be checked, so only the right one will increase score
         *  If the radio button wit the right answer is changed, then the ID has to be changed to the correct button
         */
        answersToQuestions = (RadioButton) findViewById(R.id.anwser_22);
        if (answersToQuestions.isChecked()) {
            score += pointsPerRightAnswer;
        }

        /** Check answer to the free text question. As it cannot be scored based on an easy algorithm,
         *  the answer will be stored in a String and used for later scoring from the teacher.
         */
        EditText freeTextQuestionInput = (EditText) findViewById(R.id.freetext_answer_input_1);
        String freeTextAnswer = freeTextQuestionInput.getText().toString();

        // 42 is the answer to everything, so this will give an additional point :)
        if (freeTextAnswer.equals("42")) {
            score += pointsPerRightAnswer;
        }


        // Sets score to 0 if it is lower
        if (score < 0) {
            score = 0;
        }

        // Display the current score.
        display(score);

        /** Toast message to display that the quiz has finished, and to show the score.
         *  It will also notify the user, that the free text will be evaluated separately
         */
        Toast.makeText(this, getString(R.string.toast_message_congrats, userName) + "\n" +
                        getString(R.string.toast_message_score, String.valueOf(score))
                , Toast.LENGTH_LONG).show();


       Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{String.valueOf(R.string.email_adress)});
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject, userName));
        intent.putExtra(Intent.EXTRA_TEXT, freeTextAnswer);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }



    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.score_view);
        quantityTextView.setText("" + number);
    }
}

