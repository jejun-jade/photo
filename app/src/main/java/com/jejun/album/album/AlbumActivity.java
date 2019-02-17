package com.jejun.album.album;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jejun.album.R;
import com.jejun.album.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import eu.long1.spacetablayout.SpaceTabLayout;

public class AlbumActivity extends AppCompatActivity {

    private SpaceTabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.init();

//        RecyclerView albumList = findViewById(R.id.album_list);
//        albumList.setAdapter(new AlbumAdapter(this));

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentUser());
        fragmentList.add(new FragmentAlbum());
        fragmentList.add(new FragmentCamera());

        ViewPager viewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.spaceTabLayout);

        mTabLayout.initialize(viewPager, getSupportFragmentManager(), fragmentList, savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mTabLayout.saveState(outState);
        super.onSaveInstanceState(outState);
    }
}
