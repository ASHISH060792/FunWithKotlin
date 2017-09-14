package com.ashish060792.funwithkotlin.ui.activity.notification

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.ashish060792.funwithkotlin.utils.genrateNotification
import java.util.*


/**
 * Created by Ashish on 9/14/2017.
 */
class ShowNotificationService : Service() {
    private val UPDATE_INTERVAL = 60 * 1000
    private val timer = Timer()
    private val NOTIFICATION_EX = 1
    private val notificationManager: NotificationManager? = null
    override fun onCreate() {
        super.onCreate()
        genrateNotification(this@ShowNotificationService,"Notification from Service","Text","SubText",58)

    }

    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStartCommand(intent: Intent, flags: Int, startid: Int): Int {
        return Service.START_STICKY
    }

}