package com.example.myproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.myproject.R;
import com.example.myproject.pojo.AudioData;

import java.util.ArrayList;

public class SlideShowAdapterAudio extends PagerAdapter {

    private Context context;
    LayoutInflater inflater;

    RecyclerAudioAdapter audioAdapter;

    public int[] audio_series = {
            R.drawable.back,
            R.drawable.splash
    };


    public SlideShowAdapterAudio(Context context) {
        this.context = context;
    }

    public SlideShowAdapterAudio(Context context, RecyclerAudioAdapter audioAdapter) {

        this.context = context;
        this.audioAdapter = audioAdapter;
    }

    @Override
    public int getCount() {

        return audio_series.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return (view == (LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view_audio = inflater.inflate(R.layout.slide_show_audio, container, false);

        ImageView audio_img = view_audio.findViewById(R.id.image_slide_audio_id);

        // use glide library to load image faster
        Glide.with(context).load(audio_series[position]).into(audio_img);

        // arrays for recycle
        ArrayList<AudioData> audios1 = new ArrayList<>();
        audios1.add(new AudioData(R.drawable.back, "مقطع صوتى 1", "بسيط", 20 + "s"));
        audios1.add(new AudioData(R.drawable.back, "مقطع صوتى 2", "بسيط", 50 + "s"));

        ArrayList<AudioData> audios2 = new ArrayList<>();
        audios2.add(new AudioData(R.drawable.splash, "مقطع صوتى 3", "بسيط", 45 + "s"));
        audios2.add(new AudioData(R.drawable.splash, "مقطع صوتى 6", "بسيط", 20 + "s"));

        audio_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        audioAdapter.setData(audios1);
                        break;

                    case 1:
                        audioAdapter.setData(audios2);
                        break;
                }

            }
        });
        container.addView(view_audio);

        return view_audio;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout) object);
    }

}
