package com.example.myproject.NetWork;
import com.example.myproject.data.LibraryModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LibInterface {
    @GET("allbooks")
    public Observable<List<LibraryModel>> getAllLib();
    @GET("allbooks")
    public Observable<LibraryModel> getinfo();

}
