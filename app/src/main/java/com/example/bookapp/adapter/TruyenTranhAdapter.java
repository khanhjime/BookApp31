package com.example.bookapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.bookapp.R;
import com.example.bookapp.object.TruyenTranh;

import java.util.ArrayList;
import java.util.List;

public class TruyenTranhAdapter extends ArrayAdapter<TruyenTranh> {
    private  Context context;
    private ArrayList<TruyenTranh> arr;

    public TruyenTranhAdapter(@NonNull Context context, int resource, @NonNull List<TruyenTranh> objects) {
        super(context, resource, objects);
        this.context= context;
        this.arr= new ArrayList<>(objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView== null){
            LayoutInflater inflater= LayoutInflater.from(context);
            convertView= inflater.inflate(R.layout.item_truyen, null);

        }

            TruyenTranh truyenTranh= arr.get(position);

            TextView tenTenTruyen= convertView.findViewById(R.id.txtTenTruyen);
            TextView tenTenChap= convertView.findViewById(R.id.txtTenChap);
            ImageView imgAnhTruyen= convertView.findViewById(R.id.imgAnhTruyen);


            tenTenTruyen.setText(truyenTranh.getTenTruyen());
            tenTenChap.setText(truyenTranh.getTenChap());

            Glide.with(context).load(truyenTranh.getLinhAnh()).into(imgAnhTruyen);

        return convertView;
    }

}
