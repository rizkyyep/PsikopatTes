package com.e.psikopattes.data;

import android.content.Context;

import com.e.psikopattes.R;

import java.util.ArrayList;
import java.util.Collections;

import static com.e.psikopattes.data.Options.RADIOBUTTON;

public class QuestionSet {

    public static ArrayList<Question> getAllQuestions(Context context) {
        ArrayList<Question> questions = new ArrayList<>();

        Question question1 = new Question(context.getString(R.string.q1), RADIOBUTTON, context.getResources().getStringArray(R.array.q1_options), Collections.singletonList(1));
        questions.add(question1);

        Question question2 = new Question(context.getString(R.string.q2), RADIOBUTTON, context.getResources().getStringArray(R.array.q2_options), Collections.singletonList(0));
        questions.add(question2);

        Question question3 = new Question(context.getString(R.string.q3), RADIOBUTTON, context.getResources().getStringArray(R.array.q3_options),Collections.singletonList(0));
        questions.add(question3);

        Question question4 = new Question(context.getString(R.string.q4), RADIOBUTTON, context.getResources().getStringArray(R.array.q4_options), Collections.singletonList(1));
        questions.add(question4);

        Question question5 = new Question(context.getString(R.string.q5), RADIOBUTTON, context.getResources().getStringArray(R.array.q5_options), Collections.singletonList(1));
        questions.add(question5);

        Question question6 = new Question(context.getString(R.string.q6), RADIOBUTTON, context.getResources().getStringArray(R.array.q6_options), Collections.singletonList(1));
        questions.add(question6);

        Question question7 = new Question(context.getString(R.string.q7), RADIOBUTTON,context.getResources().getStringArray(R.array.q7_options), Collections.singletonList(1));
        questions.add(question7);

        Question question8 = new Question(context.getString(R.string.q8), RADIOBUTTON,context.getResources().getStringArray(R.array.q8_options), Collections.singletonList(1));
        questions.add(question8);

        Question question9 = new Question(context.getString(R.string.q9), RADIOBUTTON,context.getResources().getStringArray(R.array.q9_options), Collections.singletonList(1));
        questions.add(question9);

        Question question10 = new Question(context.getString(R.string.q10), RADIOBUTTON,context.getResources().getStringArray(R.array.q10_options), Collections.singletonList(1));
        questions.add(question10);

        return questions;
    }
}
