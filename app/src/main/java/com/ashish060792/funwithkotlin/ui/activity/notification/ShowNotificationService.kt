package com.ashish060792.funwithkotlin.ui.activity.notification

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import com.ashish060792.funwithkotlin.utils.genrateNotification
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Ashish on 9/14/2017.
 */
class ShowNotificationService : Service() {
    private val mHandler = Handler()
    // timer handling
    private var mTimer: Timer? = null
    val NOTIFY_INTERVAL = (10 * 1000).toLong() // 10 seconds

    override fun onCreate() {
        super.onCreate()
        if (mTimer != null) {
            mTimer!!.cancel()
        } else {
            // recreate new
            mTimer = Timer()
        }
        // schedule task
        mTimer!!.scheduleAtFixedRate(TimeDisplayTimerTask(), 0, NOTIFY_INTERVAL)

    }



    override fun onStartCommand(intent: Intent, flags: Int, startid: Int): Int {
        return Service.START_STICKY
    }
    internal inner class TimeDisplayTimerTask : TimerTask() {

        override fun run() {
            // run on another thread
            mHandler.post {
                // display toast
                val cDate = Date()
                val sdf =  SimpleDateFormat("[yyyy/MM/dd - HH:mm:ss]")
                val dateTime= sdf.format(Date())
                genrateNotification(this@ShowNotificationService,"Notification "+dateTime,"Text","SubText",58)
            }
        }
    }
    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}