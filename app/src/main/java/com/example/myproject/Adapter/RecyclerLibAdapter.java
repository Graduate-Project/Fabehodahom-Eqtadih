package com.example.myproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.BookDetailActvity;
import com.example.myproject.R;
import com.example.myproject.data.LibraryModel;
import com.example.myproject.ui.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerLibAdapter extends RecyclerView.Adapter<RecyclerLibAdapter.RecyclerLibHolder> {
    Context m;
    ArrayList<LibraryModel> data;
    private ItemClickListener itemClickListener;

    public RecyclerLibAdapter(Context Context, ArrayList<LibraryModel> arrayList) {
        this.m= Context;
        this.data=arrayList;

    }

    public void setData(ArrayList<LibraryModel> libraryModels, ItemClickListener listener){
        this.data = libraryModels;
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

        final LibraryModel libs = data.get(position);
        holder.lib_name.setText(libs.getBookName());
                Picasso.get()
                .load(libs.getCoverPic())
                .into(holder.lib_img);
        int index= holder.getAdapterPosition();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent n=new Intent(view.getContext(), BookDetailActvity.class);
                   n.putExtra("position",index);
                    m.startActivity(n);






            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size()-1;
    }



    public interface ItemClickListener{
        void onItemClick(LibraryModel data);
    }

   static class RecyclerLibHolder extends RecyclerView.ViewHolder {

       public ImageView lib_img;
       public TextView lib_name;

        public RecyclerLibHolder(@NonNull View itemView) {
            super(itemView);

            lib_img = itemView.findViewById(R.id.lib_img);
            lib_name = itemView.findViewById(R.id.lib_name);
        }
    }

}