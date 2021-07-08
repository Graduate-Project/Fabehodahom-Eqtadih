package com.example.myproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;
import com.example.myproject.data.AudioModel;

import java.util.ArrayList;

public class RecyclerAudioAdapter extends RecyclerView.Adapter<RecyclerAudioAdapter.RecyclAudioHolder> {

    Context context;
    ArrayList<AudioModel> data;

    public RecyclerAudioAdapter() {

    }

    public RecyclerAudioAdapter(Context context, ArrayList<AudioModel> data) {
        this.context = context;
        this.data = data;
    }

    public void setData(ArrayList<AudioModel> list) {
        this.data = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclAudioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_audio_item, parent, false);
        RecyclAudioHolder holder = new RecyclAudioHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclAudioHolder holder, int position) {
        final AudioModel audios = data.get(position);
        holder.serieName.setText(audios.getSeriesName());
        holder.instructorName.setText(audios.getInstructorName());
        holder.videoName.setText(audios.getVideoName());
      //  holder.videoDescription.setText(audios.getVideoDescription());
    //    holder.video_view.setVideoPath(audios.getVideoLink());
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    class RecyclAudioHolder extends RecyclerView.ViewHolder {
        TextView serieName;
        VideoView video_view;
        TextView videoName;
        TextView instructorName;
        TextView videoDescription;
        public RecyclAudioHolder(@NonNull View itemView) {
            super(itemView);

            serieName = itemView.findViewById(R.id.serie_name);
            instructorName = itemView.findViewById(R.id.instructorName);
            videoName = itemView.findViewById(R.id.videoName);
        //    videoDescription = itemView.findViewById(R.id.videoDescription);
        //    video_view = itemView.findViewById(R.id.video_view);

        }
    }

}

