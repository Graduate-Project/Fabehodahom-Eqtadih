package com.example.myproject.audio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.Adapter.RecyclerAudioAdapter;
import com.example.myproject.NetWork.AudioInterface;
import com.example.myproject.NetWork.RetrofitClient;
import com.example.myproject.R;
import com.example.myproject.data.AudioModel;
import com.example.myproject.databinding.FragmentAudioBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AudioFragment extends Fragment {

    FragmentAudioBinding binding;
    View view;

    RecyclerAudioAdapter adapter;
    ArrayList<AudioModel> list;

    int returnIndex;
    VideoView videoView;
    RecyclerView recyclerView;


    public AudioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Enabled data binding
        //    binding = FragmentAudioBinding.inflate(inflater, container, false);
        //    view = binding.getRoot();
        view = inflater.inflate(R.layout.fragment_audio, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_audio_id);
        videoView = (VideoView) view.findViewById(R.id.video_view);
        returnIndex = getActivity().getIntent().getIntExtra("position", 1);

//        list = new ArrayList<>();
//        list.add(new AudioModel( "مقطع صوتي لأبي بكر الصديق", "طارق السويدان" ,"سلسلة الصحابة",
//                "https://www.youtube.com/watch?v=z3HouXZUWEA&list=PLW3Dddj9BXB8CAx3i5U9UFuELJDpY21qF&index=1"));
//        list.add(new AudioModel( "مقطع صوتي لأبي بكر الصديق", "طارق السويدان" ,"سلسلة الصحابة",
//                "https://www.youtube.com/watch?v=z3HouXZUWEA&list=PLW3Dddj9BXB8CAx3i5U9UFuELJDpY21qF&index=1"));
//        list.add(new AudioModel( "مقطع صوتي لأبي بكر الصديق", "طارق السويدان" , "سلسلة الصحابة",
//                "https://www.youtube.com/watch?v=z3HouXZUWEA&list=PLW3Dddj9BXB8CAx3i5U9UFuELJDpY21qF&index=1"));
//        list.add(new AudioModel( "مقطع صوتي لأبي بكر الصديق", "طارق السويدان" ,"سلسلة الصحابة",
//                "https://www.youtube.com/watch?v=z3HouXZUWEA&list=PLW3Dddj9BXB8CAx3i5U9UFuELJDpY21qF&index=1"));


        //      videoView.setVideoPath("https://www.youtube.com/watch?v=z3HouXZUWEA&list=PLW3Dddj9BXB8CAx3i5U9UFuELJDpY21qF&index=1");
//        MediaController mediaController = new MediaController(getContext());
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
//
//        adapter = new RecyclerAudioAdapter(getContext(), list);
//        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        retrofit();

        return view;
    }

    public void retrofit() {
        AudioInterface interfacr = (AudioInterface) RetrofitClient.getClient().create(AudioInterface.class);
        Call<List<AudioModel>> call = interfacr.getVideos();

        call.enqueue(new Callback<List<AudioModel>>() {
            @Override
            public void onResponse(Call<List<AudioModel>> call, Response<List<AudioModel>> response) {
                list = (ArrayList<AudioModel>) response.body();

                list.add(new AudioModel(list.get(returnIndex)));
                adapter = new RecyclerAudioAdapter(getContext(), list);
                recyclerView.setAdapter(adapter);
//
//                videoView.setVideoPath(list.get(returnIndex).getVideoLink());
//                MediaController mediaController = new MediaController(getContext());
//                mediaController.setAnchorView(videoView);
//                videoView.setMediaController(mediaController);

            }

            @Override
            public void onFailure(Call<List<AudioModel>> call, Throwable t) {

                Toast.makeText(getContext(), "please check Internet", Toast.LENGTH_SHORT).show();

            }
        });
    }
}