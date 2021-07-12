package com.example.myproject.character;


import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myproject.NetWork.CharAttrInterface;
import com.example.myproject.NetWork.CharInterface;
import com.example.myproject.R;
import com.example.myproject.data.CharAttrModel;
import com.example.myproject.data.CompaionsStory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class framgentfoeachchar extends Fragment {

    View v;
    int returnIndex;
    Button btn;
    WebView webView;


    List<CharAttrModel> data;
    ListView listView;
    List<String> list = new ArrayList<>();

    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    Dialog dialog;

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

        listView = v.findViewById(R.id.dialog_list);

        retrofit();

        builder = new AlertDialog.Builder(getContext());
        builder.setView(inflater.inflate(R.layout.attribute_dialog, container, false));
        alertDialog = new AlertDialog.Builder(getActivity(), R.layout.attribute_dialog);

        //  dialog = new Dialog(getActivity());

        CharAttr();
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
                // webView.setText(myheroList.get(returnIndex).getPersonName());
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

    public void AttrRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gradproj.herokuapp.com//")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        CharAttrInterface attrInterface = retrofit.create(CharAttrInterface.class);

        Observable<List<CharAttrModel>> observable = attrInterface.getAttr()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<List<CharAttrModel>> observer = new Observer<List<CharAttrModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<CharAttrModel> charAttrModels) {

                data = charAttrModels;

                for (int i = 0; i < data.get(returnIndex).getSefat().size(); i++) {
                    List<String> l = data.get(i).getSefat();
                    for (int j = 0; j <= i; j++) {
                        list.add(l.get(j));
                        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
                        listView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.d(TAG, "onError", e);
                Toast.makeText(getContext(), "check internet", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
    }

    //this method for text to speech activity
    void CharAttr() {
        btn = v.findViewById(R.id.char_attr);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert();
                AttrRetrofit();
            }
        });
    }

    public void showAlert() {
        if (alertDialog != null && !alertDialog.isShowing()) {
            alertDialog.setMessage(data.get(returnIndex).getSefat().toString());
            alertDialog.show();
        }
    }

}
