package com.example.bookapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.bookapp.object.Chap;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {
    private ViewPager view_pager;
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        ActionBar actionBar = getSupportActionBar();

        actionBar.hide();

        img_back = findViewById(R.id.btnback);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ArrayList<Chap> listNoiDung = (ArrayList<Chap>) getIntent().getSerializableExtra("noiDung");
        view_pager= (ViewPager) findViewById(R.id.view_pager);
        MyViewPagerAdapter adapter= new MyViewPagerAdapter(this,listNoiDung);
        view_pager.setAdapter(adapter);

    }

}