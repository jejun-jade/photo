package com.jejun.album.navigation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jejun.album.R;
import com.jejun.album.Transit;

public class NavigationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mMenu;

        private int mPosition;

        public ViewHolder(View v) {
            super(v);

            mMenu = v.findViewById(R.id.navigation_item_title);
            v.setOnClickListener(this);
        }

        public void bind(int position) {
            mPosition = position;

            switch (mPosition) {
                case NavConstants.SETTINGS:
                    mMenu.setText(mContext.getString(R.string.setting));
                    break;
            }
        }

        @Override
        public void onClick(View view) {
            switch (mPosition) {
                case NavConstants.SETTINGS:
                    //TODO : move settings menu
                    Transit.login(mContext);
                    break;
            }
        }
    }

    private Context mContext;
    private LayoutInflater mInflater;

    public NavigationAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = mInflater.inflate(R.layout.navigation_list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder) {
            ((ViewHolder) viewHolder).bind(i);
        }
    }

    @Override
    public int getItemCount() {
        return NavConstants.COUNT;
    }
}
