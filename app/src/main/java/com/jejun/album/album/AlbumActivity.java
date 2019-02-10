package com.jejun.album.album;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.jejun.album.R;
import com.jejun.album.navigation.NavigationView;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.init();

        RecyclerView albumList = findViewById(R.id.album_list);
        albumList.setAdapter(new AlbumAdapter(this));
    }
}
