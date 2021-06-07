package com.example.bookapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookapp.R;
import com.example.bookapp.object.TruyenNgang;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TruyenNgangAdapter extends RecyclerView.Adapter<BookViewHolder> {
    // Lưu Context để dễ dàng truy cập
    private final Context context;
    //Dữ liệu hiện thị là danh sách truyen ngang
    private final ArrayList<TruyenNgang> truyenNgangs;

    private OnClickItemListener listener;

    public TruyenNgangAdapter(Context context, ArrayList<TruyenNgang> objects, TruyenNgangAdapter.OnClickItemListener listener) {
        this.context = context;
        this.truyenNgangs = objects;
        this.listener = listener;
    }

    public void setListener(TruyenNgangAdapter.OnClickItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        return new BookViewHolder(from.inflate(R.layout.item_truyenngang, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BookViewHolder holder, int position) {
        holder.bindView(truyenNgangs.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return Math.min(truyenNgangs.size(),5);
    }

    public interface OnClickItemListener {
        void itemClickListener(int pos);
    }

}

class BookViewHolder extends RecyclerView.ViewHolder {
    private final ImageView image;
    private final TextView textView;

    public BookViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.img_truyenngang1);
        textView = itemView.findViewById(R.id.txtTenTruyen1);
    }

    public void bindView(TruyenNgang item, TruyenNgangAdapter.OnClickItemListener listener) {
        textView.setText(item.getTenTruyen());
        Glide.with(itemView.getContext()).load(item.getAnhTruyenNgang()).into(image);
        itemView.setOnClickListener(v -> {
            listener.itemClickListener(getAdapterPosition());
        });
    }

}
