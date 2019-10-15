package com.guanhong.pagingdemo.view.remote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.guanhong.pagingdemo.R
import com.guanhong.pagingdemo.response.DataItem

class RemoteDataSourceAdapter: PagedListAdapter<DataItem, RemoteDataSourceHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemoteDataSourceHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_paging, parent, false)

        return RemoteDataSourceHolder(view)
    }

    override fun onBindViewHolder(holder: RemoteDataSourceHolder, position: Int) {

        val data = getItem(position)

        data?.let {
            holder.setResult(data,position)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DataItem>() {

        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.id == newItem.id
        }
    }
}