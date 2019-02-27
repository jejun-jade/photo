package com.jejun.album.album;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jejun.album.R;

public class FragmentUser extends BaseFragment implements View.OnClickListener {

    public TextView userName, userEmail, userKakao, userQuit;

    public static FragmentUser newInstance() {
        FragmentUser fragment = new FragmentUser();
        Bundle bundle = new Bundle();

        fragment.setArguments(bundle);

        return fragment;
    }

    private Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activity = getActivity();

        userName = view.findViewById(R.id.user_name);
        userEmail = view.findViewById(R.id.user_email);
        userKakao = view.findViewById(R.id.user_kakao);
        userQuit = view.findViewById(R.id.user_quit);

        userName.setOnClickListener(this);
        userEmail.setOnClickListener(this);
        userKakao.setOnClickListener(this);
        userQuit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

    }
}
