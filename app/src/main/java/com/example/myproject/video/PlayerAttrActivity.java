package com.example.myproject.video;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myproject.R;
import com.example.myproject.attribute.AttrAudioFragment;

import android.os.Bundle;


public class PlayerAttrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_attr);
        FragmentManager a=getSupportFragmentManager();
        FragmentTransaction ft=a.beginTransaction();
        ft.add(new AttrAudioFragment(),"player").addToBackStack(null).commit();
    }
}