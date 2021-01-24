package com.example.studiy.misc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.studiy.R;

public class SignupFragmentSubjectAdapterCopy extends RecyclerView.Adapter<SignupFragmentSubjectAdapterCopy.ViewHolder> {
    SignupFragmentSubjectAdapterCopy() {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.signup_fragment_test_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
//            myTextView = itemView.findViewById(R.id.tvAnimalName);
//            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


}
