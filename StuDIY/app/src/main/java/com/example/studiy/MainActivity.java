package com.example.studiy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.example.studiy.ui.main.MainFragment;
import com.example.studiy.ui.main.MainViewModel;
import com.example.studiy.ui.profile.ProfileFragmentChat;
import com.example.studiy.ui.profile.ProfileViewModel;
import com.example.studiy.R;

public class MainActivity extends AppCompatActivity {
    MainViewModel mvm;
    ProfileViewModel pvm;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar); // calls onCreateOptionMenu(myToolbar)

        // As long as this activity is around these 2 viewmodels will stay in memory.
        mvm = new ViewModelProvider(this).get(MainViewModel.class);
        pvm = new ViewModelProvider(this).get(ProfileViewModel.class);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.layout1, MainFragment.newInstance());
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        // note: you can also use 'getSupportFragmentManager()'
        FragmentManager mgr = getSupportFragmentManager();
        if (mgr.getBackStackEntryCount() == 0) {
            // No backstack to pop, so calling super
            super.onBackPressed();
        } else {
            mgr.popBackStack();
        }
    }

    public void onChatPressed(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout1, ProfileFragmentChat.newInstance());
        fragmentTransaction.addToBackStack("Chat");
        fragmentTransaction.commit();
    }

}