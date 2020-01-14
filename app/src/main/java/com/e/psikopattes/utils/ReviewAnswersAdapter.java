package com.e.psikopattes.utils;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.e.psikopattes.R;
import com.e.psikopattes.data.Question;

import java.util.List;


public class ReviewAnswersAdapter extends ArrayAdapter<Question> {


    public ReviewAnswersAdapter(@NonNull Context context, List<Question> questions) {
        super(context, 0, questions);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_review_list_item, parent, false);
        }

        final Question question = getItem(position);
        TextView questionTextView = convertView.findViewById(R.id.review_question_textview);
        TextView answerTextView = convertView.findViewById(R.id.review_answer_textview);

        if (question != null) {
            questionTextView.setText(question.getQuestion());
            answerTextView.setText(question.getAnswer());
        }

        return convertView;
    }
}

