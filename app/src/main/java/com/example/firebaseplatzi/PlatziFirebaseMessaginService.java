package com.example.firebaseplatzi;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.firebaseplatzi.Model.PlatziNotification;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class PlatziFirebaseMessaginService extends FirebaseMessagingService {

    public static final String KEY_DESCOUNT = "descount_key";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.w("TAG", remoteMessage.getFrom());
        PlatziNotification platziNotification = new PlatziNotification();
        platziNotification.setId(remoteMessage.getFrom());
        platziNotification.setTitulo(remoteMessage.getNotification().getTitle());
        platziNotification.setDescription(remoteMessage.getNotification().getBody());
        platziNotification.setDescount(remoteMessage.getData().get(KEY_DESCOUNT));

        showNotification(platziNotification);
    }

    private void showNotification(PlatziNotification platziNotification){
        Intent i = new Intent(PlatziFirebaseMessaginService.this, MainActivity.class);
        i.putExtra(KEY_DESCOUNT, platziNotification.getDescount());


        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSounUri = RingtoneManager.getDefaultUri((RingtoneManager.TYPE_NOTIFICATION));

       NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
               .setSmallIcon(R.drawable.icono)
               .setContentTitle(platziNotification.getTitulo())
               .setContentText(platziNotification.getDescription())
               .setAutoCancel(true)
               .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
               .setSound(defaultSounUri)
               .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                notificationManager.notify(0, notificationBuilder.build());



    }
}
