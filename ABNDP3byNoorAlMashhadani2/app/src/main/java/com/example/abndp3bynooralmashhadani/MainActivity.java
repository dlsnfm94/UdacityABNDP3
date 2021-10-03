package com.example.abndp3bynooralmashhadani;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abndp3bynooralmashhadani.databinding.ActivityMainBinding;
import com.example.abndp3bynooralmashhadani.databinding.ActivityQuizBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    ActivityQuizBinding activityQuizBinding;

    String name;

    String ANSWER_1_1 = "과일";
    String ANSWER_1_2 = "날짜";
    String ANSWER_1_3 = "보무";

    String ANSWER_3_1 = "이에요";
    String ANSWER_3_2 = "예요";
    String ANSWER_3_3 = "예요";
    String ANSWER_3_4 = "이에요";

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View activityMainView = activityMainBinding.getRoot();
        setContentView(activityMainView);

        activityMainBinding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = activityMainBinding.nameEditText.getText().toString();

                activityQuizBinding = ActivityQuizBinding.inflate(getLayoutInflater());
                View activityQuizView = activityQuizBinding.getRoot();
                setContentView(activityQuizView);

                activityQuizBinding.submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RadioButton question1_1Answer = findViewById(activityQuizBinding.question11options.getCheckedRadioButtonId());
                        if (question1_1Answer.getText().toString().equals(ANSWER_1_1)) {
                            question1_1Answer.setTextColor(getResources().getColor(R.color.green));
                            score++;
                        } else question1_1Answer.setTextColor(getResources().getColor(R.color.red));

                        RadioButton question1_2Answer = findViewById(activityQuizBinding.question12options.getCheckedRadioButtonId());
                        if (question1_2Answer.getText().toString().equals(ANSWER_1_2)) {
                            question1_2Answer.setTextColor(getResources().getColor(R.color.green));
                            score++;
                        } else question1_2Answer.setTextColor(getResources().getColor(R.color.red));

                        RadioButton question1_3Answer = findViewById(activityQuizBinding.question13options.getCheckedRadioButtonId());
                        if (question1_3Answer.getText().toString().equals(ANSWER_1_3)) {
                            question1_3Answer.setTextColor(getResources().getColor(R.color.green));
                            score++;
                        } else question1_3Answer.setTextColor(getResources().getColor(R.color.red));

                        if (activityQuizBinding.question2Option1.isChecked()) {
                            activityQuizBinding.question2Option1.setTextColor(getResources().getColor(R.color.green));
                            score++;
                        }

                        if (activityQuizBinding.question2Option2.isChecked()) {
                            activityQuizBinding.question2Option2.setTextColor(getResources().getColor(R.color.green));
                            score++;
                        }

                        if (activityQuizBinding.question2Option3.isChecked())
                            activityQuizBinding.question2Option3.setTextColor(getResources().getColor(R.color.red));

                        if (activityQuizBinding.question2Option4.isChecked())
                            activityQuizBinding.question2Option4.setTextColor(getResources().getColor(R.color.red));

                        if (activityQuizBinding.question2Option5.isChecked()) {
                            activityQuizBinding.question2Option5.setTextColor(getResources().getColor(R.color.green));
                            score++;
                        }

                        if (activityQuizBinding.question31answer.getText().toString().equals(ANSWER_3_1)) {
                            activityQuizBinding.question31answer.setTextColor(getResources().getColor(R.color.green));
                            score++;
                        } else
                            activityQuizBinding.question31answer.setTextColor(getResources().getColor(R.color.red));

                        if (activityQuizBinding.question32answer.getText().toString().equals(ANSWER_3_2)) {
                            activityQuizBinding.question32answer.setTextColor(getResources().getColor(R.color.green));
                            score++;
                        } else
                            activityQuizBinding.question32answer.setTextColor(getResources().getColor(R.color.red));

                        if (activityQuizBinding.question33answer.getText().toString().equals(ANSWER_3_3)) {
                            activityQuizBinding.question33answer.setTextColor(getResources().getColor(R.color.green));
                            score++;
                        } else
                            activityQuizBinding.question33answer.setTextColor(getResources().getColor(R.color.red));

                        if (activityQuizBinding.question34answer.getText().toString().equals(ANSWER_3_4)) {
                            activityQuizBinding.question34answer.setTextColor(getResources().getColor(R.color.green));
                            score++;
                        } else
                            activityQuizBinding.question34answer.setTextColor(getResources().getColor(R.color.red));

                        for (int i = 0; i <= 1; i++) {
                            Toast.makeText(getApplicationContext(), resultMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    public String resultMessage() {
        String resultMessage = "";
        if (score == 10)
            resultMessage = "You got " + score + "/10\nCongrats, " + name + "! You got full marks!";
        else if (score >= 5)
            resultMessage = "You got " + score + "/10\nCongrats, " + name + "! You passed!";
        else
            resultMessage = "You got " + score + "/10\nSorry, " + name + "! You failed! Review some more then try again";
        return resultMessage;
    }
}