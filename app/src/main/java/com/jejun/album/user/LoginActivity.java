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

                mPassword = hash(mPassword);

                Api.login(this, mId, mPassword);
        }
    }

    private String hash(String password) {
        StringBuilder sb = new StringBuilder();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes(Charset.forName("UTF-8")));
            byte[] digested = md.digest();

            for (byte tmp : digested) {
                sb.append(Integer.toString((tmp & 0xff) + 0x100, 16).substring(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString().toUpperCase(Locale.US);
    }

    @Subscribe
    public void onLoginResponse(LoginResponse event) {
        if (event.success) {
            Transit.album(this);
            finish();
        } else {
            Toast.makeText(this, "login fail", Toast.LENGTH_LONG).show();
        }
    }
}
