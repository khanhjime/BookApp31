package com.example.bookapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookapp.object.Chap;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {
    FloatingActionButton fabBack;
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        fabBack = findViewById(R.id.fabBack);
        fabBack.setOnClickListener(view -> finish());

        tvContent = findViewById(R.id.tvContent);

//        ArrayList<Chap> listNoiDung = (ArrayList<Chap>) getIntent().getSerializableExtra("noiDung");
//        tvContent.setText();

    }

}