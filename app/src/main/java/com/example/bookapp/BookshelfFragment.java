package com.example.bookapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.bookapp.adapter.TruyenTranhAdapter;
import com.example.bookapp.object.TruyenTranh;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BookshelfFragment extends Fragment {
    GridView gdvDSTruyen;
    TruyenTranhAdapter adapter;
    ArrayList<TruyenTranh> truyenTranhArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_bookshelf, container, false);

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        anhXa(view);
        setUp();
        setClick();
    }

    private void init(){
        truyenTranhArrayList= new ArrayList<>();
        truyenTranhArrayList.add(new TruyenTranh("Người Trong Giang Hồ","Chương 2335",R.drawable.anh1));
        truyenTranhArrayList.add(new TruyenTranh("Thám Tử Conan","Chương 1072",R.drawable.anh2));
        truyenTranhArrayList.add(new TruyenTranh("Bách Luyện Thành Thần","Chương 750",R.drawable.anh3));
        truyenTranhArrayList.add(new TruyenTranh("Huyết Ma Nhân","Chương 747",R.drawable.anh4));
        truyenTranhArrayList.add(new TruyenTranh("Người Trong Giang Hồ","Chương 2335",R.drawable.anh5));
        truyenTranhArrayList.add(new TruyenTranh("Thám Tử Conan","Chương 1072",R.drawable.anh6));
        truyenTranhArrayList.add(new TruyenTranh("Bách Luyện Thành Thần","Chương 750",R.drawable.anh7));
        truyenTranhArrayList.add(new TruyenTranh("Huyết Ma Nhân","Chương 747",R.drawable.anh8));
        truyenTranhArrayList.add(new TruyenTranh("Người Trong Giang Hồ","Chương 2335",R.drawable.anh9));
        truyenTranhArrayList.add(new TruyenTranh("Thám Tử Conan","Chương 1072",R.drawable.anh1));
        truyenTranhArrayList.add(new TruyenTranh("Bách Luyện Thành Thần","Chương 750",R.drawable.anh2));
        truyenTranhArrayList.add(new TruyenTranh("Huyết Ma Nhân","Chương 747",R.drawable.anh3));


        adapter= new TruyenTranhAdapter(getContext(),R.layout.item_truyen,truyenTranhArrayList);

    }
    private void anhXa(View view){

        gdvDSTruyen= view.findViewById(R.id.gdvDSTruyen);
    }
    private void setUp(){
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setClick(){}

}