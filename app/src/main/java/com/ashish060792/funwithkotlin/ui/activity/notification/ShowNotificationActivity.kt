package com.ashish060792.funwithkotlin.ui.activity.notification

import android.annotation.TargetApi
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.NotificationCompat
import android.view.View
import com.ashish060792.funwithkotlin.R
import kotlinx.android.synthetic.main.notification_activity.*


/**
 * Created by Ashish on 9/14/2017.
 */
class ShowNotificationActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.showNotification -> {
                genrateNotification()
            }

        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private fun genrateNotification() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/platform/index.html#api-framework"))
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val builder = NotificationCompat.Builder(this)
        builder.setContentIntent(pendingIntent)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
        builder.setContentTitle("Notifications Title")
        builder.setContentText("Your notification content here.")
        builder.setSubText("Tap to view documentation about notifications.")
        builder.setSmallIcon(R.drawable.ic_action_action_search)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val NOTIFICATION_ID = 156
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_activity)
        showNotification.setOnClickListener(this)
    }
}