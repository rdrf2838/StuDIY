package com.example.studiy.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studiy.R;

public class ProfileFragmentChat extends Fragment {
    private ProfileViewModel pvm = ProfileViewModel.getInstance();
    private TextView chat_name;
    private ImageView chat_picture;
    private ImageView chat_heart;

    public ProfileFragmentChat() {
        // Required empty public constructor
    }

    public static ProfileFragmentChat newInstance() {
        ProfileFragmentChat fragment = new ProfileFragmentChat();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_chat, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_chat);
        chat_name = view.findViewById(R.id.chat_name);
        chat_picture = view.findViewById(R.id.chat_picture);
        chat_heart = view.findViewById(R.id.chat_heart);

        chat_picture.setImageResource(Integer.parseInt(pvm.getPersonLiveData().getValue().getImage_uri()));
        chat_name.setText(pvm.getPersonLiveData().getValue().getName());

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ProfileFragmentChatAdapter adapter = new ProfileFragmentChatAdapter();
        recyclerView.setAdapter(adapter);
        return view;
    }
}