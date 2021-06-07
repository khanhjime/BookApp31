package com.example.bookapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.bookapp.adapter.PageAdapter;
import com.example.bookapp.object.Chap;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {
    FloatingActionButton fabBack;
    ViewPager viewPager;
    private PageAdapter adapter;
    TextView txt_tenTruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        txt_tenTruyen = findViewById(R.id.txt_tenTruyen2);

        fabBack = findViewById(R.id.fabBack);
        fabBack.setOnClickListener(view -> finish());

        ArrayList<Chap> listNoiDung = (ArrayList<Chap>) getIntent().getSerializableExtra("noiDung");

        viewPager = findViewById(R.id.viewpager);
        adapter = new PageAdapter(getSupportFragmentManager());
        adapter.setListChap(listNoiDung);
        viewPager.setAdapter(adapter);





    }

}