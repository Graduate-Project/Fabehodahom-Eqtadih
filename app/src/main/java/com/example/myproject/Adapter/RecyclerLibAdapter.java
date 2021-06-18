package com.example.myproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;
import com.example.myproject.pojo.LibraryData;

import java.util.ArrayList;

public class RecyclerLibAdapter extends RecyclerView.Adapter<RecyclerLibAdapter.RecyclerLibHolder> {

    ArrayList<LibraryData> data;
    private ItemClickListener itemClickListener;

    public RecyclerLibAdapter() {
    }

    public void setData(ArrayList<LibraryData> libraryData, ItemClickListener listener){
        this.data = libraryData;
        this.itemClickListener = listener;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerLibHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.r_library_item, parent,false);

        RecyclerLibHolder holder = new RecyclerLibHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerLibHolder holder, int position) {

        final LibraryData libs = data.get(position);
        holder.lib_name.setText(libs.getLibName());
        holder.lib_img.setImageResource(libs.getLibImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(data.get(position));// this will get position of item in recyclerview

            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface ItemClickListener{
        void onItemClick(LibraryData data);
    }

    class RecyclerLibHolder extends RecyclerView.ViewHolder {

        ImageView lib_img;
        TextView lib_name;

        public RecyclerLibHolder(@NonNull View itemView) {
            super(itemView);

            lib_img = itemView.findViewById(R.id.lib_img);
            lib_name = itemView.findViewById(R.id.lib_name);
        }
    }
}