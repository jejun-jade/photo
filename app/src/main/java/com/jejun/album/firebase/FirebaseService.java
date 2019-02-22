package com.jejun.album.firebase;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.nio.channels.Channel;

public class FirebaseService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        handleRemoteMessage(remoteMessage, this);

    }

    private void handleRemoteMessage(RemoteMessage message, Context context) {
        FirebaseHelper.Message msg = new FirebaseHelper.Message(message.getData().get("data"));

        PendingIntent pending = PendingIntent.getActivity(context, msg.type, getPendingIntent(msg.type), PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, FirebaseHelper.Channel.NOTICE);
        builder.setContentTitle(msg.title);
        builder.setContentText(msg.message);
        builder.setContentIntent(pending);
        builder.setAutoCancel(true);
        builder.setOngoing(false);
        builder.setDefaults(Notification.DEFAULT_ALL);

        FirebaseHelper.getManager(context).notify(msg.type, builder.build());
    }

    private static Intent getPendingIntent(int type) {
        switch (type) {
            default:
                return new Intent("xxx:undefined:intent");
        }
    }
}
