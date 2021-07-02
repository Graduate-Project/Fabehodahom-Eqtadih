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

import com.example.myproject.NetWork.ApiInterface;
import com.example.myproject.R;
import com.example.myproject.audio.PlayerActivity;
import com.example.myproject.data.CompaionsStory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
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
        //  Toast.makeText(getContext(), "index"+c, Toast.LENGTH_SHORT).show();


        btnaudio();
        retrofit();
        return v;


    }

    public void retrofit() {
        Retrofit r = new Retrofit.Builder()
                .baseUrl("https://simpleapp-nodejs.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = r.create(ApiInterface.class);
        Call<List<CompaionsStory>> call = apiInterface.getStory();
        call.enqueue(new Callback<List<CompaionsStory>>() {

            @Override
            public void onResponse(Call<List<CompaionsStory>> call, Response<List<CompaionsStory>> response) {
                List<CompaionsStory> myheroList = response.body();
                // webView.setText(myheroList.get(returnIndex).getPersonName());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setSaveFormData(true);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(myheroList.get(returnIndex).getNarration());

            }

            @Override
            public void onFailure(Call<List<CompaionsStory>> call, Throwable t) {

                Log.d(TAG, "onError", t);
                Toast.makeText(getContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });
    }

    //this method for text to speech activity
    void btnaudio() {
        btn = v.findViewById(R.id.attribbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(getActivity(), PlayerActivity.class);
                startActivity(n);
            }
        });
    }

}
