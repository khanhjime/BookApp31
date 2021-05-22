package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.ListView;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipNavigationBar = findViewById(R.id.bottomNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        bottomMenu();
    }

    private void bottomMenu(){
      chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
          @Override
          public void onItemSelected(int i) {
              Fragment fragment = null;
              switch (i){
                  case R.id.navigation_home:
                    fragment = new HomeFragment();
                    break;
                  case R.id.navigation_bookshelf:
                      fragment = new BookshelfFragment();
                      break;
                  case R.id.navigation_setting:
                      fragment = new SettingFragment();
                      break;
              }
              getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
          }
      });
    }
}