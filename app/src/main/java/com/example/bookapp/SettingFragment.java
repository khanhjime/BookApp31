package com.example.bookapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookapp.api.ApiLayTruyen;

import org.jetbrains.annotations.NotNull;

public class SettingFragment extends Fragment {

    TextView txt_setting,txt_help,txt_about;
    ImageView icon_right,icon_right2,icon_right3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        anhXa(view);

        txt_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SettingActivity.class);
                startActivity(intent);
            }
        });

        icon_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SettingActivity.class);
                startActivity(intent);
            }
        });

        txt_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),HelpCenterAboutActivity.class);
                startActivity(intent);
            }
        });

        icon_right2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),HelpCenterAboutActivity.class);
                startActivity(intent);
            }
        });

        txt_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),AboutActivity.class);
                startActivity(intent);
            }
        });

        icon_right3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),AboutActivity.class);
                startActivity(intent);
            }
        });

    }

    private void anhXa(View view){

        txt_setting = view.findViewById(R.id.txt_setting);
        txt_help = view.findViewById(R.id.txt_help);
        txt_about = view.findViewById(R.id.txt_about);
        icon_right = view.findViewById(R.id.icon_right);
        icon_right2 = view.findViewById(R.id.icon_right2);
        icon_right3 = view.findViewById(R.id.icon_right3);
    }
}