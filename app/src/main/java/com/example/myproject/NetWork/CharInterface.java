package com.example.myproject.NetWork;

import com.example.myproject.data.CompaionsStory;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

 public  interface CharInterface {
    @GET("allsahaba")
    public Observable<List<CompaionsStory>> getStory();
}
