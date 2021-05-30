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
    private OnClickItemListener listener;

    public TruyenTranhAdapter(@NonNull Context context, int resource, @NonNull List<TruyenTranh> objects) {
        super(context, resource, objects);
        this.context= context;
        this.arr= new ArrayList<>(objects);

    }
    public void sortTruyen(String s){
        s=s.toUpperCase();
        int k=0;
        for (int i = 0; i <arr.size() ; i++) {
            TruyenTranh t= arr.get(i);
            String ten= t.getTenTruyen().toUpperCase();
            if (ten.indexOf(s) >=0) {
                arr.set(i,arr.get(k));
                arr.set(k,t);
                k++;
            }

        }
        notifyDataSetChanged();
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

            ImageView imgAnhTruyen= convertView.findViewById(R.id.imgAnhTruyen);


            tenTenTruyen.setText(truyenTranh.getTenTruyen());

            Glide.with(context).load(truyenTranh.getLinkAnh()).into(imgAnhTruyen);

            convertView.setOnClickListener(v -> {
                listener.itemClickListener(position);
            });

        return convertView;
    }

    public void setListener(OnClickItemListener listener) {
        this.listener = listener;
    }

    public interface OnClickItemListener{
        void itemClickListener(int pos);
    }
}
