package com.example.bookapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.bookapp.R;
import com.example.bookapp.object.TruyenDoc;

import java.util.ArrayList;
import java.util.List;

public class TruyenDocAdapter extends ArrayAdapter<TruyenDoc> {
    private  Context context;
    private ArrayList<TruyenDoc> arr;

    public TruyenDocAdapter(@NonNull Context context, int resource, @NonNull List<TruyenDoc> objects) {
        super(context, resource, objects);
        this.context= context;
        this.arr= new ArrayList<>(objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView== null){
            LayoutInflater inflater= LayoutInflater.from(context);
            convertView= inflater.inflate(R.layout.item_sachdoc, null);

        }

        TruyenDoc truyenDoc= arr.get(position);

        TextView Name1= convertView.findViewById(R.id.txt_name1);
        TextView Name2= convertView.findViewById(R.id.txt_name2);
        TextView Name3= convertView.findViewById(R.id.txt_name3);
        Button theLoai = convertView.findViewById(R.id.btn_theLoai);
        ImageView imgAnhTruyen= convertView.findViewById(R.id.img_truyen);


        Name1.setText(truyenDoc.getName1());
        Name2.setText(truyenDoc.getName2());
        Name3.setText(truyenDoc.getName3());
        theLoai.setText(truyenDoc.getTheLoai());

        Glide.with(context).load(truyenDoc.getAnhSach()).into(imgAnhTruyen);

        return convertView;
    }
}
