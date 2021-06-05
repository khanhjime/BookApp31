package com.example.bookapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bookapp.adapter.TruyenNgangAdapter;
import com.example.bookapp.api.ApiLayTruyen;
import com.example.bookapp.interfaces.LayTruyenVe;
import com.example.bookapp.object.TruyenNgang;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

public class HomeFragment extends Fragment implements LayTruyenVe, TruyenNgangAdapter.OnClickItemListener{
    private RecyclerView dsTruyenNgang;
    private TruyenNgangAdapter truyenNgangAdapter;
    ArrayList<TruyenNgang> truyenNgangArrayList;
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

        new ApiLayTruyen(this).execute();

        img_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),ReadActivity.class);
                startActivity(intent);
            }
        });

    }

    private void init(){
        truyenNgangArrayList = new ArrayList<>();
        truyenNgangAdapter = new TruyenNgangAdapter(getContext(), truyenNgangArrayList,this);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        dsTruyenNgang.setLayoutManager(horizontalLayoutManager);
        dsTruyenNgang.setAdapter(truyenNgangAdapter);

    }
    private void anhXa(View view){

        dsTruyenNgang= view.findViewById(R.id.rv_truyenngang);
        img_doc=view.findViewById(R.id.img_doc);
    }

    @Override
    public void batDau() {
        Toast.makeText(getContext(),"Dang Lay Ve",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            truyenNgangArrayList.clear();
            JSONArray array= new JSONArray(data);
            for (int i = 0; i <array.length() ; i++) {
                JSONObject o= array.getJSONObject(i);
                truyenNgangArrayList.add(new TruyenNgang(o));
            }
            truyenNgangAdapter= new TruyenNgangAdapter(getContext(),truyenNgangArrayList,this);
            dsTruyenNgang.setAdapter(truyenNgangAdapter);
            Collections.reverse(truyenNgangArrayList);
        }catch (JSONException e){
            Log.e("TAG", "ketThuc: " );

        }
    }

    @Override
    public void biLoi() {
        Toast.makeText(getContext(),"Loi Ket Noi",Toast.LENGTH_SHORT).show();
    }
    public void itemClickListener(int pos) {
        Intent intent = new Intent(getContext(),ReadActivity.class);
        intent.putExtra("noiDung",truyenNgangArrayList.get(pos).getNoiDung());
        intent.putExtra("tenTruyen",truyenNgangArrayList.get(pos).getTenTruyen());
        startActivity(intent);
    }

}