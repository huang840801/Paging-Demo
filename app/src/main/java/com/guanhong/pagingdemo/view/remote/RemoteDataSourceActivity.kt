package com.guanhong.pagingdemo.view.remote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.guanhong.pagingdemo.R
import com.guanhong.pagingdemo.viewModel.RemoteViewModel
import kotlinx.android.synthetic.main.activity_remote.*

class RemoteDataSourceActivity : AppCompatActivity() {

    private lateinit var viewModel: RemoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remote)

        viewModel = ViewModelProviders.of(this).get(RemoteViewModel::class.java)

        val adapter = RemoteDataSourceAdapter()
        recyclerView.adapter = adapter

        viewModel.pagingDataItems.observe(this, Observer {

            adapter.submitList(it)
        })
    }
}