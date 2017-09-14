package com.ashish060792.funwithkotlin.ui.adapter.github

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ashish060792.funwithkotlin.R
import com.ashish060792.funwithkotlin.core.model.github.User

/**
 * Created by Ashish on 9/7/2017.
 */
class GithubRecyclerViewAdapter(var userList: ArrayList<User>?) : RecyclerView.Adapter<GithubRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTitle.text = userList?.get(position)!!.login
        holder.mUrl.text = userList!!.get(position).url
        holder.mHtmlUrl.text = userList!!.get(position).htmlUrl

    }

    override fun getItemCount(): Int {
        if(userList?.size!=null){
            return userList!!.size

        }else{
            return 0
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTitle: TextView
        var mUrl: TextView
        var mHtmlUrl: TextView

        init {
            mTitle = itemView.findViewById(R.id.title)
            mUrl = itemView.findViewById(R.id.url)
            mHtmlUrl = itemView.findViewById(R.id.html_url)
        }

    }

}