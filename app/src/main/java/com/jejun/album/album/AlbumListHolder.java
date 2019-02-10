package com.jejun.album.album;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class AlbumListHolder extends RecyclerView.ViewHolder {

    private Context mContext;

    public AlbumListHolder(Context context, @NonNull View itemView) {
        super(itemView);

        mContext = context;
    }
}
