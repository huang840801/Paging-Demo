package com.guanhong.pagingdemo.datasource.local

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.guanhong.pagingdemo.response.DataItem

class LocalDataSourceFactory : DataSource.Factory<Int, DataItem>() {

    private val sourceLiveData = MutableLiveData<LocalDataSource>()

    override fun create(): DataSource<Int, DataItem> {

        val source = LocalDataSource()
        sourceLiveData.postValue(source)

        return source
    }
}