package com.example.myproject.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myproject.Adapter.RecyclerLibAdapter;
import com.example.myproject.R;
import com.example.myproject.databinding.FragmentLibraryBinding;
import com.example.myproject.pojo.LibraryData;

import java.util.ArrayList;


public class LibraryFragment extends Fragment {

    FragmentLibraryBinding binding;
    RecyclerLibAdapter adapter;

    public LibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLibraryBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // recycler
        adapter = new RecyclerLibAdapter();

        ArrayList<LibraryData> data = new ArrayList<>();
        data.add(new LibraryData(R.drawable.book_sefatelsafwa, getString(R.string.book_ss)));
        data.add(new LibraryData(R.drawable.book_regal, getString(R.string.book_man_around_massenger)));
        data.add(new LibraryData(R.drawable.book_startend, getString(R.string.book_start_end)));
        data.add(new LibraryData(R.drawable.book_sefatelsafwa, getString(R.string.book_ss)));
        data.add(new LibraryData(R.drawable.book_regal, getString(R.string.book_man_around_massenger)));
        data.add(new LibraryData(R.drawable.book_startend, getString(R.string.book_start_end)));

        adapter.setData(data, new RecyclerLibAdapter.ItemClickListener() {
            @Override
            public void onItemClick(LibraryData data) {

            }
        });
        binding.rvLibrary.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvLibrary.setLayoutManager(layoutManager);
        binding.rvLibrary.setHasFixedSize(true);


        return view;
    }
}