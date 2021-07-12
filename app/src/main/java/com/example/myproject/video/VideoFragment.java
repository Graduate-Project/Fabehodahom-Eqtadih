package com.example.myproject.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.Adapter.RecyclerAudioAdapter;
import com.example.myproject.NetWork.AudioInterface;
import com.example.myproject.NetWork.RetrofitClient;
import com.example.myproject.R;
import com.example.myproject.data.VideoModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class VideoFragment extends Fragment {


    View view;

    RecyclerAudioAdapter adapter;

    RecyclerView recyclerView;

    private static final String TAG = "VideoFragment";

    public VideoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_audio, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_audio_id);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        retrofit();

        return view;
    }
//

    ArrayList<VideoModel> responsearray = new ArrayList<>();

    public void retrofit() {

        AudioInterface interfacr = (AudioInterface) RetrofitClient.getClient().create(AudioInterface.class);
        Observable<List<VideoModel>> observable = interfacr.getVideos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<List<VideoModel>> observer = new Observer<List<VideoModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<VideoModel> videoModels) {

                responsearray = (ArrayList<VideoModel>) videoModels;
                adapter = new RecyclerAudioAdapter(getContext(), responsearray);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(@NonNull Throwable e) {

                Toast.makeText(getContext(), e.getMessage(),Toast.LENGTH_SHORT ).show();

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);

//       call.enqueue(new Callback<List<VideoModel>>() {
//            @Override
//            public void onResponse(Call<List<VideoModel>> call, Response<List<VideoModel>> response) {
//                responsearray=(ArrayList<VideoModel>)response.body();
//
//                  adapter=new RecyclerAudioAdapter(getContext(),responsearray);
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<VideoModel>> call, Throwable t) {
//
//                Log.d(TAG, "onError", t);
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
}



