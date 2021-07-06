package com.example.myproject.NetWork;
import com.example.myproject.data.LibraryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LibInterface {
    @GET("allbooks")
    public Call<List<LibraryModel>> getAllLib();
    @GET("allbooks")
    public Call<LibraryModel> getinfo();

}
