package com.example.myproject.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.myproject.NetWork.AddLifeCycle;
import com.example.myproject.R;
import com.example.myproject.attribute.AttributeFragment;
import com.example.myproject.audio.AudioFragment;
import com.example.myproject.character.CharacterFragment;

import com.example.myproject.databinding.ActivityMainBinding;
import com.example.myproject.home.HomeFragment;
import com.example.myproject.library.LibraryFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class MainActivity extends AppCompatActivity  {

    ActivityMainBinding binding;
    // returnpos
    // int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.bottomNav.setOnNavigationItemSelectedListener(navListener);
//         i=getIntent().getIntExtra("position")

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();
    }

    // listener nav bar
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =  new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_char:
                            selectedFragment = new CharacterFragment();
                            break;
                        case R.id.nav_attr:
                            selectedFragment = new AttributeFragment();
                            break;
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_lib:
                            selectedFragment = new LibraryFragment();
                            break;
                        case R.id.nav_aud:
                            selectedFragment = new AudioFragment();
                            break;
                    }

                    // begin transaction
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();

                    return true;
                }
            };

}