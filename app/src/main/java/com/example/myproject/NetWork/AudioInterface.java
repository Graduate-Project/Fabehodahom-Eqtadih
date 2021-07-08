package com.example.myproject.NetWork;

import com.example.myproject.data.AudioModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AudioInterface {

    @GET("allVideos")
    public Call<List<AudioModel>> getVideos();
}
