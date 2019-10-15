package com.guanhong.pagingdemo.datasource.local

import android.util.Log
import androidx.paging.ItemKeyedDataSource
import com.guanhong.pagingdemo.api.AllPlayerApi
import com.guanhong.pagingdemo.response.AllPlayerData
import com.guanhong.pagingdemo.response.DataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocalDataSource : ItemKeyedDataSource<Int, DataItem>() {

    private val retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://free-nba.p.rapidapi.com/")
        .build()

    private val allPlayerData = retrofit.create(AllPlayerApi::class.java)

    private var page = 1

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<DataItem>
    ) {

        val call = allPlayerData.getAllPlayer(page)

        call.enqueue(object : Callback<AllPlayerData> {

            override fun onFailure(call: Call<AllPlayerData>?, t: Throwable?) {
                Log.d("Huang", " get player fail ")
            }

            override fun onResponse(call: Call<AllPlayerData>?, response: Response<AllPlayerData>) {

                callback.onResult(response.body()!!.data!!, 5, 30)
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<DataItem>) {

        val call = allPlayerData.getAllPlayer(page)

        call.enqueue(object : Callback<AllPlayerData> {

            override fun onFailure(call: Call<AllPlayerData>?, t: Throwable?) {
                Log.d("Huang", " get player fail ")
            }

            override fun onResponse(call: Call<AllPlayerData>?, response: Response<AllPlayerData>) {

                callback.onResult(response.body()!!.data!!)

                page += 1
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<DataItem>) {
    }

    override fun getKey(item: DataItem): Int {

        return page
    }
}