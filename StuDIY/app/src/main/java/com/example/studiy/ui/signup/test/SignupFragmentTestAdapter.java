package com.example.studiy.ui.signup.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studiy.R;

public class SignupFragmentTestAdapter extends RecyclerView.Adapter<SignupFragmentTestAdapter.ViewHolder> {
    private SignupViewModelTest stvm = SignupViewModelTest.getInstance();

    SignupFragmentTestAdapter() {
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.signup_fragment_test_item, parent, false);

        return new ViewHolder(view);
    }

    public void setColour(int i, ViewHolder holder) {
        switch (i) {
            case 0:
                holder.button_left.setBackgroundResource(R.drawable.misc_rounded_white);
                holder.button_right.setBackgroundResource(R.drawable.misc_rounded_white);
                break;
            case 1:
                holder.button_left.setBackgroundResource(R.drawable.misc_rounded_lightblue);
                holder.button_right.setBackgroundResource(R.drawable.misc_rounded_white);
                break;
            case 2:
                holder.button_left.setBackgroundResource(R.drawable.misc_rounded_white);
                holder.button_right.setBackgroundResource(R.drawable.misc_rounded_lightblue);
                break;
        }
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String question = stvm.getQuestions().get(position);
        String answer_a = stvm.getAnswers_a().get(position);
        String answer_b = stvm.getAnswers_b().get(position);
        holder.question.setText(question);
        holder.answer_a.setText(answer_a);
        holder.answer_b.setText(answer_b);
        setColour(stvm.getAnswers_submitted()[position], holder);

        // Sets listeners on the left/right choices of the MBTI test
        holder.button_left.setOnClickListener((a) -> {
            SignupFragmentTest.updateProgress();
            stvm.getAnswers_submitted()[position] = 1;
            setColour(1, holder);
        });
        holder.button_right.setOnClickListener((a) -> {
            SignupFragmentTest.updateProgress();
            stvm.getAnswers_submitted()[position] = 2;
            setColour(2, holder);
        });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return stvm.getAnswers_a().size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView question;
        TextView answer_a;
        TextView answer_b;
        ConstraintLayout button_left;
        ConstraintLayout button_right;

        ViewHolder(View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.test_question);
            answer_a = itemView.findViewById(R.id.answer_a);
            answer_b = itemView.findViewById(R.id.answer_b);
            button_left = itemView.findViewById(R.id.button_left);
            button_right = itemView.findViewById(R.id.button_right);
        }

    }
}

