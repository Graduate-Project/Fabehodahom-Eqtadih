package com.example.myproject.attribute;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.myproject.R;


public class AttributeFragment extends Fragment {

    GridLayout g;

    public AttributeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_attribute, container, false);

        g = v.findViewById(R.id.attribgl);
        gridlistener();

        return v;
    }

    void gridlistener() {

        int childCount = g.getChildCount();

        for (int i = 0; i < childCount; i++) {

            CardView l = (CardView) g.getChildAt(i);

            final int finalI = i;
            l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    Intent a = new Intent(getContext(), ContentOfEachAttr.class);
                    a.putExtra("index", finalI);
                    startActivity(a);

                }

            });
        }
    }
}