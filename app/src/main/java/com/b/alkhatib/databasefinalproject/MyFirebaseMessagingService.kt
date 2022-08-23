package com.b.alkhatib.databasefinalproject

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelId = "notification_channel"
const val channelName = "com.b.alkhatib.databasefinalproject"
class MyFirebaseMessagingService:FirebaseMessagingService() {
    // 1. انشاء الاشعار
    // 2. تصميم الشعار بملف تصميم
    // 3. اظهار الاشعار

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        generateNotification(remoteMessage.notification!!.title!!, remoteMessage.notification!!.body!!)
    }

    @SuppressLint("RemoteViewLayout")
    fun getRemoteView(title:String, message: String):RemoteViews{
        val remoteView = RemoteViews("com.b.alkhatib.databasefinalproject",R.layout.notification)
            remoteView.setTextViewText(R.id.tvId,title)
            remoteView.setTextViewText(R.id.tvMessage,message)
            remoteView.setImageViewResource(R.id.app_logo,R.drawable.icon3)

        return remoteView
    }

fun generateNotification(title:String, message:String){
    val intent = Intent(this,MainActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

    val pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_ONE_SHOT)

    //channel id, channel name
    var builder:NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, channelId)
        .setSmallIcon(R.drawable.icpn_round)
        .setAutoCancel(true)
        .setVibrate(longArrayOf(1000,1000,1000,1000))
        .setOnlyAlertOnce(true)
        .setContentIntent(pendingIntent)

    builder = builder.setContent(getRemoteView(title,message))

    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        val notificationChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
        notificationManager.createNotificationChannel(notificationChannel)
    }

    notificationManager.notify(0, builder.build())

}
}