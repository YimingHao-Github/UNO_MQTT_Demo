package com.hebut.uno_mqtt.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.hebut.uno_mqtt.Adapter.CPageAdapter;
import com.hebut.uno_mqtt.Fragment.EquipmentFragment;
import com.hebut.uno_mqtt.Fragment.HomePageFragment;
import com.hebut.uno_mqtt.Fragment.RecordFragment;
import com.hebut.uno_mqtt.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationBar bottomNavigationBar;

    private ViewPager viewPager;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_page);
        bottomNavigationBar = findViewById(R.id.bottom_bar);
        initViewPage();
        initBottomNavigation();

    }

    private void initViewPage() {
        viewPager.setOffscreenPageLimit(5);
        fragments = new ArrayList<>();

        fragments.add(new HomePageFragment());
        fragments.add(new EquipmentFragment());
        fragments.add(new RecordFragment());

        viewPager.setAdapter(new CPageAdapter(getSupportFragmentManager(),fragments));
        viewPager.setCurrentItem(0);
    }

    @SuppressLint("ResourceAsColor")
    private void initBottomNavigation() {
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
                viewPager.setCurrentItem(position);
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });
        bottomNavigationBar.setAutoHideEnabled(true);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.setBackgroundColor(R.color.bottomBar);
        bottomNavigationBar.setActiveColor(R.color.blue);
        bottomNavigationBar.setInActiveColor(R.color.black);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.home, "Home"))
                .addItem(new BottomNavigationItem(R.mipmap.add, "Equipment"))
                .addItem(new BottomNavigationItem(R.mipmap.html, "Record"))
                .setFirstSelectedPosition(0)
                .initialise();
    }
}


