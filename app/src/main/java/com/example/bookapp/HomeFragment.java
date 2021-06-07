package com.example.bookapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bookapp.adapter.TruyenMoiAdaper;
import com.example.bookapp.adapter.TruyenNgangAdapter;
import com.example.bookapp.adapter.TruyenTranhAdapter;
import com.example.bookapp.api.ApiLayTruyen;
import com.example.bookapp.interfaces.LayTruyenVe;
import com.example.bookapp.object.Chap;
import com.example.bookapp.object.TruyenMoi;
import com.example.bookapp.object.TruyenNgang;
import com.example.bookapp.object.TruyenTranh;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

public class HomeFragment extends Fragment implements LayTruyenVe, TruyenNgangAdapter.OnClickItemListener, TruyenMoiAdaper.OnClickItemListener{
    private RecyclerView dsTruyenNgang, rv_truyenmoi;
    private TruyenNgangAdapter truyenNgangAdapter;
    ArrayList<TruyenNgang> truyenNgangArrayList;
    private TruyenMoiAdaper truyenMoiAdaper;
    ArrayList<TruyenMoi> truyenMoiArrayList;

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

    }

    private void init(){
        truyenNgangArrayList = new ArrayList<>();
        truyenNgangAdapter = new TruyenNgangAdapter(getContext(), truyenNgangArrayList,this);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        dsTruyenNgang.setLayoutManager(horizontalLayoutManager);
        dsTruyenNgang.setAdapter(truyenNgangAdapter);

        truyenMoiArrayList = new ArrayList<>();
        truyenMoiAdaper = new TruyenMoiAdaper(getContext(), truyenMoiArrayList,this);
        LinearLayoutManager horizontalLayoutManager1
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rv_truyenmoi.setLayoutManager(horizontalLayoutManager1);
        rv_truyenmoi.setAdapter(truyenMoiAdaper);

    }
    private void anhXa(View view){

        dsTruyenNgang = view.findViewById(R.id.rv_truyenngang);
        rv_truyenmoi = view.findViewById(R.id.rv_truyenmoi);
    }

    @Override
    public void batDau() {
        Toast.makeText(getContext(),"Dang Lay Ve",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
        Log.e("TAG", "ketThuc: " );
        truyenNgangArrayList.clear();
        truyenNgangArrayList.addAll(parseData(data));
        truyenNgangAdapter = new TruyenNgangAdapter(getContext(), truyenNgangArrayList, this);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        dsTruyenNgang.setLayoutManager(horizontalLayoutManager);
        Collections.reverse(truyenNgangArrayList);
        dsTruyenNgang.setAdapter(truyenNgangAdapter);

        Log.e("TAG", "ketThuc: " );
        truyenMoiArrayList.clear();
        truyenMoiArrayList.addAll(parseData1(data));
        truyenMoiAdaper = new TruyenMoiAdaper(getContext(), truyenMoiArrayList, this);
        LinearLayoutManager horizontalLayoutManager1
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rv_truyenmoi.setLayoutManager(horizontalLayoutManager1);
        Collections.reverse(truyenMoiArrayList);
        rv_truyenmoi.setAdapter(truyenMoiAdaper);
    }

    @Override
    public void biLoi() {
        Toast.makeText(getContext(),"Loi Ket Noi",Toast.LENGTH_SHORT).show();
    }
    public void itemClickListener(int pos) {
        Intent intent = new Intent(getContext(),ReadActivity.class);
        intent.putExtra("tenTruyen",truyenNgangArrayList.get(pos).getTenTruyen());
        intent.putExtra("noiDung",truyenNgangArrayList.get(pos).getNoiDung());
        intent.putExtra("tenTruyen",truyenMoiArrayList.get(pos).getTenTruyen());
        intent.putExtra("noiDung",truyenMoiArrayList.get(pos).getNoiDung());
        startActivity(intent);
    }

    private ArrayList<TruyenNgang> parseData(String json) {
        ArrayList<TruyenNgang> list = new ArrayList<>();
        String tenTruyen, linkAnh;

        try {
            JSONArray arrayJson = new JSONArray(json);
            for (int i = 0; i < arrayJson.length(); i++) {
                ArrayList<Chap> listChap = new ArrayList<>();
                JSONObject jsonObject = arrayJson.getJSONObject(i);
                truyenNgangArrayList.add(new TruyenNgang());
                tenTruyen = jsonObject.getString("tenTruyen");
                linkAnh = jsonObject.getString("linhAnh");
                JSONArray jsonArrayNd = jsonObject.getJSONArray("noiDung");
                for (int k = 0; k < jsonArrayNd.length(); k++) {
                    JSONObject jsonObjectChap = jsonArrayNd.getJSONObject(k);
                    listChap.add(new Chap(jsonObjectChap.getInt("pageNumber"), jsonObjectChap.getString("data")));
                }
                list.add(new TruyenNgang(tenTruyen, linkAnh,listChap));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    private ArrayList<TruyenMoi> parseData1(String json) {
        ArrayList<TruyenMoi> list = new ArrayList<>();
        String tenTruyen, linkAnh;
        Button doc = null;

        try {
            JSONArray arrayJson = new JSONArray(json);
            for (int i = 0; i < arrayJson.length(); i++) {
                ArrayList<Chap> listChap = new ArrayList<>();
                JSONObject jsonObject = arrayJson.getJSONObject(i);
                tenTruyen = jsonObject.getString("tenTruyen");
                linkAnh = jsonObject.getString("linhAnh");
                JSONArray jsonArrayNd = jsonObject.getJSONArray("noiDung");
                for (int k = 0; k < jsonArrayNd.length(); k++) {
                    JSONObject jsonObjectChap = jsonArrayNd.getJSONObject(k);
                    listChap.add(new Chap(jsonObjectChap.getInt("pageNumber"), jsonObjectChap.getString("data")));
                }
                list.add(new TruyenMoi(tenTruyen, linkAnh, doc,listChap));
            }
        } catch (Exception ex) {

        }

        return list;
    }

}