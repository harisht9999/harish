package com.example.tab_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.pager);
        tabLayout=findViewById(R.id.tab);
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
    class TabAdapter extends FragmentPagerAdapter{

        public TabAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    return new chats();
                case 1:
                    return new calls();
                case 2:
                    return new status();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
        public CharSequence getPageTitle(int position){
            switch(position){
                case 0:
                    return "chats";
                case 1:
                    return "status";
                case 2:
                    return "calls";
            }
            return super.getPageTitle(position);
        }
    }
}