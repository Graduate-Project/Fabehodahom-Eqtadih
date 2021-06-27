package com.example.myproject.audio;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.myproject.R;
import com.example.myproject.databinding.FragAudioPlayerBinding;
import com.example.myproject.databinding.FragmentAudioBinding;

import java.util.concurrent.TimeUnit;

public class AudioPlayerFrag extends Fragment {


    FragAudioPlayerBinding binding;
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    Runnable runnable;

    public AudioPlayerFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragAudioPlayerBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // initialize media player
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.abobakr);

        // initialize runnable
        runnable = new Runnable() {
            @Override
            public void run() {
                // set progress on seek bar
                binding.audioPlayerSeekBar.setProgress(mediaPlayer.getCurrentPosition());

                // handler post delay for 0.5 second
                handler.postDelayed(this, 500);
            }
        };

        // get duration of media player
        int duration = mediaPlayer.getDuration();

        // convert millisecond to minute and second
        String sDuration = convertFormat(duration);

        // set duration on text view
        binding.audioPlayerDuration.setText(sDuration);

        binding.audioPlayerPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // hide play button
                binding.audioPlayerPlay.setVisibility(View.GONE);
                // show puase button
                binding.audioPlayerPause.setVisibility(View.VISIBLE);
                // start media player
                mediaPlayer.start();
                // set max on seek bar
                binding.audioPlayerSeekBar.setMax(mediaPlayer.getDuration());
                // start handler
                handler.postDelayed(runnable, 0);
            }
        });

        binding.audioPlayerPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // hide pause button
                binding.audioPlayerPause.setVisibility(View.GONE);
                // show play button
                binding.audioPlayerPlay.setVisibility(View.VISIBLE);
                // pause media player
                mediaPlayer.pause();
                // stop handler
                handler.removeCallbacks(runnable);
            }
        });

        binding.audioPlayerFf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get current position of media player
                int currentPosition = mediaPlayer.getCurrentPosition();
                // get duration of media player
                int duration = mediaPlayer.getDuration();
                // check condition
                if (mediaPlayer.isPlaying() && duration != currentPosition) {
                    // when media is playing and duration is not equal to current position
                    // fast forward for 5 second
                    currentPosition = currentPosition + 5000;
                    // set current position on text view
                    binding.audioPlayerPosition.setText(convertFormat(currentPosition));
                    // set progress on seek bar
                    mediaPlayer.seekTo(currentPosition);
                }
            }
        });

        binding.audioPlayerRew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get current position of media player
                int currentPosition = mediaPlayer.getCurrentPosition();
                // check condition
                if (mediaPlayer.isPlaying() && currentPosition > 5000) {
                    // when media is playing and current position in greater than 5 seconds
                    // rewind for 5 seconds
                    currentPosition = currentPosition - 5000;
                    // get current position on text view
                    binding.audioPlayerPosition.setText(convertFormat(currentPosition));
                    // set progress on seek bar
                    mediaPlayer.seekTo(currentPosition);
                }
            }
        });

        binding.audioPlayerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // check condition
                if (b) {
                    // when drag the seek bar
                    // set progress on seek bar
                    mediaPlayer.seekTo(i);
                }
                // set current position on text view
                binding.audioPlayerPosition.setText(convertFormat(mediaPlayer.getCurrentPosition()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                // hide pause button
                binding.audioPlayerPause.setVisibility(View.GONE);
                // show play button
                binding.audioPlayerPlay.setVisibility(View.VISIBLE);
                // set media player to initial position
                mediaPlayer.seekTo(0);
            }
        });

        return view;
    }

    private String convertFormat(int duration) {
        return String.format("%02d:%02d"
                , TimeUnit.MILLISECONDS.toMinutes(duration)
                , TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }
}