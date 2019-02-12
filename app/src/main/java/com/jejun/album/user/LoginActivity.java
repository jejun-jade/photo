package com.jejun.album.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jejun.album.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mUserId, mUserPassword;
    private Button mLogin;
    private String mId, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserId = findViewById(R.id.login_id);
        mUserPassword = findViewById(R.id.login_pw);

        mLogin = findViewById(R.id.login_submit);
        mLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_submit:
                mId = mUserId.getText().toString().trim();
                mPassword = mUserPassword.getText().toString().trim();
                // TODO : login api connect
        }
    }
}
