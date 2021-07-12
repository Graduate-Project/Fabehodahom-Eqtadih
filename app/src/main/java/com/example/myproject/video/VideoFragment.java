package com.example.myproject.video;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.Adapter.RecyclerAudioAdapter;
import com.example.myproject.NetWork.AudioInterface;
import com.example.myproject.NetWork.RetrofitClient;
import com.example.myproject.R;
import com.example.myproject.data.VideoModel;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.myproject.Adapter.RecyclerAudioAdapter.audios;


public class VideoFragment extends Fragment  {


    View view;

    RecyclerAudioAdapter adapter;

    RecyclerView recyclerView;

    public VideoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_audio, container, false);
         recyclerView=view.findViewById(R.id.recycler_view_audio_id);
         LinearLayoutManager manager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
         recyclerView.setLayoutManager(manager);
         recyclerView.setHasFixedSize(true );
          retrofit();
          return  view;
        }
//

    ArrayList<VideoModel> responsearray=new ArrayList<>();
    public void retrofit() {

        AudioInterface interfacr = (AudioInterface) RetrofitClient.getClient().create(AudioInterface.class);
        Call<List<VideoModel>> call = interfacr.getVideos();

        call.enqueue(new Callback<List<VideoModel>>() {
            @Override
            public void onResponse(Call<List<VideoModel>> call, Response<List<VideoModel>> response) {
                responsearray=(ArrayList<VideoModel>)response.body();

                  adapter=new RecyclerAudioAdapter(getContext(),responsearray);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<VideoModel>> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}



