package com.guanhong.pagingdemo.view.local

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.guanhong.pagingdemo.viewModel.factory.LocalViewModelFactory
import com.guanhong.pagingdemo.R
import com.guanhong.pagingdemo.repository.PagingRepository
import com.guanhong.pagingdemo.viewModel.LocalViewModel
import kotlinx.android.synthetic.main.activity_local.*

class LocalDataSourceActivity : AppCompatActivity() {

    lateinit var viewModel: LocalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local)

        val factory = LocalViewModelFactory(PagingRepository(), application)

        viewModel = ViewModelProviders.of(this, factory).get(LocalViewModel::class.java)

        val adapter = LocalDataSourceAdapter()
        recyclerView.adapter = adapter

        viewModel.pagedListLiveData.observe(this, Observer {

            adapter.submitList(it)

        })
    }
}
