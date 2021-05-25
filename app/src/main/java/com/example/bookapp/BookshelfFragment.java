package com.example.bookapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.bookapp.adapter.TruyenTranhAdapter;
import com.example.bookapp.api.ApiLayTruyen;
import com.example.bookapp.interfaces.LayTruyenVe;
import com.example.bookapp.object.TruyenTranh;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BookshelfFragment extends Fragment implements LayTruyenVe {
    GridView gdvDSTruyen;
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
        init();
        anhXa(view);
        setUp();
        setClick();
        new ApiLayTruyen(this).execute();
    }


    private void init(){
        truyenTranhArrayList= new ArrayList<>();

        adapter= new TruyenTranhAdapter(getContext(),R.layout.item_truyen,truyenTranhArrayList);

    }
    private void anhXa(View view){

        gdvDSTruyen= view.findViewById(R.id.gdvDSTruyen);
        edtTK= view.findViewById(R.id.edtTK);
    }
    private void setUp(){
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setClick(){
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
        Toast.makeText(getContext(),"Dang Lay Ve",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
          try {
              truyenTranhArrayList.clear();
              JSONArray array= new JSONArray(data);
              for (int i = 0; i <array.length() ; i++) {
                  JSONObject o= array.getJSONObject(i);
                  truyenTranhArrayList.add(new TruyenTranh(o));
              }
              adapter= new TruyenTranhAdapter(getContext(),R.layout.item_truyen,truyenTranhArrayList);
              gdvDSTruyen.setAdapter(adapter);
          }catch (JSONException e){
              Log.e("TAG", "ketThuc: " );

          }
    }

    @Override
    public void biLoi() {
        Toast.makeText(getContext(),"Loi Ket Noi",Toast.LENGTH_SHORT).show();

    }
}