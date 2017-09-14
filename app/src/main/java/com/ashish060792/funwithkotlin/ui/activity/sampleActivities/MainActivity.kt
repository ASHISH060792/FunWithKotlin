package com.ashish060792.funwithkotlin.ui.activity.sampleActivities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ashish060792.funwithkotlin.R
import com.ashish060792.funwithkotlin.ui.activity.github.GitHubSearchUserActivity
import com.ashish060792.funwithkotlin.ui.activity.notification.ShowNotificationService
import com.ashish060792.funwithkotlin.utils.genrateNotification
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Ashish on 9/12/2017.
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    var service: Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomCheckActivity.setOnClickListener(this)
        githubSearchActivity.setOnClickListener(this)
        showNotification.setOnClickListener(this)
        startService.setOnClickListener(this)
        operatorOverloading.setOnClickListener(this)
        service = Intent(this, ShowNotificationService::class.java)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.randomCheckActivity -> startActivity(Intent(this@MainActivity, RangeActivity::class.java))
            R.id.githubSearchActivity -> startActivity(Intent(this@MainActivity, GitHubSearchUserActivity::class.java))
            R.id.showNotification -> genrateNotification(this@MainActivity, "Notification Title", "Notification Text", "Subtext", 56)
            R.id.startService -> startService(service);
            R.id.operatorOverloading -> startActivity(Intent(this@MainActivity, OperatorOverloading::class.java))

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(service)

    }
}