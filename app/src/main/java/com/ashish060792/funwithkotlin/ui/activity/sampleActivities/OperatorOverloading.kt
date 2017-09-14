package com.ashish060792.funwithkotlin.ui.activity.sampleActivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ashish060792.funwithkotlin.R
import kotlinx.android.synthetic.main.operator_overloading.*

/**
 * Created by Ashish on 9/14/2017.
 */
class OperatorOverloading : AppCompatActivity(), View.OnClickListener {



    override fun onClick(view: View?) {
        when (view?.id) {

//            R.id.calculate -> result.text=concat(number1.text.toString(),(number2.text.toString()))
//
//            R.id.calculateOver -> concat(number1.text.toString(),(number2.text.toString()))
            R.id.calculate -> result.text = number1.text.toString().toInt().plus(number2.text.toString().toInt()).toString()

            R.id.calculateOver -> result.text = Addition(number1.text.toString().toInt(),number2.text.toString().toInt()).plus(number2.text.toString().toInt()).toString()


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.operator_overloading)
        calculate.setOnClickListener(this)
        calculateOver.setOnClickListener(this)
    }


}

class Addition(val first:Int,val second: Int){
    operator fun plus(increment: Int): Int {
        return first-second
    }
}

private fun concat(first: String, second: String): String = first.plus(second)

private fun String.toQuotes(first: String, second: String): CharSequence? {
    return first.replace(first, "\"$first\"").plus(second)
}


