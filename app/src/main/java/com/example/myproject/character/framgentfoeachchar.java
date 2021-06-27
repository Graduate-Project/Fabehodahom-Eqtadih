package com.example.myproject.character;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myproject.R;
import com.example.myproject.audio.playerActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class framgentfoeachchar extends Fragment {

Button btn ;
    public framgentfoeachchar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_framgentfoeachchar, container, false);
        btn=v.findViewById(R.id.attribbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n=new Intent(getActivity(), playerActivity.class);
                startActivity(n);
            }
        });


        return v;



    }

}
