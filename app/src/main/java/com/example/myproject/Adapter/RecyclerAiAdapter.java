package com.example.myproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;

import java.util.ArrayList;

public class RecyclerAiAdapter extends RecyclerView.Adapter<RecyclerAiAdapter.RecyclerAttrHolder> {

    Context context;
    ArrayList<String> list;
    String s;

    public RecyclerAiAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerAttrHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attr_item, parent, false);
        RecyclerAttrHolder holder = new RecyclerAttrHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerAttrHolder holder, int position) {

        s = list.get(position);
        holder.attr_char.setText(s);
    }

     @Override
    public int getItemCount() {
        return list.size();
    }

    class RecyclerAttrHolder extends RecyclerView.ViewHolder{

        TextView attr_char;

        public RecyclerAttrHolder(@NonNull View itemView) {
            super(itemView);

            attr_char = itemView.findViewById(R.id.attr_char_text);
        }
    }

}
