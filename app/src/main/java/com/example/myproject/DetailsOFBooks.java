package com.example.myproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.module.LibraryGlideModule;
import com.example.myproject.Adapter.RecyclerLibAdapter;
import com.example.myproject.NetWork.LibInterface;
import com.example.myproject.NetWork.RetrofitClient;
import com.example.myproject.data.CompaionsStory;
import com.example.myproject.data.LibraryModel;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailsOFBooks extends Fragment {
    int returnposition;
    ImageView book_image;
    TextView auther_book;
    TextView book_nam;
    TextView book_descrition;
    TextView go_to_link;
    View v;

    public DetailsOFBooks() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        returnposition = getActivity().getIntent().getIntExtra("position", 1);
        v = inflater.inflate(R.layout.fragment_details_o_f_books, container, false);
        //findView by IDs
        book_image = v.findViewById(R.id.book_img);
        auther_book = v.findViewById(R.id.book_author);
        book_nam = v.findViewById(R.id.book_name);
        book_descrition = v.findViewById(R.id.book_disc);
        go_to_link = v.findViewById(R.id.back_lib);

        //Responce of API
        retrofit();


        return v;
    }

//    public void initFvs(View v) {
//        this.v = v;
//
//
//    }

    public void retrofit() {
        try {


            LibInterface libInterface = (LibInterface) RetrofitClient.getClient().create(LibInterface.class);
            libInterface.getAllLib().enqueue(new Callback<List<LibraryModel>>() {
                @Override
                public void onResponse(Call<List<LibraryModel>> call, Response<List<LibraryModel>> response) {
                    List<LibraryModel> list=response.body();
                    Picasso.get().load(list.get(returnposition).getCoverPic()).into(book_image);
                    auther_book.setText(list.get(returnposition).getAuthor());
                    book_nam.setText(list.get(returnposition).getBookName());
                    book_descrition.setText(list.get(returnposition).getBookDiscription());
                    go_to_link.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String url = list.get(returnposition).getBookLink();
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(url));
                            startActivity(i);
                        }
                    });
                }

                @Override
                public void onFailure(Call<List<LibraryModel>> call, Throwable t) {
                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}