package com.example.bookapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookapp.R;
import com.example.bookapp.ReadActivity;
import com.example.bookapp.object.TruyenNgang;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TruyenNgangAdapter extends RecyclerView.Adapter<BookViewHolder> {
    // Lưu Context để dễ dàng truy cập
    private final Context context;
    //Dữ liệu hiện thị là danh sách truyen tranh
    private final List<TruyenNgang> truyenNgangs;

    public TruyenNgangAdapter(Context context, ArrayList<TruyenNgang> objects) {
        this.context = context;
        this.truyenNgangs = objects;
    }

    @NonNull
    @NotNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_truyenngang, parent, false);
        return new BookViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BookViewHolder holder, int position) {
        holder.bindView(truyenNgangs.get(position));
    }

    @Override
    public int getItemCount() {
        return truyenNgangs.size();
    }
}

class BookViewHolder extends RecyclerView.ViewHolder {
    private final ImageView image;
    private Context context;

    public BookViewHolder(@NonNull @NotNull View itemView, Context context) {
        super(itemView);
        this.context =context;
        image = itemView.findViewById(R.id.img_truyenngang1);
    }

    public void bindView(TruyenNgang item) {
        Glide.with(context).load(item.getAnhTruyenNgang()).into(image);
        image.setOnClickListener(v -> {
            context.startActivity(new Intent(context,ReadActivity.class));
        });
    }
}
