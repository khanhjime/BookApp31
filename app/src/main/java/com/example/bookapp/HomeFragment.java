package com.example.bookapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.bookapp.adapter.TruyenNgangAdapter;
import com.example.bookapp.object.TruyenNgang;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeFragment extends Fragment{

    private RecyclerView dsTruyenNgang;
    private TruyenNgangAdapter truyenNgangAdapter;
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

        anhXa(view);
        init();

        img_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),ReadActivity.class));
            }
        });
    }

    private void init(){
        truyenNgangAdapter = new TruyenNgangAdapter(getContext(), getDataFake());
//        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        dsTruyenNgang.setLayoutManager(horizontalLayoutManager);

        dsTruyenNgang.setAdapter(truyenNgangAdapter);

    }
    private void anhXa(View view){

        dsTruyenNgang= view.findViewById(R.id.rv_truyenngang);
        img_doc = view.findViewById(R.id.img_doc);
    }

    private ArrayList<TruyenNgang> getDataFake() {
        ArrayList<TruyenNgang> listTemp = new ArrayList<>();
        listTemp.add(new TruyenNgang(R.drawable.iconsach1));
        listTemp.add(new TruyenNgang(R.drawable.iconsach2));
        listTemp.add(new TruyenNgang(R.drawable.iconsach3));
        listTemp.add(new TruyenNgang(R.drawable.iconsach4));
        listTemp.add(new TruyenNgang(R.drawable.iconsach5));
        listTemp.add(new TruyenNgang(R.drawable.iconsach6));
        listTemp.add(new TruyenNgang(R.drawable.anh5));
        listTemp.add(new TruyenNgang(R.drawable.anh8));
        return listTemp;
    }

}