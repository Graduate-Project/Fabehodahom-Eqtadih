package com.example.myproject.NetWork;

import com.example.myproject.data.AttributeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AttrInterface {

    @GET("allSefat")
    public Call<List<AttributeModel>> getAttributes();
}
