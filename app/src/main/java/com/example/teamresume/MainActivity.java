package com.example.teamresume;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.teamresume.fragments.IntroFragment;
import com.example.teamresume.fragments.TeamFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private IntroFragment introFragment;
    private TeamFragment teamFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //实例化fragments, 启动时加载teamFragment视角
        teamFragment = new TeamFragment();
        introFragment = new IntroFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frag_contianer,teamFragment).commitAllowingStateLoss();

        //material-design的BottomNavigation的监听方法
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.action_intro:{ ;
                                getSupportFragmentManager().beginTransaction().replace(R.id.frag_contianer, introFragment).commitAllowingStateLoss();
                                break;
                            }
                            case R.id.action_team:{
                                getSupportFragmentManager().beginTransaction().replace(R.id.frag_contianer, teamFragment).commitAllowingStateLoss();
                                break;
                            }
                        }
                        return true;
                    }
                }
        );
    }
}