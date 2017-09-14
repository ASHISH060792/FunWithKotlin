package com.ashish060792.funwithkotlin.core.model.github

import android.arch.lifecycle.ViewModel

/**
 * Created by Ashish on 9/7/2017.
 */
class GithubUserModel :ViewModel(){
    var userList: ArrayList<User>? = null
    val size: Int?
        get() = userList?.size
    operator fun get(position: Int) = userList?.get(position)

}