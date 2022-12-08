package com.example.quizzzz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Quizz> quizzList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tao su kien cho bottom_navigation_bar
        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationView);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.play:
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.history:
                        replaceFragment(new HistoryFragment());
                        break;
                }
                return true;
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);

        //hỗ trợ actionbar bằng toolbar
        setSupportActionBar(toolbar);
        replaceFragment(new HomeFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutoolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //lay id cua cac item menu
        int id = item.getItemId();
        switch (id) {
            case R.id.feedback:
                String sub = "[GÓP Ý PHÁT TRIỂN QUIZ APP]";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"20021492@vnu.edu.vn"});
                intent.putExtra(Intent.EXTRA_SUBJECT, sub);
                startActivity(intent);
                break;
            case R.id.information:
                replaceFragment(new InforFragment());
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void Choosetopic(View view) {
        switch (view.getId()) {
            case R.id.cardGeography:
                Fragment fragment = new LevelFragment();
                Bundle bundle = new Bundle();
                bundle.putString("topic", "Geography");
                fragment.setArguments(bundle);
                replaceFragment(fragment);
                break;
            case R.id.cardHistory:
                Fragment fragment1 = new LevelFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putString("topic", "History");
                fragment1.setArguments(bundle1);
                replaceFragment(fragment1);
                break;
            case R.id.cardAnimal:
                Fragment fragment2 = new LevelFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putString("topic", "Animal");
                fragment2.setArguments(bundle2);
                replaceFragment(fragment2);
                break;
            case R.id.cardScience:
                Fragment  fragment3 = new LevelFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putString("topic", "Science");
                fragment3.setArguments(bundle3);
                replaceFragment(fragment3);
                break;
            case R.id.cardSports:
                Fragment  fragment4 = new LevelFragment();
                Bundle bundle4 = new Bundle();
                bundle4.putString("topic", "Sports");
                fragment4.setArguments(bundle4);
                replaceFragment(fragment4);
                break;
            case R.id.cardAstronomy:
                Fragment fragment5 = new LevelFragment();
                Bundle bundle5 = new Bundle();
                bundle5.putString("topic", "Astronomy");
                fragment5.setArguments(bundle5);
                replaceFragment(fragment5);
                break;
            case R.id.cardLove:
                Fragment  fragment6 = new LevelFragment();
                Bundle bundle6 = new Bundle();
                bundle6.putString("topic", "Love");
                fragment6.setArguments(bundle6);
                replaceFragment(fragment6);
                break;
            case R.id.cardPolice:
                Fragment  fragment7 = new LevelFragment();
                Bundle bundle7 = new Bundle();
                bundle7.putString("topic", "Police");
                fragment7.setArguments(bundle7);
                replaceFragment(fragment7);
                break;
            case R.id.cardArt:
                Fragment  fragment8 = new LevelFragment();
                Bundle bundle8 = new Bundle();
                bundle8.putString("topic", "Art");
                fragment8.setArguments(bundle8);
                replaceFragment(fragment8);
                break;
            case R.id.cardSociety:
                Fragment  fragment9 = new LevelFragment();
                Bundle bundle9 = new Bundle();
                bundle9.putString("topic", "Society");
                fragment9.setArguments(bundle9);
                replaceFragment(fragment9);
                break;

        }
    }

    public void Chooselevel(View view) {
        switch (view.getId()) {
            case R.id.easy_level:
                Fragment fragment = new QuizFragment();
                Bundle bundle = new Bundle();
                bundle.putString("level", "easy");
                fragment.setArguments(bundle);
                replaceFragment(fragment);
                break;
            case R.id.medium_level:
                Fragment fragment1 = new QuizFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putString("level", "medium");
                fragment1.setArguments(bundle1);
                replaceFragment(fragment1);
                break;
            case R.id.hard_level:
                Fragment fragment2 = new QuizFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putString("level", "hard");
                fragment2.setArguments(bundle2);
                replaceFragment(fragment2);
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.my_nav_host_fragment, fragment);
        fragmentTransaction.addToBackStack(null).commit();
    }
}