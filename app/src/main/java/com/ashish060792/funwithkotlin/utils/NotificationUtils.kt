package com.ashish060792.funwithkotlin.utils

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import com.ashish060792.funwithkotlin.R



/**
 * Created by Ashish on 9/14/2017.
 */
 fun genrateNotification(context: Context,title:String,text:String,subText:String,id:Int) {
    val NOTIFICATION_ID = 237
    val value = 0
    val inboxStyle = Notification.InboxStyle()
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/platform/index.html#api-framework"))
    val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
    val nManager =context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    val builder = Notification.Builder(context)
    builder.setContentTitle(title)
    builder.setContentIntent(pendingIntent)
    builder.setContentText(text+ value)
    builder.setSmallIcon(R.drawable.ic_action_action_search)
    builder.setLargeIcon(BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher))
    builder.setAutoCancel(true)
    inboxStyle.setBigContentTitle("Enter Content Text")
    inboxStyle.addLine("hi events " + value)
    builder.setStyle(inboxStyle)
    nManager.notify("App Name", NOTIFICATION_ID, builder.build())
}