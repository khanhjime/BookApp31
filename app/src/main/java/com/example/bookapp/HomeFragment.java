package com.example.bookapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.bookapp.adapter.TruyenDocAdapter;
import com.example.bookapp.object.TruyenDoc;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeFragment extends Fragment{

    ListView dsTruyenDoc;
    TruyenDocAdapter adapter;
    ArrayList<TruyenDoc> truyenDocArrayList;
    ImageView img_doc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
        anhXa(view);
        setUp();

        img_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),ReadActivity.class));
            }
        });
    }

    private void init(){
        truyenDocArrayList= new ArrayList<>();
        truyenDocArrayList.add(new TruyenDoc("The First Man","On The Moon","by Laurent Pehem",R.drawable.iconsach4,"Biography"));
        truyenDocArrayList.add(new TruyenDoc("Of White","And Shady","by Robert Verlander",R.drawable.iconsach5,"Fiction"));
        truyenDocArrayList.add(new TruyenDoc("Purple Cow","","by Seth Godin",R.drawable.iconsach6,"Business"));


        adapter= new TruyenDocAdapter(getContext(),R.layout.item_truyen,truyenDocArrayList);

    }
    private void anhXa(View view){

        dsTruyenDoc= view.findViewById(R.id.lv_dsTruyenDoc);
        img_doc = view.findViewById(R.id.img_doc);

    }
    private void setUp(){
        dsTruyenDoc.setAdapter(adapter);
    }

}