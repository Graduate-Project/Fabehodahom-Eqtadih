package com.example.myproject.audio;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.Adapter.RecyclerAudioAdapter;
import com.example.myproject.NetWork.AudioInterface;
import com.example.myproject.NetWork.RetrofitClient;
import com.example.myproject.R;
import com.example.myproject.data.AudioModel;
import com.example.myproject.data.LibraryModel;

import com.example.myproject.library.LibraryFragment;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AudioFragment extends Fragment  {


    View view;

    RecyclerAudioAdapter adapter;
    ArrayList<AudioModel> list=new ArrayList<>();

    RecyclerView recyclerView;
 WebView  youTubePlayerView;
    public AudioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_audio, container, false);
         youTubePlayerView = view.findViewById(R.id.youtube_player_view);
         recyclerView=view.findViewById(R.id.recycler_view_audio_id);
         LinearLayoutManager manager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
         recyclerView.setLayoutManager(manager);
         recyclerView.setHasFixedSize(true );
          retrofit();
          return  view;
        }
//
    ArrayList<AudioModel>  audioModels=new ArrayList<>();
    public void retrofit() {

        AudioInterface interfacr = (AudioInterface) RetrofitClient.getClient().create(AudioInterface.class);
        Call<List<AudioModel>> call = interfacr.getVideos();

        call.enqueue(new Callback<List<AudioModel>>() {
            @Override
            public void onResponse(Call<List<AudioModel>> call, Response<List<AudioModel>> response) {
                list = (ArrayList<AudioModel>) response.body();

                 for (int i = 0; i <list.size()-1 ; i++) {
                     audioModels.add(list.get(i));
                }
                adapter=new RecyclerAudioAdapter(getContext(),audioModels);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<AudioModel>> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}



