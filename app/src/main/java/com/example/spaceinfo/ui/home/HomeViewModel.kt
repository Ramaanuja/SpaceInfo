package com.example.spaceinfo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceinfo.datalayer.remotedatasource.dto.ResponseData
import com.example.spaceinfo.AppState
import com.example.spaceinfo.BuildConfig
import com.example.spaceinfo.datalayer.remotedatasource.RemoteDataSource
import com.example.spaceinfo.datalayer.repository.Repository
import com.example.spaceinfo.datalayer.repository.RepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(
    private val liveDataForViewToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val detailRepositoryImpl: Repository = RepositoryImpl(RemoteDataSource())
) : ViewModel() {

    fun getData(): LiveData<AppState> {
        sendServerRequest(null)
        return liveDataForViewToObserve
    }

    private val callback = object : Callback<ResponseData> {
        override fun onResponse(
            call: Call<ResponseData>,
            response: Response<ResponseData>
        ) {
            if (response.isSuccessful && response.body() != null) {
                liveDataForViewToObserve.value = AppState.Success(response.body()!!)
            } else {
                val message = response.message()
                if (message.isNullOrEmpty()) {
                    liveDataForViewToObserve.value =
                        AppState.Error(Throwable("Unidentified error"))
                } else {
                    liveDataForViewToObserve.value = AppState.Error(Throwable(message))
                }
            }
        }


        override fun onFailure(call: Call<ResponseData>, t: Throwable) {
            liveDataForViewToObserve.value = AppState.Error(t)
        }
    }

    fun getList() {
        viewModelScope.launch {
            val list = detailRepositoryImpl.getListPictures().body()
            liveDataForViewToObserve.postValue(list?.let { AppState.SuccessList(it) })
        }
    }

    fun sendServerRequest(date: String?) {
        liveDataForViewToObserve.value = AppState.Loading(null)
        val apiKey: String = BuildConfig.nasa_api_key
        if (apiKey.isBlank()) {
            AppState.Error(Throwable("You need API key"))
        } else {
            detailRepositoryImpl.getPictureOfDay(date, callback)
        }
    }

}