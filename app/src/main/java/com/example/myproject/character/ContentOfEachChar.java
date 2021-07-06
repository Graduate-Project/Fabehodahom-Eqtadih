package com.example.myproject.character;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myproject.R;

public class ContentOfEachChar extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_of_each_char);
        //go to fragment for each char
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, new framgentfoeachchar(), "index1").commit();



    }}