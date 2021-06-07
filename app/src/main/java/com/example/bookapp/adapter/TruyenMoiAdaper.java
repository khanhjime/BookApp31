package com.example.bookapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookapp.R;
import com.example.bookapp.object.TruyenMoi;
import com.example.bookapp.object.TruyenNgang;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TruyenMoiAdaper extends RecyclerView.Adapter<BookView1Holder> {
    // Lưu Context để dễ dàng truy cập
    private final Context context;
    //Dữ liệu hiện thị là truyen moi
    private final ArrayList<TruyenMoi> truyenMois;

    private TruyenMoiAdaper.OnClickItemListener listener;

    public TruyenMoiAdaper(Context context, ArrayList<TruyenMoi> objects, TruyenMoiAdaper.OnClickItemListener listener) {
        this.context = context;
        this.truyenMois = objects;
        this.listener = listener;
    }

    public void setListener(TruyenMoiAdaper.OnClickItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public BookView1Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        return new BookView1Holder(from.inflate(R.layout.item_truyenmoi, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BookView1Holder holder, int position) {
        holder.bindView(truyenMois.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return Math.min(truyenMois.size(),1);
    }

    public interface OnClickItemListener {
        void itemClickListener(int pos);
    }

}

class BookView1Holder extends RecyclerView.ViewHolder {
    private final ImageView anhTruyen, btn_chon;
    private final TextView tenTruyen;

    public BookView1Holder(@NonNull @NotNull View itemView) {
        super(itemView);
        anhTruyen = itemView.findViewById(R.id.img_anhTruyenMoi);
        btn_chon = itemView.findViewById(R.id.img_doc);
        tenTruyen = itemView.findViewById(R.id.txt_tenTruyen2);
    }

    public void bindView(TruyenMoi item, TruyenMoiAdaper.OnClickItemListener listener) {
        tenTruyen.setText(item.getTenTruyen());
        Glide.with(itemView.getContext()).load(item.getAnhTruyenMoi()).into(anhTruyen);
        btn_chon.setOnClickListener(v -> {
            listener.itemClickListener(getAdapterPosition());
        });
    }
}
