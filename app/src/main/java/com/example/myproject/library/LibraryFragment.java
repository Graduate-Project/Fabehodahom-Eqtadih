package com.example.myproject.library;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myproject.Adapter.RecyclerLibAdapter;
import com.example.myproject.NetWork.LibInterface;
import com.example.myproject.NetWork.RetrofitClient;
import com.example.myproject.data.LibraryModel;
import com.example.myproject.databinding.FragmentLibraryBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;


public class LibraryFragment extends Fragment {

    FragmentLibraryBinding binding;
    RecyclerLibAdapter adapter;
    RecyclerLibAdapter adapter2;


    public static ArrayList<LibraryModel> data;
    ArrayList<LibraryModel> sefat;
    ArrayList<LibraryModel> charcter;


    public LibraryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLibraryBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        sefat = new ArrayList<>();
        charcter = new ArrayList<>();
         binding.pr.setVisibility(View.VISIBLE);
        //Recycelrview for companions books
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvLibrary.setLayoutManager(layoutManager);
        binding.rvLibrary.setHasFixedSize(true);
        //Recyclerview for attribute books

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvattribueLibrary.setLayoutManager(layoutManager2);
        binding.rvattribueLibrary.setHasFixedSize(true);
        retrofit();

        return view;
    }

    //set up retrofit
    public void retrofit() {


        LibInterface apiInterface = (LibInterface) RetrofitClient.getClient().create(LibInterface.class);
        Observable<List<LibraryModel>> observable = apiInterface.getAllLib()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<List<LibraryModel>> observer = new Observer<List<LibraryModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<LibraryModel> libraryModels) {

                data = (ArrayList<LibraryModel>) libraryModels;

                for (int i = 0; i < data.size(); i++) {

                    String a = data.get(i).getBookCategory();

                    if ((a.equals("0"))) {

                        sefat.add(data.get(i));

                    } else {
                        if ((a.equals("1")))

                            charcter.add(data.get(i));

                    }
                }
                binding.pr.setVisibility(View.GONE);
                adapter = new RecyclerLibAdapter(getContext(), charcter);
                binding.rvattribueLibrary.setAdapter(adapter);
                adapter2 = new RecyclerLibAdapter(getContext(), sefat);
                binding.rvLibrary.setAdapter(adapter2);
            }

            @Override
            public void onError(@NonNull Throwable e) {

                Toast.makeText(getContext(), "please check Internet", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);
//
//        call.enqueue(new Callback<List<LibraryModel>>() {
//            @Override
//            public void onResponse(Call<List<LibraryModel>> call, Response<List<LibraryModel>> response) {
//
//                data = (ArrayList<LibraryModel>) response.body();
//
//                for (int i = 0; i < data.size(); i++) {
//
//                    String a = data.get(i).getBookCategory();
//
//                    if ((a.equals("0"))) {
//
//                        sefat.add(data.get(i));
//
//                    } else {
//                        if ((a.equals("1")))
//
//                            charcter.add(data.get(i));
//
//                    }
//                }
//                binding.pr.setVisibility(View.GONE);
//                adapter = new RecyclerLibAdapter(getContext(), charcter);
//                binding.rvattribueLibrary.setAdapter(adapter);
//                adapter2 = new RecyclerLibAdapter(getContext(), sefat);
//                binding.rvLibrary.setAdapter(adapter2);

//            }
//
//            @Override
//            public void onFailure(Call<List<LibraryModel>> call, Throwable t) {
//                Toast.makeText(getContext(), "please check Internet", Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }
}