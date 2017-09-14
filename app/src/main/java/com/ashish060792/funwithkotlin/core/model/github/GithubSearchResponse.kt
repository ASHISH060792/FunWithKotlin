package com.ashish060792.funwithkotlin.core.model.github

import com.google.gson.annotations.SerializedName

/**
 * Created by Ashish on 9/7/2017.
 */
/**
 * Equivalent of user data class in kotlin
 */
data class User(
        @SerializedName("login") val login: String,
        @SerializedName("id") val id: Long,
        @SerializedName("url") val url: String,
        @SerializedName("html_url") val htmlUrl: String,
        @SerializedName("followers_url") val followersUrl: String,
        @SerializedName("following_url") val followingUrl: String,
        @SerializedName("starred_url") val starredUrl: String,
        @SerializedName("gists_url") val gistsUrl: String,
        @SerializedName("type") val type: String,
        @SerializedName("score") val score: Float
)

/**
 * Entire search result data class
 */
data class Result (
        val total_count: Int,
        val incomplete_results: Boolean,
        val items: ArrayList<User>
)