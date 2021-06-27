package com.example.myproject.attribute;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;

import com.example.myproject.AttributeActivity;
import com.example.myproject.R;
import com.example.myproject.character.ContentOfEachChar;
import com.example.myproject.databinding.FragmentCharacterBinding;



public class AttributeFragment extends Fragment {
GridLayout g;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AttributeFragment() {
        // Required empty public constructor
    }

    /**
     \
     */
    // TODO: Rename and change types and number of parameters



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_attribute, container, false);
        g=v.findViewById(R.id.attribgl);
          gridlistener();

        return v;
    }
    void gridlistener(){

        int childCount = g.getChildCount();

        for (int i = 0; i < childCount; i++) {

            CardView l = (CardView) g.getChildAt(i);

            final int finalI = i;
            l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Bundle b = new Bundle();

                    Intent a = new Intent(getContext(), AttributeActivity.class);
//                    b.putInt("index", finalI);
//                    a.putExtra("post", b);
                    startActivity(a);

                }

            });
        }}
}