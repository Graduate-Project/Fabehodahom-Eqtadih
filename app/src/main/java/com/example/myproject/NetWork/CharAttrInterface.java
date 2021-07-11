package com.example.myproject.NetWork;

import com.example.myproject.data.CharAttrModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CharAttrInterface {

    @GET("extractAllSefat")
    public Observable<List<CharAttrModel>> getAttr();
}
