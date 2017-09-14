package com.ashish060792.funwithkotlin.ui.activity.sampleActivities
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ashish060792.funwithkotlin.R
import com.ashish060792.funwithkotlin.ui.activity.github.GitHubSearchUserActivity
import com.ashish060792.funwithkotlin.ui.activity.notification.ShowNotificationActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Ashish on 9/12/2017.
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomCheckActivity.setOnClickListener(this)
        githubSearchActivity.setOnClickListener(this)
        showNotification.setOnClickListener(this)

    }
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.randomCheckActivity -> {
                startActivity(Intent(this@MainActivity, RangeActivity::class.java))
            }
            R.id.githubSearchActivity -> {
                startActivity(Intent(this@MainActivity, GitHubSearchUserActivity::class.java))
            }
            R.id.showNotification -> {
                startActivity(Intent(this@MainActivity, ShowNotificationActivity::class.java))
            }
        }
    }

}