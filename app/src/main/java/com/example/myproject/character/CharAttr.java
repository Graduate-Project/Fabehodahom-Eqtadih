package com.example.myproject.character;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.Adapter.RecyclerAiAdapter;
import com.example.myproject.R;

import java.util.ArrayList;

public class CharAttr extends AppCompatActivity {

    int returnIndex;

    TextView char_text;

    RecyclerView recyclerView;
    ArrayList<String> abobaker, omar, osman, ali, sbair, talha, saad, said, abdrahman, aboobaida;

    RecyclerAiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_attr);

        returnIndex = (this).getIntent().getIntExtra("index1", 1);

        recyclerView = findViewById(R.id.char_list);
        char_text = findViewById(R.id.char_text);

        abobaker = new ArrayList<>();
        abobaker.add("الصدق");
        abobaker.add("الزهد");
        abobaker.add("سهلا");
        abobaker.add("التواضع");
        abobaker.add("البساطة");
        abobaker.add("الحلم");
        abobaker.add("الورع");

        omar = new ArrayList<>();
        omar.add("الزهد");
        omar.add("الورع");
        omar.add("الصدق");
        omar.add("عجبا");
        omar.add("مهيب");
        omar.add("حليف");
        omar.add("الشدة");
        omar.add("العزيمة");
        omar.add("التواضع");

        osman = new ArrayList<>();
        osman.add("الزهد");
        osman.add("الرشد");
        osman.add("أواب");
        osman.add("سهلا");
        osman.add("الحياء");
        osman.add("التواضع");
        osman.add("الورع");

        ali = new ArrayList<>();
        ali.add("الفدائي");
        ali.add("الصدق");
        ali.add("التواضع");
        ali.add("الورع");

        sbair = new ArrayList<>();
        sbair.add("الفداء");
        sbair.add("الرأى");
        sbair.add("الورع");

        talha = new ArrayList<>();
        talha.add("سهلا");
        talha.add("الشدة");
        talha.add("الجود");

        saad = new ArrayList<>();
        saad.add("الصدق");
        saad.add("التواضع");
        saad.add("الزهد");
        saad.add("الورع");
        saad.add("سهلا");
        saad.add("الشدة");
        saad.add("الرشد");

        abdrahman = new ArrayList<>();
        abdrahman.add("الورع");
        abdrahman.add("الزهد");
        abdrahman.add("الجود");

        aboobaida = new ArrayList<>();
        aboobaida.add("التواضع");
        aboobaida.add("الأمانة");
        aboobaida.add("الزهد");

        said = new ArrayList<>();
        said.add("الزهد");
        said.add("الورع");
        said.add("الجود");

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