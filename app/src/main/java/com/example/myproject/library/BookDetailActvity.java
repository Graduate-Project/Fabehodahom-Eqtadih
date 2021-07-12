package com.example.myproject.library;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myproject.R;

public class BookDetailActvity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail_actvity);
        FragmentManager a = getSupportFragmentManager();
        FragmentTransaction ft = a.beginTransaction();
        ft.add(new DetailsOFBooks(), "library").addToBackStack(null).commit();

//        FragmentManager fm=getSupportFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction().add(new DetailsOFBooks(),"detailfragment");
//        ft.addToBackStack(null);
//        ft.commit();

//
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.lib_fragment, new DetailsOFBooks(), "detailfragment").commit();
    }
}