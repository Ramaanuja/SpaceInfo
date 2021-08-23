package com.example.spaceinfo.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.spaceinfo.datalayer.remotedatasource.dto.Picture
import com.example.spaceinfo.AppState
import com.example.spaceinfo.ui.overview.overviewRecycler.PicturePaging
import com.example.spaceinfo.datalayer.remotedatasource.RemoteDataSource
import com.example.spaceinfo.datalayer.repository.Repository
import com.example.spaceinfo.datalayer.repository.RepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class OverviewViewModel(
    private val repository: Repository = RepositoryImpl(RemoteDataSource()),
    ) : ViewModel() {



    private val _liveData: MutableLiveData<AppState> = MutableLiveData()

    fun liveData():  LiveData<AppState> {
        getList()
        return _liveData
    }


    fun getList() {
        viewModelScope.launch {
            val list = repository.getListPictures().body()
            _liveData.postValue(list?.let { AppState.SuccessList(it) })
        }
    }

    fun getListPicture(): Flow<PagingData<Picture>> {
        return Pager (config = PagingConfig(pageSize = 10, maxSize = 200),
            pagingSourceFactory = { PicturePaging(repository) }).flow.cachedIn(viewModelScope)
    }
}