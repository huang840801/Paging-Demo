package com.guanhong.pagingdemo.view.local

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.guanhong.pagingdemo.R
import com.guanhong.pagingdemo.response.DataItem

class LocalDataSourceAdapter : PagedListAdapter<DataItem, LocalDataSourceHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalDataSourceHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_paging, parent, false)

        return LocalDataSourceHolder(view)
    }

    override fun onBindViewHolder(holder: LocalDataSourceHolder, position: Int) {

        val data = getItem(position)

        data?.let {
            holder.setResult(data, position)
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