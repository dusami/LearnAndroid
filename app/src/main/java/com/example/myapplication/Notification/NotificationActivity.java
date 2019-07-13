package com.example.myapplication.Notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

import java.nio.channels.Channel;

import static android.app.Notification.VISIBILITY_SECRET;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Button sendNotice = findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_notice:
                Intent intent = new Intent(this, NotificationTestActivity.class);
                PendingIntent pi = PendingIntent.getActivities(this, 0, new Intent[]{intent}, 0);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel = new NotificationChannel("Channel_id", "name", NotificationManager.IMPORTANCE_DEFAULT);

                    //是否绕过请勿打扰模式
//                    notificationChannel.canBypassDnd();
                    //闪光灯
                    notificationChannel.enableLights(true);
                    //锁屏显示通知
                    notificationChannel.setLockscreenVisibility(VISIBILITY_SECRET);
                    //闪关灯的灯光颜色
                    notificationChannel.setLightColor(Color.RED);
                    //桌面launcher的消息角标
//                    notificationChannel.canShowBadge();
                    //是否允许震动
                    notificationChannel.enableVibration(true);
                    //获取系统通知响铃声音的配置
//                    notificationChannel.getAudioAttributes();
                    //获取通知取到组
//                    notificationChannel.getGroup();
                    //设置可绕过  请勿打扰模式
//                    notificationChannel.setBypassDnd(true);
                    //设置震动模式
                    notificationChannel.setVibrationPattern(new long[]{0, 100, 100, 100});
                    //是否会有灯光
                    notificationChannel.shouldShowLights();

                    manager.createNotificationChannel(notificationChannel);

                }
                Notification notification = new NotificationCompat.Builder(this, "Channel_id")
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .build();
                manager.notify(1, notification);
                break;
            default:
                break;
        }
    }
}
