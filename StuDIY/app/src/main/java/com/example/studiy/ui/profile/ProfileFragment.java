package com.example.studiy.ui.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studiy.R;
import com.example.studiy.classes.Person;

public class ProfileFragment extends Fragment {
    private ProfileViewModel pvm;
    ImageView profile_image;
    TextView profile_name;
    TextView profile_job;
    TextView profile_title;
    TextView profile_desc;
    ImageButton profile_heart;
    ImageButton profile_chat;

    public ProfileFragment() {
        pvm = ProfileViewModel.getInstance();
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_profile, container, false);
        Log.d("hi", "" + R.id.profile_image);
        profile_image = view.findViewById(R.id.profile_image);
        profile_name = view.findViewById(R.id.profile_name);
        profile_job = view.findViewById(R.id.profile_job);
        profile_title = view.findViewById(R.id.profile_title);
        profile_desc = view.findViewById(R.id.profile_desc);
        profile_heart = view.findViewById(R.id.profile_heart);
        profile_chat = view.findViewById(R.id.profile_chat);
        Person p = pvm.getPersonLiveData().getValue();
        profile_image.setImageResource(Integer.parseInt(p.getImage_uri()));
        profile_name.setText(p.getName());
        profile_job.setText(p.getJobType());
        profile_title.setText("About " + p.getName());
        profile_heart.setSelected(p.isFavourite());
        profile_chat.setOnClickListener((i)->{
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.layout1, ProfileFragmentChat.newInstance());
            fragmentTransaction.addToBackStack("Chat");
            fragmentTransaction.commit();

        });
        profile_desc.setText("Kaguya-sama: Love Is War (Japanese: かぐや様は告らせたい ～天才たちの恋愛頭脳戦～, Hepburn: Kaguya-sama wa Kokurasetai: Tensai-tachi no Ren'ai Zunōsen, transl. \"Kaguya Wants to Make Them Confess: The Geniuses' War of Hearts and Minds\") is a Japanese romantic comedy manga series by Aka Akasaka. It began serialization in Shueisha's seinen manga magazine Miracle Jump in May 2015 and was transferred to Weekly Young Jump in March 2016.\n" +
                "\nA 12-episode anime television series adaptation by A-1 Pictures aired in Japan between January and March 2019, and a 12-episode second season premiered between April and June 2020. An OVA episode will be released in 2021, and a third season has been announced. It was also adapted into a live-action film directed by Hayato Kawai, which was released in Japan in September 2019. In North America, the manga is licensed in English by Viz Media, while the anime series is licensed by Aniplex of America.\n" +
                "\n" +
                "As of November 2020, the manga had over 13 million copies in print. In 2020, Kaguya-sama: Love Is War won the 65th Shogakukan Manga Award in the general category.");
        // Inflate the layout for this fragment
        return view;
    }
}