package com.example.bookapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ReadActivity extends AppCompatActivity {

    ImageView img_back;
    TextView tv_ndung,tv_tenTruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        ActionBar actionBar = getSupportActionBar();

        actionBar.hide();

        img_back = findViewById(R.id.btnback);
        tv_ndung = findViewById(R.id.desTv);
        tv_tenTruyen = findViewById(R.id.txt_tenTruyen);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        String noiDung = getIntent().getStringExtra("noiDung");
        String tenTruyen = getIntent().getStringExtra("tenTruyen");
        tv_ndung.setText(noiDung);
        tv_tenTruyen.setText(tenTruyen);

    }
}