package com.example.myproject.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myproject.R;
import com.example.myproject.video.PlayerActivity;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        TextView textView = view.findViewById(R.id.h);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), PlayerActivity.class);
                startActivity(i);

//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                // Replace whatever is in the fragment_container view with this fragment,
//                // and add the transaction to the back stack
//                transaction.replace(R.id.fragment_container, new AudioPlayerFrag());
//                transaction.addToBackStack(null);
//                // Commit the transaction
//                transaction.commit();
            }
        });
        return view;
    }
}