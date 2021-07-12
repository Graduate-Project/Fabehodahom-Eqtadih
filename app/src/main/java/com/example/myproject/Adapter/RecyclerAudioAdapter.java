package com.example.myproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;
import com.example.myproject.data.VideoModel;
import com.example.myproject.ui.MainActivity;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class RecyclerAudioAdapter extends RecyclerView.Adapter<RecyclerAudioAdapter.RecyclAudioHolder>  {

    Context context;
    ArrayList<VideoModel> data;
    public static VideoModel audios;

    public RecyclerAudioAdapter(Context context, ArrayList<VideoModel> data) {
        this.context = context;
        this.data = data;
    }
    public void setData(ArrayList<VideoModel> list) {
        this.data=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public  RecyclAudioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_audio_item, parent, false);
        RecyclAudioHolder holder = new RecyclAudioHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclAudioHolder holder, int position) {


        audios = data.get(position);
        holder.serieName.setText(audios.getSeriesName());
//        holder.videoName.setText(audios.getVideoName());
      //  holder.instructorName.setText(audios.getInstructorName());


        holder.videoView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {

            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String url = audios.getVideoLink();
                String[] n=url.split("=");
                youTubePlayer.loadVideo(n[1], 0);




            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class RecyclAudioHolder extends RecyclerView.ViewHolder {
        TextView serieName;
       static YouTubePlayerView videoView;
        TextView videoName;
       // TextView instructorName;

        public RecyclAudioHolder(@NonNull View itemView) {
            super(itemView);

            serieName = itemView.findViewById(R.id.serie_name);
          //  instructorName = itemView.findViewById(R.id.instructorName);
         //   videoName = itemView.findViewById(R.id.videoName);
            videoView = itemView.findViewById(R.id.youtube_player_view);
        }
    }

}


