package com.example.myproject.character;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myproject.NetWork.CharInterface;
import com.example.myproject.R;
import com.example.myproject.data.CompaionsStory;
import com.example.myproject.video.PlayerActivity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class framgentfoeachchar extends Fragment {

    View v;
    int returnIndex;
    Button btn;
    WebView webView;




    private static final String TAG = "framgentfoeachchar";

    public framgentfoeachchar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_framgentfoeachchar, container, false);
        returnIndex = ((ContentOfEachChar) getActivity()).getIntent().getIntExtra("index", 1);
        webView = v.findViewById(R.id.web);
        btn=v.findViewById(R.id.charbtn);

        retrofit();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), PlayerActivity.class));
            }
        });

        return v;


    }

    public void retrofit() {
        Retrofit r = new Retrofit.Builder()
                .baseUrl("https://simpleapp-nodejs.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        CharInterface apiInterface = r.create(CharInterface.class);

        Observable<List<CompaionsStory>> observable = apiInterface.getStory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<List<CompaionsStory>> observer = new Observer<List<CompaionsStory>>() {
            @Override
            public void onSubscribe(io.reactivex.disposables.Disposable d) {

            }

            @Override
            public void onNext(List<CompaionsStory> value) {

                List<CompaionsStory> myheroList = value;
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setSaveFormData(true);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(myheroList.get(returnIndex).getNarration());
            }

            @Override
            public void onError(Throwable e) {

                Log.d(TAG, "onError", e);
                Toast.makeText(getContext(), "check your internet", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);

    }





}
