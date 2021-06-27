package com.example.myproject.character;

import androidx.appcompat.app.AppCompatActivity;

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
    PDFView  pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_of_each_char);
        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("abobakr.pdf").load();


        // url of our PDF file.
      //  String pdfurl = "https://drive.google.com/file/d/18N2qakituL4IR8vl8wbGdO---njnVusd/preview";
            // initializing our pdf view.
//
//            pdfView.loadUrl("https://files.fm/f/hbpwdskpj");
//            new RetrivePDFfromUrl().execute(pdfurl);
        }

//        // create an async task class for loading pdf file from URL.
//        class RetrivePDFfromUrl extends AsyncTask<String, Void, InputStream> {
//            @Override
//            protected InputStream doInBackground(String... strings) {
//                // we are using inputstream
//                // for getting out PDF.
//                InputStream inputStream = null;
//                try {
//                    URL url = new URL(strings[0]);
//                    // below is the step where we are
//                    // creating our connection.
//                    HttpURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
//                    if (urlConnection.getResponseCode() == 200) {
//                        // response is success.
//                        // we are getting input stream from url
//                        // and storing it in our variable.
//                        inputStream = new BufferedInputStream(urlConnection.getInputStream());
//                    }
//
//                } catch (IOException e) {
//                    // this is the method
//                    // to handle errors.
//                    e.printStackTrace();
//                    return null;
//                }
//                return inputStream;
//            }
//
//            @Override
//            protected void onPostExecute(InputStream inputStream) {
//                // after the execution of our async
//                // task we are loading our pdf in our pdf view.
//                pdfView.fromStream(inputStream).load();
//            }
//        }
    }

//
//        pdfView=findViewById(R.id.web);
//        pdfView.getSettings().setJavaScriptEnabled(true);
//        pdfView.loadUrl("https://drive.google.com/file/d/18N2qakituL4IR8vl8wbGdO---njnVusd/preview");

//        ///pdfView.loadUrl("https://www.docdroid.net/0AwVk6S/abo-bkr-alsdyk-rdy-allh-aanh-pdf");
//
//        String url = "https://www.docdroid.net/0AwVk6S/abo-bkr-alsdyk-rdy-allh-aanh-pdf";
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        client.newCall(request).enqueue(new Callback() {
//
//            @Override
//            public void onFailure(okhttp3.Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
////Save this string in your room database
//                SehapaDatabase database=SehapaDatabase.
//                        getInstance(getApplicationContext());
//
//                database.sehapaDao().insertSehapy(new Sehapa(url));
//
//
//
//
//            }
//
//
//
//
//
//
//
//
//
//        });
//        pdfView.loadUrl(url);




















//
//        Retrofit r=new Retrofit.Builder().baseUrl("https://simpleapp-nodejs.herokuapp.com/")
//                .addConverterFactory(GsonConverterFactory.create()).build();
//
//        ApiInterface apiInterface=r.create(ApiInterface.class);
//        Call<CompaionsStory> call=apiInterface.getStory();
//        call.enqueue(new Callback<CompaionsStory>() {
//            @Override
//            public void onResponse(Call<CompaionsStory> call, Response<CompaionsStory> response) {
//                pdfView.loadUrl(response.body().getNarration());
//            }
//
//            @Override
//            public void onFailure(Call<CompaionsStory> call, Throwable t) {
//                Toast.makeText(ContentOfEachChar.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });


