package com.jejun.album.album;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jejun.album.R;

public class FragmentCamera extends BaseFragment {

    public static FragmentCamera newInstance() {
        FragmentCamera fragment = new FragmentCamera();
        Bundle bundle = new Bundle();

        fragment.setArguments(bundle);

        return fragment;
    }

    private Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_camera, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activity = getActivity();
    }

}
