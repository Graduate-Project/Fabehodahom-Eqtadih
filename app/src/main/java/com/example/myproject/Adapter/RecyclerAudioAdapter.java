package com.example.myproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;
import com.example.myproject.pojo.AudioData;

import java.util.ArrayList;

public class RecyclerAudioAdapter extends RecyclerView.Adapter<RecyclerAudioAdapter.RecyclAudioHolder> {

    ArrayList<AudioData> data;

    public RecyclerAudioAdapter() {

    }

    public void setData(ArrayList<AudioData> list){
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

        final AudioData audios = data.get(position);
        holder.audioName.setText(audios.getAudioName());
        holder.audioDes.setText(audios.getAudioDescription());
        holder.audioPeriod.setText(audios.getPeriod() + "");
        holder.audioImage.setImageResource(audios.getAudioImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class RecyclAudioHolder extends RecyclerView.ViewHolder{

        TextView audioName;
        TextView audioDes;
        TextView audioPeriod;
        ImageView audioImage;

        public RecyclAudioHolder(@NonNull View itemView) {
            super(itemView);

            audioName = itemView.findViewById(R.id.audio_name);
            audioDes = itemView.findViewById(R.id.audio_char);
            audioPeriod = itemView.findViewById(R.id.audio_period);
            audioImage = itemView.findViewById(R.id.audo_image);
        }
    }

}

