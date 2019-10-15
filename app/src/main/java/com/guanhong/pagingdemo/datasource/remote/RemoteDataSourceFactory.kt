package com.guanhong.pagingdemo.datasource.remote

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.guanhong.pagingdemo.response.DataItem

class RemoteDataSourceFactory  : DataSource.Factory<Int, DataItem>() {

    private val sourceLiveData = MutableLiveData<RemoteDataSource>()

    override fun create(): DataSource<Int, DataItem> {

        val source = RemoteDataSource()
        sourceLiveData.postValue(source)

        return source
    }
}