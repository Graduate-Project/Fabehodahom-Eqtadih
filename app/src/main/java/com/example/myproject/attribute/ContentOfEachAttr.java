package com.example.myproject.attribute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myproject.R;

public class ContentOfEachAttr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_of_each_attr);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_attr, new Frag_Each_attrib(), "index1").commit();
    }
}