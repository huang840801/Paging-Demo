package com.guanhong.pagingdemo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.guanhong.pagingdemo.datasource.remote.RemoteDataSourceFactory
import com.guanhong.pagingdemo.response.DataItem

class RemoteViewModel : ViewModel() {

    private val sourceFactory by lazy {
        RemoteDataSourceFactory()
    }

    val pagingDataItems: LiveData<PagedList<DataItem>> by lazy {
        sourceFactory.toLiveData(6, null)
    }
}