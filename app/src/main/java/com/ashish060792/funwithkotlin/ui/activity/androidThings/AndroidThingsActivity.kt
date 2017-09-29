package com.ashish060792.funwithkotlin.ui.activity.androidThings

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.CompoundButton
import com.ashish060792.funwithkotlin.R
import com.google.android.things.pio.Gpio
import com.google.android.things.pio.PeripheralManagerService
import kotlinx.android.synthetic.main.android_things.*
import kotlinx.android.synthetic.main.list_item_gpio.*
import java.io.IOException
import java.util.*

/**
 * Created by Ashish on 9/29/2017.
 */
class AndroidThingsActivity:AppCompatActivity(){
    private val TAG = AndroidThingsActivity::class.java.getSimpleName()

    private val mGpioMap = LinkedHashMap<String, Gpio>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.android_things)
        val pioService = PeripheralManagerService()
        for (name in pioService.getGpioList()) {
            gpio_switch.setText(name)
            gpio_pins.addView(gpio_switch)
            Log.d(TAG, "Added button for GPIO: " + name)
            try {
                val ledPin = pioService.openGpio(name)
                ledPin.setEdgeTriggerType(Gpio.EDGE_NONE)
                ledPin.setActiveType(Gpio.ACTIVE_HIGH)
                ledPin.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW)
                gpio_switch.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
                    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
                        try {
                            ledPin.setValue(isChecked)
                        } catch (e: IOException) {
                            Log.e(TAG, "error toggling gpio:", e)
                            buttonView.setOnCheckedChangeListener(null)
                            // reset button to previous state.
                            buttonView.isChecked = !isChecked
                            buttonView.setOnCheckedChangeListener(this)
                        }
                    }
                })
                mGpioMap.put(name, ledPin)
            } catch (e: IOException) {
                Log.e(TAG, "Error initializing GPIO: " + name, e)
                // disable button
                gpio_switch.isEnabled = false
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        for ((key, value) in mGpioMap) {
            try {
                value.close()
            } catch (e: IOException) {
                Log.e(TAG, "Error closing GPIO " + key, e)
            }
        }
        mGpioMap.clear()
    }
}