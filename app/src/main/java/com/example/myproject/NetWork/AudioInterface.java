package com.example.myproject.NetWork;

import com.example.myproject.data.VideoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AudioInterface {

    @GET("allVideos")
    public Call<List<VideoModel>> getVideos();
}
