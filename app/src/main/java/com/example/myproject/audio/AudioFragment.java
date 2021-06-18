package com.example.myproject.audio;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myproject.Adapter.RecyclerAudioAdapter;
import com.example.myproject.Adapter.SlideShowAdapterAudio;
import com.example.myproject.R;
import com.example.myproject.pojo.AudioData;
import com.example.myproject.databinding.FragmentAudioBinding;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class AudioFragment extends Fragment {

    private FragmentAudioBinding binding;
    SlideShowAdapterAudio adapter;
    Handler handler;
    Runnable runnable;
    Timer timer;
    RecyclerAudioAdapter audioAdapter;

    public AudioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Enabled view binding
        binding = FragmentAudioBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        // enabled adapter
        audioAdapter = new RecyclerAudioAdapter();
        adapter = new SlideShowAdapterAudio(getContext(), audioAdapter);
        binding.viewPagerAudioSeries.setAdapter(adapter);

        // enable circle indicator
        binding.circleIndicatorAudioSeries.setViewPager(binding.viewPagerAudioSeries);

        // add timer to imageSlide
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                // run Audio Series
                int i = binding.viewPagerAudioSeries.getCurrentItem();

                if (i == adapter.audio_series.length - 1) {

                    i = 0;
                    binding.viewPagerAudioSeries.setCurrentItem(i, true);

                } else {

                    i++;
                    binding.viewPagerAudioSeries.setCurrentItem(i, true);
                }
            }
        };

        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 5000, 5000);

        // arrays for recycle
        ArrayList<AudioData> audios = new ArrayList<>();
        audios.add(new AudioData(R.drawable.logo, "مقطع صوتى 3", "بسيط", 45 + "s"));


        // enable recycle
        audioAdapter.setData(audios);
        binding.recyclerViewAudioId.setAdapter(audioAdapter);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext());
        binding.recyclerViewAudioId.setHasFixedSize(true);
        binding.recyclerViewAudioId.setLayoutManager(lm);

        return view;
    }
}