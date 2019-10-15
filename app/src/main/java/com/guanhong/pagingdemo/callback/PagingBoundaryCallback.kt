package com.guanhong.pagingdemo.callback

import android.content.Context
import android.util.Log
import androidx.paging.PagedList
import com.guanhong.pagingdemo.api.AllPlayerApi
import com.guanhong.pagingdemo.db.DataItemDbHelper
import com.guanhong.pagingdemo.response.AllPlayerData
import com.guanhong.pagingdemo.response.DataItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PagingBoundaryCallback(context: Context) :
    PagedList.BoundaryCallback<DataItem>() {

    private var page = 2

    private val api = AllPlayerApi.api

    private val dao = DataItemDbHelper(context).getRoomDataItemDao()

    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()

        api.getAllPlayer().enqueue(createWebserviceCallback())
    }

    override fun onItemAtEndLoaded(itemAtEnd: DataItem) {
        super.onItemAtEndLoaded(itemAtEnd)

        api.getAllPlayer(page).clone().enqueue(createWebserviceCallback())
    }

    private fun createWebserviceCallback(): Callback<AllPlayerData> {

        return object : Callback<AllPlayerData> {
            override fun onFailure(call: Call<AllPlayerData>?, t: Throwable?) {
                Log.d("Huang", " get player fail ")
            }

            override fun onResponse(call: Call<AllPlayerData>?, response: Response<AllPlayerData>) {

                insertItemsIntoDb(response)
                page++
            }
        }
    }

    private fun insertItemsIntoDb(response: Response<AllPlayerData>) {

        GlobalScope.launch {

            response.body()!!.data!!.forEach {

                dao.insert(it)
            }
        }
    }
}