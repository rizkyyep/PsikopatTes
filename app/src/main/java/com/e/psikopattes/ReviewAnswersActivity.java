package com.e.psikopattes;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.e.psikopattes.data.Options;
import com.e.psikopattes.data.Question;
import com.e.psikopattes.utils.ReviewAnswersAdapter;

import java.util.ArrayList;

import static com.e.psikopattes.MainActivity.QUESTIONS;
import static com.e.psikopattes.MainActivity.QUESTION_NUMBER;

public class ReviewAnswersActivity extends AppCompatActivity {

    private ArrayList<Question> questions;

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_list);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView emptyTextView = findViewById(R.id.empty_textview);
        ListView reviewListView = findViewById(R.id.review_listview);
        reviewListView.setEmptyView(emptyTextView);


        Intent intent = getIntent();
        questions = (ArrayList<Question>) intent.getSerializableExtra(QUESTIONS);

        ArrayList<Question> reviewQuestions = getReviewQuestions();

        final ReviewAnswersAdapter quizAdapter = new ReviewAnswersAdapter(ReviewAnswersActivity.this, reviewQuestions);
        reviewListView.setAdapter(quizAdapter);

        reviewListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Question reviewQuestion = quizAdapter.getItem(position);
                if (reviewQuestion != null) {
                    Intent intent = new Intent(ReviewAnswersActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    intent.putExtra(QUESTION_NUMBER, reviewQuestion.getqNumber());
                    startActivity(intent);
                }
            }
        });
    }

    private ArrayList<Question> getReviewQuestions() {
        ArrayList<Question> reviewQuestions = new ArrayList<>();

        for (int index = 0; index < questions.size(); index++) {

            Question question = questions.get(index);

            if (question.isMarkedForReview()) {
                String[] options = question.getOptions();
                Options optionsType = question.getOptionsType();

                Question reviewQuestion = null;
                switch (optionsType) {
                    case RADIOBUTTON:
                        if (question.getUserSetAnswerId() != null && question.getUserSetAnswerId().size() > 0) {
                            int id = question.getUserSetAnswerId().get(0);
                            reviewQuestion = new Question(question.getQuestion(), options[id], index);
                        } else {
                            reviewQuestion = new Question(question.getQuestion(), "Unanswered", index);
                        }
                        break;
                }
                reviewQuestions.add(reviewQuestion);
            }
        }
        return reviewQuestions;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}

