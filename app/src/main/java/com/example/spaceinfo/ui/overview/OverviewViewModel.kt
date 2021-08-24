package com.example.spaceinfo.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceinfo.ResponseResult
import com.example.spaceinfo.datalayer.remotedatasource.RemoteDataSource
import com.example.spaceinfo.domain.PictureRepository

import kotlinx.coroutines.launch

class OverviewViewModel(): ViewModel() {



//    private val _liveData: MutableLiveData<ResponseResult> = MutableLiveData()
//
//    fun liveData():  LiveData<ResponseResult> {
//        getList()
//        return _liveData
//    }
//
//
//    fun getList() {
//        viewModelScope.launch {
//            val list = repository.getListPictures().body()
//            _liveData.postValue(list?.let { ResponseResult.SuccessList(it) })
//        }
//    }

}