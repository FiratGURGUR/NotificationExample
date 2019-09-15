package com.gurgur.notificationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String CHANEL_ID ="channel_id01";
    public static final int NOTIFICATION_ID =1;
    Button showNotificationBtn,showNotificationActionBtn,showExpandable,showBigPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showNotificationBtn = findViewById(R.id.btnSendNotification);
        showNotificationActionBtn = findViewById(R.id.btnSendNotificationActionButtons);
        showNotificationBtn.setOnClickListener(this);
        showNotificationActionBtn.setOnClickListener(this);
        showExpandable= findViewById(R.id.btnExpandable);
        showExpandable.setOnClickListener(this);
        showBigPicture = findViewById(R.id.btnBigPicture);
        showBigPicture.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSendNotification:
               showNotification();
                break;
            case R.id.btnSendNotificationActionButtons:
                showNotificationActions();
                break;
            case R.id.btnExpandable:
                showNotificationExpandable();
                break;
            case R.id.btnBigPicture:
                showNotificationBigPicture();
                break;
        }
    }



    public void showNotification(){
        createNotificationChannel();

        Intent mainIntent = new Intent(this,MainActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
        PendingIntent mainPIntent = PendingIntent.getActivity(this,0,mainIntent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Notification Title");
        builder.setContentText("Notification Text");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        builder.setAutoCancel(true);
        builder.setContentIntent(mainPIntent);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());

    }


    public void showNotificationActions(){
        createNotificationChannel();

        Intent mainIntent = new Intent(this,MainActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
        PendingIntent mainPIntent = PendingIntent.getActivity(this,0,mainIntent,PendingIntent.FLAG_ONE_SHOT);

        Intent likeIntent = new Intent(this,LikeActivity.class);
        likeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
        PendingIntent likePIntent = PendingIntent.getActivity(this,0,likeIntent,PendingIntent.FLAG_ONE_SHOT);

        Intent dislikeIntent = new Intent(this,DislikeActivity.class);
        dislikeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
        PendingIntent dislikePIntent = PendingIntent.getActivity(this,0,dislikeIntent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Notification Title");
        builder.setContentText("Notification Text");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        builder.setAutoCancel(true);
        builder.setContentIntent(mainPIntent);

        builder.addAction(R.drawable.ic_like,"Like",likePIntent);
        builder.addAction(R.drawable.ic_dislike,"Disike",dislikePIntent);


        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());

    }
    public void showNotificationExpandable(){
        createNotificationChannel();

        Intent mainIntent = new Intent(this,MainActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
        PendingIntent mainPIntent = PendingIntent.getActivity(this,0,mainIntent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Notification Title");
        builder.setContentText("Notification Text");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        builder.setAutoCancel(true);
        builder.setContentIntent(mainPIntent);

        builder.setStyle(new NotificationCompat.BigTextStyle().bigText("Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır. Beşyüz yıl boyunca varlığını sürdürmekle kalmamış, aynı zamanda pek değişmeden elektronik dizgiye de sıçramıştır. 1960'larda Lorem Ipsum pasajları da içeren Letraset yapraklarının yayınlanması ile ve yakın zamanda Aldus PageMaker gibi Lorem Ipsum sürümleri içeren masaüstü yayıncılık yazılımları ile popüler olmuştur."));

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());

    }

    public void showNotificationBigPicture(){
        createNotificationChannel();

        Intent mainIntent = new Intent(this,MainActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
        PendingIntent mainPIntent = PendingIntent.getActivity(this,0,mainIntent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Notification Title");
        builder.setContentText("Notification Text");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        builder.setAutoCancel(true);
        builder.setContentIntent(mainPIntent);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.notification_image);
        builder.setLargeIcon(bitmap);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null));

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());

    }

    public void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "My Notification";
            String description = "My Notification Description";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel =new NotificationChannel(CHANEL_ID,name,importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }


}
