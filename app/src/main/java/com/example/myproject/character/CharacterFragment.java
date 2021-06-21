package com.example.myproject.character;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.myproject.R;
import com.example.myproject.databinding.FragmentCharacterBinding;

public class CharacterFragment extends Fragment {

    FragmentCharacterBinding binding;

    public CharacterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentCharacterBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        gridlistener();

        return view;
    }
    void gridlistener(){

        int childCount = binding.mainGrid.getChildCount();

        for (int i = 0; i < childCount; i++) {

            CardView l =(CardView) binding.mainGrid.getChildAt(i);

            final int finalI = i;
            l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Bundle b = new Bundle();

                    Intent a=new Intent(getContext(), ContentOfEachChar.class);
                    b.putInt("index",finalI);
                    a.putExtra("post",b);
                    startActivity(a);

                }

            });
        }
    }
}