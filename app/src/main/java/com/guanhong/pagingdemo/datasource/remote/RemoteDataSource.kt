package com.guanhong.pagingdemo.datasource.remote

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.guanhong.pagingdemo.api.AllPlayerApi
import com.guanhong.pagingdemo.response.AllPlayerData
import com.guanhong.pagingdemo.response.DataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource : PageKeyedDataSource<Int, DataItem>() {

    private val api = AllPlayerApi.api

    private var page = 1

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, DataItem>) {

        api.getAllPlayer(page).enqueue(object : Callback<AllPlayerData> {

            override fun onFailure(call: Call<AllPlayerData>?, t: Throwable?) {
                Log.d("Huang", " get player fail ")
            }

            override fun onResponse(call: Call<AllPlayerData>?, response: Response<AllPlayerData>) {

                callback.onResult(response.body()!!.data!!, null, page)
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DataItem>) {

        api.getAllPlayer(page).enqueue(object : Callback<AllPlayerData> {

            override fun onFailure(call: Call<AllPlayerData>?, t: Throwable?) {
                Log.d("Huang", " get player fail ")
            }

            override fun onResponse(call: Call<AllPlayerData>?, response: Response<AllPlayerData>) {

                callback.onResult(response.body()!!.data!!, page)

                page += 1
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DataItem>) {}
}