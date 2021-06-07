package com.example.bookapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.bookapp.FragmentChap;
import com.example.bookapp.object.Chap;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends FragmentStatePagerAdapter {
    private List<Chap> listChap = new ArrayList<>();

    public void setListChap(List<Chap> listChap) {
        this.listChap = listChap;
    }

    public PageAdapter(@NonNull @NotNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }
    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        return FragmentChap.createInstance(listChap.get(position));
    }

    @Override
    public int getCount() {
        return listChap.size();
    }
}
