package com.example.myproject.video;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.myproject.R;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        FragmentManager a=getSupportFragmentManager();
        FragmentTransaction ft=a.beginTransaction();
        ft.add(new VideoPlayerFrag(),"player").addToBackStack(null).commit();
    }
}