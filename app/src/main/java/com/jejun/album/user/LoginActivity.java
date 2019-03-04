package com.jejun.album.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jejun.album.Api;
import com.jejun.album.R;
import com.jejun.album.UtilsKt;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Locale;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jejun.album.UtilsKt.formatMessage;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.login_id)
    EditText mUserId;
    @BindView(R.id.login_pw)
    EditText mUserPassword;

    @BindView(R.id.login_submit)
    Button mLogin;
    @BindString(R.string.user_id)
    String mId;
    @BindString(R.string.user_pw)
    String mPassword;

    private KakaoSessionCallback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserId = findViewById(R.id.login_id);
        mUserPassword = findViewById(R.id.login_pw);

        mLogin = findViewById(R.id.login_submit);
        mLogin.setOnClickListener(this);

        callback = new KakaoSessionCallback();
        Session.getCurrentSession().addCallback(callback);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.login_submit)
    public void submit(View view) {
        mId = mUserId.getText().toString().trim();
        mPassword = mUserPassword.getText().toString().trim();
        mPassword = hash(mPassword);

        Api.login(this, mId, mPassword);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.kakao_login:
//                requestKakaoUserInfo();
//                break;
            mUserId.setText(UtilsKt.formatMessage("jejun"));
//            Log.e("TEST", UtilsKt.formatMessage("jejun"));
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

    public void requestKakaoUserInfo() {
        UserManagement.requestMe(new MeResponseCallback() {
            @Override
            public void onFailure(ErrorResult errorResult) {
//                super.onFailure(errorResult);
            }

            @Override
            public void onSessionClosed(ErrorResult errorResult) {}

            @Override
            public void onNotSignedUp() {
                //카카오톡 회원이 아님
            }

            @Override
            public void onSuccess(UserProfile result) {
                Log.e("UserProfile", result.toString());
                Log.e("UserProfile", result.getId() + "");
            }
        });
    }

//    @Subscribe
//    public void onLoginResponse(LoginResponse event) {
//        if (event.success) {
//            Transit.album(this);
//            finish();
//        } else {
//            Toast.makeText(this, "login fail", Toast.LENGTH_LONG).show();
//        }
//    }
}
