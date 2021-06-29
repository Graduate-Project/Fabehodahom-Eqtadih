package com.example.myproject.character;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.myproject.NetWork.ApiInterface;
import com.example.myproject.R;
import com.example.myproject.data.CompaionsStory;
import com.example.myproject.room.Sehapa;
import com.example.myproject.room.SehapaDatabase;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContentOfEachChar extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_of_each_char);
        //go to fragment for each char
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, new framgentfoeachchar(), "index1").commit();






    }}