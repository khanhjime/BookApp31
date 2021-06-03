package com.example.bookapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookapp.adapter.TruyenTranhAdapter;
import com.example.bookapp.api.ApiLayTruyen;
import com.example.bookapp.interfaces.LayTruyenVe;
import com.example.bookapp.object.Chap;
import com.example.bookapp.object.TruyenTranh;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class BookshelfFragment extends Fragment implements LayTruyenVe, TruyenTranhAdapter.OnClickItemListener {
    RecyclerView gdvDSTruyen;
    TruyenTranhAdapter adapter;
    ArrayList<TruyenTranh> truyenTranhArrayList;
    EditText edtTK;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_bookshelf, container, false);

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anhXa(view);
        init(view);
        setUp();
        setClick();
        new ApiLayTruyen(this).execute();


    }


    private void init(View view) {
        truyenTranhArrayList = new ArrayList<>();

        adapter = new TruyenTranhAdapter(getContext(), truyenTranhArrayList, this);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false);
        gdvDSTruyen.setLayoutManager(layoutManager);

        ImageView imageView = view.findViewById(R.id.imgUpdate);
        imageView.setOnClickListener(v -> {
            new ApiLayTruyen(this).execute();
        });
    }

    private void anhXa(View view) {

        gdvDSTruyen = view.findViewById(R.id.gdvDSTruyen);
        edtTK = view.findViewById(R.id.edtTK);
    }

    private void setUp() {
        gdvDSTruyen.setAdapter(adapter);
    }

    private void setClick() {
        edtTK.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                edtTK.getText();
                adapter.sortTruyen(String.valueOf(s));
            }
        });
    }


    @Override
    public void batDau() {
        Toast.makeText(getContext(), "Dang Lay Ve", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
        truyenTranhArrayList.clear();
        truyenTranhArrayList.addAll(parseData(data));
        adapter = new TruyenTranhAdapter(getContext(), truyenTranhArrayList, this);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false);
        gdvDSTruyen.setLayoutManager(layoutManager);
        gdvDSTruyen.setAdapter(adapter);
    }

    @Override
    public void biLoi() {
        Toast.makeText(getContext(), "Loi Ket Noi", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void itemClickListener(int pos) {
        Intent intent = new Intent(getContext(), ReadActivity.class);
        intent.putExtra("noiDung", truyenTranhArrayList.get(pos).getNoiDung());
        startActivity(intent);
    }

    private ArrayList<TruyenTranh> parseData(String json) {
        ArrayList<TruyenTranh> list = new ArrayList<>();
        String tenTruyen, linkAnh;
        ArrayList<Chap> listChap = new ArrayList<>();

        try {
            JSONArray arrayJson = new JSONArray(json);
            for (int i = 0; i < arrayJson.length(); i++) {
                JSONObject jsonObject = arrayJson.getJSONObject(i);
                tenTruyen = jsonObject.getString("tenTruyen");
                linkAnh = jsonObject.getString("linhAnh");
                JSONArray jsonArrayNd = jsonObject.getJSONArray("noiDung");
                for (int k = 0; k < jsonArrayNd.length(); k++) {
                    JSONObject jsonObjectChap = jsonArrayNd.getJSONObject(k);
                    listChap.add(new Chap(jsonObjectChap.getInt("pageNumber"), jsonObjectChap.getString("data")));
                }
                list.add(new TruyenTranh(tenTruyen,linkAnh,listChap));
            }
        } catch (Exception ex) {

        }

        return list;
    }
}