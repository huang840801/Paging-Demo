package com.guanhong.pagingdemo.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.guanhong.pagingdemo.repository.PagingRepository

class LocalViewModel (repository: PagingRepository, application: Application) :
    AndroidViewModel(application) {

    val pagedListLiveData = repository.getDataItem(application)
}
