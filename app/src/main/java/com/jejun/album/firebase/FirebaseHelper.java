package com.jejun.album.firebase;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.StringDef;

import com.google.firebase.iid.FirebaseInstanceId;
import com.jejun.album.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class FirebaseHelper {

    public static class Message {
        public int type;
        public String title;
        public String message;

        public Message(String data) {
            try {
                JSONObject jsonObject = new JSONObject(data);

                type = jsonObject.getInt("type");
                title = jsonObject.getString("title");
                message = jsonObject.getString("message");
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void register() {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful() || task.getResult() == null) {
                        return;
                    }

                    String fcmId = task.getResult().getToken();
                    // TODO : send fcm id to server
                });
    }

    public static android.app.NotificationManager getManager(Context context) {
        return (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @TargetApi(26)
    public static void createChannel(Context context) {

        NotificationChannelGroup group = new NotificationChannelGroup("Album", "Album");
        getManager(context).createNotificationChannelGroup(group);

        NotificationChannel channelNotice = new NotificationChannel(Channel.NOTICE, "Album", android.app.NotificationManager.IMPORTANCE_HIGH);
        channelNotice.setLightColor(Color.GREEN);
        channelNotice.setGroup("Album");
        channelNotice.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        getManager(context).createNotificationChannel(channelNotice);
    }

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            Channel.NOTICE
    })

    public @interface Channel {
        String NOTICE = "notice";
    }
}
