package com.example.studiy.ui.profile;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.studiy.R;

import java.util.List;

public class ProfileFragmentChatAdapter extends RecyclerView.Adapter {
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 0;

    // TODO: implement messages properly
    @SuppressLint("NewApi")
    private List<String> mMessageList = List.of(
            "hello Andrew, this is Mdm Sun, my son needs help with his O Level Math, can you help him?",
            "Hi Mdm Sun, I’m happy to help! Do you want to conduct a trial lesson first for 50% off?",
            "that sounds good! When are you free?",
            "Hi Mdm Sun, I’m free most afternoons from 3-6pm, what about your son?");
    private boolean[] isSender = new boolean[]{ true, false, true, false};
    private String[] time = new String[]{"10:13","10:14","10:14","10:15"};
    ProfileFragmentChatAdapter() {

    }

    @Override
    public int getItemViewType(int position) {
        return isSender[position] ? VIEW_TYPE_MESSAGE_SENT : VIEW_TYPE_MESSAGE_RECEIVED;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder;
        switch(viewType){
            case VIEW_TYPE_MESSAGE_SENT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_fragment_chat_item_sender, parent, false);
                holder = new SenderViewHolder(view);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_fragment_chat_item_receiver, parent, false);
                holder = new RecepientViewHolder(view);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch(holder.getItemViewType()){
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((RecepientViewHolder) holder).receiver_message.setText(mMessageList.get(position));
                ((RecepientViewHolder) holder).receiver_time.setText(time[position]);
                break;
            case VIEW_TYPE_MESSAGE_SENT:
                ((SenderViewHolder) holder).sender_message.setText(mMessageList.get(position));
                ((SenderViewHolder) holder).sender_time.setText(time[position]);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    public class SenderViewHolder extends RecyclerView.ViewHolder {
        TextView sender_message;
        TextView sender_time;
        SenderViewHolder(View itemView) {
            super(itemView);
            sender_message = itemView.findViewById(R.id.sender_message);
            sender_time = itemView.findViewById(R.id.sender_time);
        }

    }

    public class RecepientViewHolder extends RecyclerView.ViewHolder {
        TextView receiver_message;
        TextView receiver_time;
        RecepientViewHolder(View itemView) {
            super(itemView);
            receiver_message = itemView.findViewById(R.id.receiver_message);
            receiver_time = itemView.findViewById(R.id.receiver_time);
        }

    }


}
