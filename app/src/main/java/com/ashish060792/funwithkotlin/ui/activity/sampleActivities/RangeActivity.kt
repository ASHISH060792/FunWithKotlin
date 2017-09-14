package com.ashish060792.funwithkotlin.ui.activity.sampleActivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.ashish060792.funwithkotlin.R
import kotlinx.android.synthetic.main.activity_range.*

/**
 * Created by Ashish on 9/12/2017.
 */
class RangeActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_range)
        userInput.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                checkInput(userInput.text.toString())
                return@OnEditorActionListener true
            }
            false
        })

    }

    private fun checkInput(input: String) {
        if (!input.isEmpty()) {
            val intInput: Int = input.toInt()
            if (intInput in 1..9)
                inRange.text="Input is in Range"
            else
                inRange.text="Input is out Range"

        }
    }
}