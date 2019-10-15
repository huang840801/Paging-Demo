package com.guanhong.pagingdemo.viewModel.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guanhong.pagingdemo.repository.PagingRepository
import com.guanhong.pagingdemo.viewModel.LocalViewModel

@Suppress("UNCHECKED_CAST")
class LocalViewModelFactory(
    private val repository: PagingRepository,
    private val application: Application
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        with(modelClass) {

            when {
                isAssignableFrom(LocalViewModel::class.java) -> LocalViewModel(
                    repository,
                    application
                )

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}