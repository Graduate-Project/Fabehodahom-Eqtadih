package com.example.myproject.character;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.Adapter.RecyclerAiAdapter;
import com.example.myproject.R;

import java.util.ArrayList;

public class PlacesExetract extends AppCompatActivity {

    int returnIndex;

    TextView char_text;

    RecyclerView recyclerView;
    ArrayList<String> abobaker, omar, osman, ali, sbair, talha, saad, said, abdrahman, aboobaida;

    RecyclerAiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_exetract);


        returnIndex = (this).getIntent().getIntExtra("index2", 1);

        recyclerView = findViewById(R.id.place_list);
        char_text = findViewById(R.id.place_text);


        abobaker = new ArrayList<>();
        abobaker.add("مكة");
        abobaker.add("اليمن");
        abobaker.add("العراق");
        abobaker.add("الروم");
        abobaker.add("دجلة");
        abobaker.add("دمشق");
        abobaker.add("الفرات");
        abobaker.add("المغرب");
        abobaker.add("الصدر");
        abobaker.add("البحرين");

        omar = new ArrayList<>();
        omar.add("مكة");
        omar.add("مصر");
        omar.add("العراق");
        omar.add("الشام");
        omar.add("الروم");
        omar.add("دمشق");
        omar.add("المغرب");
        omar.add("البحرين");
        omar.add("الديتور");
        omar.add("عنوة");
        omar.add("الدار");
        omar.add("بحر");
        omar.add("تكريت");
        omar.add("الرباط");
        omar.add("برقة");
        omar.add("طرابلس");
        omar.add("القادسية");
        omar.add("جدة");
        omar.add("همذان");
        omar.add("الكوفة");
        omar.add("البصرة");

        osman = new ArrayList<>();
        osman.add("مكة");
        osman.add("مصر");
        osman.add("الشام");
        osman.add("الروم");
        osman.add("دمشق");
        osman.add("الكوقة");
        osman.add("البصرة");
        osman.add("قبرص");
        osman.add("خرسان");
        osman.add("الحبشة");

        ali = new ArrayList<>();
        ali.add("مكة");
        ali.add("العراق");
        ali.add("الشام");
        ali.add("دمشق");
        ali.add("الصدر");
        ali.add("الكوفة");
        ali.add("تبوك");

        sbair = new ArrayList<>();
        sbair.add("مكة");
        sbair.add("مصر");
        sbair.add("العراق");
        sbair.add("الشام");
        sbair.add("الروم");
        sbair.add("الحبشة");

        talha = new ArrayList<>();
        talha.add("مكة");
        talha.add("الشام");
        talha.add("الصدر");
        talha.add("البصرة");
        talha.add("حضرموت");

        saad = new ArrayList<>();
        saad.add("مكة");
        saad.add("العراق");
        saad.add("دجلة");
        saad.add("الفرات");
        saad.add("القادسية");
        saad.add("الكوفة");
        saad.add("الحجاز");
        saad.add("رام");
        saad.add("الضفة");

        abdrahman = new ArrayList<>();
        abdrahman.add("جدة");
        abdrahman.add("الحبشة");
        abdrahman.add("تبوك");

        aboobaida = new ArrayList<>();
        aboobaida.add("الشام");
        aboobaida.add("الروم");
        aboobaida.add("الفرات");
        aboobaida.add("جدة");
        aboobaida.add("الأردن");
        aboobaida.add("الحبشة");
        aboobaida.add("العامل");
        aboobaida.add("بيسان");

        said = new ArrayList<>();
        said.add("مكة");
        said.add("الشام");
        said.add("الروم");
        said.add("دمشق");
        said.add("الكوفة");
        said.add("خزاعة");

        switch (returnIndex) {
            case 0:
                char_text.setText(getString(R.string.char_abobakr));
                adapter = new RecyclerAiAdapter(this, abobaker);
                recyclerView.setAdapter(adapter);
                break;
            case 1:
                char_text.setText(getString(R.string.char_omar));
                adapter = new RecyclerAiAdapter(this, omar);
                recyclerView.setAdapter(adapter);
                break;
            case 2:
                char_text.setText(getString(R.string.char_osman));
                adapter = new RecyclerAiAdapter(this, osman);
                recyclerView.setAdapter(adapter);
                break;
            case 3:
                char_text.setText(getString(R.string.char_ali));
                adapter = new RecyclerAiAdapter(this, ali);
                recyclerView.setAdapter(adapter);
                break;
            case 4:
                char_text.setText(getString(R.string.char_sbair));
                adapter = new RecyclerAiAdapter(this, sbair);
                recyclerView.setAdapter(adapter);
                break;
            case 5:
                char_text.setText(getString(R.string.char_talha));
                adapter = new RecyclerAiAdapter(this, talha);
                recyclerView.setAdapter(adapter);
                break;
            case 6:
                char_text.setText(getString(R.string.char_saad));
                adapter = new RecyclerAiAdapter(this, saad);
                recyclerView.setAdapter(adapter);
                break;
            case 7:
                char_text.setText(getString(R.string.char_abdrahman));
                adapter = new RecyclerAiAdapter(this, abdrahman);
                recyclerView.setAdapter(adapter);
                break;
            case 8:
                char_text.setText(getString(R.string.char_aboobida));
                adapter = new RecyclerAiAdapter(this, aboobaida);
                recyclerView.setAdapter(adapter);
                break;
            case 9:
                char_text.setText(getString(R.string.char_said));
                adapter = new RecyclerAiAdapter(this, said);
                recyclerView.setAdapter(adapter);
                break;
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }
}