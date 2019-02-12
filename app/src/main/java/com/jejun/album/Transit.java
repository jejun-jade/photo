package com.jejun.album;

import android.content.Context;
import android.content.Intent;

import com.jejun.album.user.LoginActivity;

public class Transit {

    public static void login(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    public static void join(Context context) {

    }

    public static void takePicture(Context context) {

    }
}
