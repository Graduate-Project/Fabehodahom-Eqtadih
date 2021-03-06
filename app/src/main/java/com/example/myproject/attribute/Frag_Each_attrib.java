package com.example.myproject.attribute;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.example.myproject.NetWork.AttrInterface;
import com.example.myproject.R;
import com.example.myproject.data.AttributeModel;
import com.example.myproject.video.PlayerAttrActivity;
import com.github.barteksc.pdfviewer.PDFView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Frag_Each_attrib extends Fragment {


    View v ;
    int returnIntex;
    Button attr_btn, listen_btn;
    WebView webView;

    private static final String TAG = "Frag_Each_attrib";

    public Frag_Each_attrib() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.frag_for_each_attrib, container, false);

        returnIntex = ((ContentOfEachAttr) getActivity()).getIntent().getIntExtra("index", 1);

        webView = v.findViewById(R.id.web_attr);

        attrRetrofit();

        charAttr();

        listen();

        return v;
    }


    public void attrRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://simpleapp-nodejs.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        AttrInterface attrInterface = retrofit.create(AttrInterface.class);
        Observable<List<AttributeModel>> observable = attrInterface.getAttributes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<List<AttributeModel>> observer = new Observer<List<AttributeModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<AttributeModel> attributeModels) {

                List<AttributeModel> list = attributeModels;
                // webView.setText(myheroList.get(returnIndex).getPersonName());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setSaveFormData(true);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(list.get(returnIntex).getSefatDetails());
            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d(TAG, "onError", e);
                Toast.makeText(getContext(), "an Error has eccured", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);

//
//        call.enqueue(new Callback<List<AttributeModel>>() {
//            @Override
//            public void onResponse(Call<List<AttributeModel>> call, Response<List<AttributeModel>> response) {
//                List<AttributeModel> list = response.body();
//                // webView.setText(myheroList.get(returnIndex).getPersonName());
//                webView.getSettings().setJavaScriptEnabled(true);
//                webView.getSettings().setSaveFormData(true);
//                webView.setWebViewClient(new WebViewClient());
//                webView.loadUrl(list.get(returnIntex).getSefatDetails());
//
//            }
//
//            @Override
//            public void onFailure(Call<List<AttributeModel>> call, Throwable t) {
//
//                Log.d(TAG, "onError", t);
//                Toast.makeText(getContext(), "an Error has eccured", Toast.LENGTH_SHORT).show();
//            }
//        });
//
    }

    public void charAttr(){
        attr_btn = v.findViewById(R.id.attr_btn);
        for (int i = 0; i <= returnIntex; i ++){
            final int c = i;
            attr_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent b = new Intent(getActivity(), AttributeChar.class);
                    b.putExtra("index", c);
                    startActivity(b);
                }
            });
        }
    }

    public void listen(){
        listen_btn = v.findViewById(R.id.listen_attr_btn);
        listen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), PlayerAttrActivity.class);
                startActivity(i);
            }
        });
    }
}