package com.example.studiy.ui.signup.subject;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studiy.R;
import com.example.studiy.classes.Person;
import com.example.studiy.ui.signup.SignupViewModelPerson;

public class SignupFragmentSubjectAdapter extends RecyclerView.Adapter<SignupFragmentSubjectAdapter.ViewHolder> {
    SignupViewModelPerson svmp = SignupViewModelPerson.getInstance();

    SignupFragmentSubjectAdapter() {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.signup_fragment_subject_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int bkgdres=0;
        if(position%2==0){
            bkgdres = R.drawable.misc_rounded_blue;
        }else bkgdres = R.drawable.misc_rounded_red;
        holder.subject_background.setBackgroundResource(bkgdres);
        holder.subject_background.setAlpha(0.1f);
        holder.subject_background.setElevation(10);
        holder.subject_background.setOnClickListener((i)->{
            Person person = svmp.getPerson();
            boolean[] subjects = person.getSubjects();
            subjects[position] = !subjects[position];
            if(subjects[position]){
                holder.subject_background.setAlpha(0.5f);
            }
            else {
                holder.subject_background.setAlpha(0.1f);
            }
        });
        holder.subject_image.setImageResource(svmp.getSubjectPictureList().get(position));
        holder.subject_text.setText(svmp.getSubjectList().get(position));
    }

    @Override
    public int getItemCount() {
        return svmp.getSubjectList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout subject_background;
        ImageView subject_image;
        TextView subject_text;

        ViewHolder(View itemView) {
            super(itemView);
            subject_background = itemView.findViewById(R.id.subject_background);
            subject_image = itemView.findViewById(R.id.subject_image);
            subject_text = itemView.findViewById(R.id.subject_text);
//            itemView.setOnClickListener(this);
        }

    }


}
