package com.guanhong.pagingdemo.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.guanhong.pagingdemo.callback.PagingBoundaryCallback
import com.guanhong.pagingdemo.datasource.local.LocalDataSourceFactory
import com.guanhong.pagingdemo.db.DataItemDbHelper
import com.guanhong.pagingdemo.response.DataItem

class PagingRepository : PagingRepositoryCallback {

    private lateinit var remoteLocalDataSource: LocalDataSourceFactory
    private lateinit var localDataSource: DataSource.Factory<Int, DataItem>

    override fun getDataItem(application: Application): LiveData<PagedList<DataItem>> {

        val pagedListLiveData: LiveData<PagedList<DataItem>> by lazy {

            localDataSource = DataItemDbHelper(application).getRoomDataItemDao().getAllDataItem()
            remoteLocalDataSource =
                LocalDataSourceFactory()

            val config = PagedList.Config.Builder()
                .setPageSize(25)
                .setEnablePlaceholders(false)
//                .setInitialLoadSizeHint(5)
                .build()

            LivePagedListBuilder(localDataSource, config)
                .setBoundaryCallback(PagingBoundaryCallback(application))
                .build()
        }

        return pagedListLiveData
    }
}

interface PagingRepositoryCallback {
    fun getDataItem(application: Application): LiveData<PagedList<DataItem>>
}