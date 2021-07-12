package com.example.myproject.attribute;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.Adapter.RecyclerAiAdapter;
import com.example.myproject.R;

import java.util.ArrayList;

public class AttributeChar extends AppCompatActivity {

    int returnIndex;

    TextView attr_tv;

    RecyclerView recyclerView;
    ArrayList<String> amana, sedq, twad3, zuhd, wara3, haya;

    RecyclerAiAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute_char);

        returnIndex = ( this).getIntent().getIntExtra("index", 1);
        recyclerView = findViewById(R.id.attr_list);

        attr_tv = findViewById(R.id.attr_text);

        amana = new ArrayList<>();
        amana.add(getString(R.string.char_abobakr));
        amana.add(getString(R.string.char_omar));
        amana.add(getString(R.string.char_aboobida));
        amana.add(getString(R.string.char_ali));

        twad3 = new ArrayList<>();
        twad3.add(getString(R.string.char_abobakr));
        twad3.add(getString(R.string.char_omar));
        twad3.add(getString(R.string.char_osman));
        twad3.add(getString(R.string.char_ali));
        twad3.add(getString(R.string.char_saad));
        twad3.add(getString(R.string.char_aboobida));

        haya = new ArrayList<>();
        haya.add(getString(R.string.char_osman));
        haya.add(getString(R.string.char_ali));
        haya.add(getString(R.string.char_saad));
        haya.add(getString(R.string.char_said));

        sedq = new ArrayList<>();
        sedq.add(getString(R.string.char_abobakr));
        sedq.add(getString(R.string.char_omar));
        sedq.add(getString(R.string.char_ali));
        sedq.add(getString(R.string.char_saad));

        wara3 = new ArrayList<>();
        wara3.add(getString(R.string.char_abobakr));
        wara3.add(getString(R.string.char_omar));
        wara3.add(getString(R.string.char_osman));
        wara3.add(getString(R.string.char_ali));
        wara3.add(getString(R.string.char_sbair));
        wara3.add(getString(R.string.char_abdrahman));
        wara3.add(getString(R.string.char_saad));

        zuhd = new ArrayList<>();
        zuhd.add(getString(R.string.char_abobakr));
        zuhd.add(getString(R.string.char_omar));
        zuhd.add(getString(R.string.char_osman));
        zuhd.add(getString(R.string.char_ali));
        zuhd.add(getString(R.string.char_saad));
        zuhd.add(getString(R.string.char_said));
        zuhd.add(getString(R.string.char_abobakr));
        zuhd.add(getString(R.string.char_abdrahman));
        zuhd.add(getString(R.string.char_talha));
        zuhd.add(getString(R.string.char_sbair));

        switch (returnIndex){
            case 0:
                attr_tv.setText("صفة الحياة");
                adapter = new RecyclerAiAdapter(this, haya);
                recyclerView.setAdapter(adapter);
                break;
            case 1:
                attr_tv.setText("صفة الصدق");
                adapter = new RecyclerAiAdapter(this, sedq);
                recyclerView.setAdapter(adapter);
                break;
            case 2:
                attr_tv.setText("صفة الأمانة");
                adapter = new RecyclerAiAdapter(this, amana);
                recyclerView.setAdapter(adapter);
                break;
            case 3:
                attr_tv.setText("صفة التواضع");
                adapter = new RecyclerAiAdapter(this, twad3);
                recyclerView.setAdapter(adapter);
                break;
            case 4:
                attr_tv.setText("صفة الزهد");
                adapter = new RecyclerAiAdapter(this, zuhd);
                recyclerView.setAdapter(adapter);
                break;
            case 5:
                attr_tv.setText("صفة الورع");
                adapter = new RecyclerAiAdapter(this, wara3);
                recyclerView.setAdapter(adapter);
                break;
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }
}