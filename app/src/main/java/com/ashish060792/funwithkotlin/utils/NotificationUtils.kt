package com.ashish060792.funwithkotlin.utils

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.NotificationCompat
import com.ashish060792.funwithkotlin.R

/**
 * Created by Ashish on 9/14/2017.
 */
 fun genrateNotification(context: Context,title:String,text:String,subText:String,id:Int) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/platform/index.html#api-framework"))
    val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
    val builder = NotificationCompat.Builder(context)
    builder.setContentIntent(pendingIntent)
    builder.setLargeIcon(BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher))
    builder.setContentTitle(title)
    builder.setContentText(text)
    builder.setSubText(subText)
    builder.setSmallIcon(R.drawable.ic_action_action_search)
    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.notify(id, builder.build())
}