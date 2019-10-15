package com.guanhong.pagingdemo.view.remote

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.guanhong.pagingdemo.R
import com.guanhong.pagingdemo.response.DataItem

class RemoteDataSourceHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val name: TextView = itemView.findViewById(R.id.name)
    private val positionTextView: TextView = itemView.findViewById(R.id.position)

    fun setResult(item: DataItem, position: Int) {

        name.text = item.firstName
        positionTextView.text = position.toString()
    }
}