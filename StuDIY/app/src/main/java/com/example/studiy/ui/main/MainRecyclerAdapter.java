package com.example.studiy.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studiy.R;
import com.example.studiy.classes.Person;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.RecyclerViewHolder> {
    private MainViewModel mainViewModel;
    private ItemClickListener mClickListener; // A functional interface with a method to handle clicks

    public MainRecyclerAdapter() {
        // Instantiates from MainFragment
        mainViewModel = MainViewModel.getInstance();
    }

    @Override
    public int getItemViewType(final int position) {
        // IDK but important

        return R.layout.main_fragment_persongrid_item;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Returns a single element in recyclerview

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Person person = mainViewModel.getPersonListLiveData().getValue().get(position);
        holder.view_job.setText(person.getJobType());
        holder.view_name.setText(person.getName());
        holder.view_rating.setText(person.getRating());
        if (person.isFavourite()) {
            holder.button_heart.setSelected(true);
        }
        holder.button_heart.setOnClickListener((i) -> {
            person.setFavourite(!person.isFavourite());
            holder.button_heart.setSelected(person.isFavourite());
        });

        // This line will break once Person returns the image URI instead
        holder.view_image.setImageResource(Integer.parseInt(person.getImage_uri()));
    }

    @Override
    public int getItemCount() {
        return mainViewModel.getPersonListLiveData().getValue().size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Represents a single element in recyclerview. Each contains its layout view.
        private ImageButton button_heart;
        private TextView view_name;
        private TextView view_job;
        private TextView view_rating;
        private ImageView view_image;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            view_name = itemView.findViewById(R.id.view_name);
            view_job = itemView.findViewById(R.id.view_job);
            view_rating = itemView.findViewById(R.id.view_rating);
            view_image = itemView.findViewById(R.id.view_image);
            button_heart = itemView.findViewById(R.id.button_heart);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Person getItem(int id) {
        return mainViewModel.getPersonListLiveData().getValue().get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
