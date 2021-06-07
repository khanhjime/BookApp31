package com.example.bookapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.bookapp.object.Chap;

import org.jetbrains.annotations.NotNull;

public class FragmentChap extends Fragment {

    TextView desTv;
    public static Fragment createInstance(Chap chap) {
        FragmentChap fragmentChap = new FragmentChap();
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_CHAP", chap);
        fragmentChap.setArguments(bundle);
        return fragmentChap;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_chap, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Chap chapItem = (Chap) getArguments().getSerializable("KEY_CHAP");

        Log.e("TAG", "data: " + chapItem.getData());
        desTv = (TextView) view.findViewById(R.id.desTv);
        desTv.setText(chapItem.getData());

    }


}
