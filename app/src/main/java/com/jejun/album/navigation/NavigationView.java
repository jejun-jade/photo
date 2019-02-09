package com.jejun.album.navigation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class NavigationView extends LinearLayout {

    private RecyclerView mList;
    private Context mContext;

    public NavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mList = findViewById(R.id.nav_list);
        mList.setHasFixedSize(true);
        mList.setLayoutManager(new LinearLayoutManager(mContext));
    }

    public void init() {
        NavigationAdapter mAdapter = new NavigationAdapter(mContext);
        mList.setAdapter(mAdapter);
    }
}
