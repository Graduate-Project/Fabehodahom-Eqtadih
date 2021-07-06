package com.example.myproject.library;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myproject.Adapter.RecyclerLibAdapter;
import com.example.myproject.BookDetailActvity;
import com.example.myproject.NetWork.LibInterface;
import com.example.myproject.NetWork.RetrofitClient;
import com.example.myproject.data.LibraryModel;
import com.example.myproject.databinding.FragmentLibraryBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LibraryFragment extends Fragment {

    FragmentLibraryBinding binding;
    RecyclerLibAdapter adapter;
    int returnIndex;
    ArrayList<LibraryModel> data;

    public LibraryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLibraryBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        returnIndex = getActivity().getIntent().getIntExtra("position", 1);
         //Recycelrview for companions books

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvLibrary.setLayoutManager(layoutManager);
        binding.rvLibrary.setHasFixedSize(true);
        //Recyclerview for mannars books
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvattribueLibrary.setLayoutManager(layoutManager2);
        binding.rvattribueLibrary.setHasFixedSize(true);
        retrofit();

        return view;
    }

    //set up retrofit
    public void retrofit() {



        LibInterface apiInterface = (LibInterface) RetrofitClient.getClient().create(LibInterface.class);
        Call<List<LibraryModel>> call = apiInterface.getAllLib();

        call.enqueue(new Callback<List<LibraryModel>>() {
            @Override
            public void onResponse(Call<List<LibraryModel>> call, Response<List<LibraryModel>> response) {
                    data = (ArrayList<LibraryModel>) response.body();
                        String a=data.get(returnIndex).getBookCategory();
                        if(a=="1"){
                            data.add(new LibraryModel(data.get(returnIndex), data.get(returnIndex).getBookName()));
                            adapter = new RecyclerLibAdapter(getContext(), data);
                            binding.rvLibrary.setAdapter(adapter);
                        }

                        else if (a=="0"){
                        data.add(new LibraryModel(data.get(returnIndex), data.get(returnIndex).getBookName()));
                        adapter = new RecyclerLibAdapter(getContext(), data);
                        binding.rvattribueLibrary.setAdapter(adapter);
                        }





            }

            @Override
            public void onFailure(Call<List<LibraryModel>> call, Throwable t) {
                Toast.makeText(getContext(), "please check Internet", Toast.LENGTH_SHORT).show();

            }
        });

    }
}