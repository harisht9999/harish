package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendnotification(View view) {
        NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel nc=new NotificationChannel("harish","SRM NOTIFICATIONS",NotificationManager.IMPORTANCE_HIGH);
            nm.createNotificationChannel(nc);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"harish");
        builder.setSmallIcon(R.drawable.duo);
        builder.setContentTitle("sample notification");
        builder.setContentText("This is discription of notification");
        builder.setAutoCancel(true);
        PendingIntent pi=PendingIntent.getActivity(this,33,new Intent(this,MainActivity.class),PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.e);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
        nm.notify(22,builder.build());
    }
}