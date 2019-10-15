package com.guanhong.pagingdemo.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.guanhong.pagingdemo.R
import com.guanhong.pagingdemo.view.local.LocalDataSourceActivity
import com.guanhong.pagingdemo.view.remote.RemoteDataSourceActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        localButton.setOnClickListener {

            startActivity(Intent(this, LocalDataSourceActivity::class.java))
        }

        remoteButton.setOnClickListener {

            startActivity(Intent(this, RemoteDataSourceActivity::class.java))
        }
    }
}