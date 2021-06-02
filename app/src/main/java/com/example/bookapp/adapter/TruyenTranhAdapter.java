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
import com.example.bookapp.object.TruyenTranh;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TruyenTranhAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private final Context context;
    private final ArrayList<TruyenTranh> arr;
    private OnClickItemListener listener;

    public TruyenTranhAdapter(Context context, ArrayList<TruyenTranh> arr, OnClickItemListener listener) {
        this.context = context;
        this.arr = arr;
        this.listener = listener;
    }

    public void sortTruyen(String s) {
        s = s.toUpperCase();
        int k = 0;
        for (int i = 0; i < arr.size(); i++) {
            TruyenTranh t = arr.get(i);
            String ten = t.getTenTruyen().toUpperCase();
            if (ten.indexOf(s) >= 0) {
                arr.set(i, arr.get(k));
                arr.set(k, t);
                k++;
            }

        }
        notifyDataSetChanged();
    }

    public void setListener(OnClickItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        return new ItemViewHolder(from.inflate(R.layout.item_truyen, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemViewHolder holder, int position) {
        holder.bindView(arr.get(position),listener );
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }


    public interface OnClickItemListener {
        void itemClickListener(int pos);
    }
}

class ItemViewHolder extends RecyclerView.ViewHolder {

    private final TextView tenTenTruyen;
    private final ImageView imgAnhTruyen;

    public ItemViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        tenTenTruyen = itemView.findViewById(R.id.txtTenTruyen);
        imgAnhTruyen = itemView.findViewById(R.id.imgAnhTruyen);
    }

    public void bindView(TruyenTranh item, TruyenTranhAdapter.OnClickItemListener listener) {

        tenTenTruyen.setText(item.getTenTruyen());

        Glide.with(itemView.getContext()).load(item.getLinkAnh()).into(imgAnhTruyen);

        itemView.setOnClickListener(v -> {
            listener.itemClickListener(getAdapterPosition());
        });
    }
}
