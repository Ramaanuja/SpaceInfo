package com.example.spaceinfo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceinfo.domain.entities.PictureOfDay
import com.example.spaceinfo.domain.usecases.GetPictureOfDayUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPictureOfDayUseCase: GetPictureOfDayUseCase,
) : ViewModel() {

    private val _pictureLiveData = MutableLiveData<PictureOfDay>()
    val pictureLiveData: LiveData<PictureOfDay> =  _pictureLiveData

    private val _seeAlsoLiveData = MutableLiveData<List<PictureOfDay>>()
    val seeAlsoLiveData: LiveData<List<PictureOfDay>> = _seeAlsoLiveData



    fun getStartPicture() {
        viewModelScope.launch {
            _pictureLiveData.value = getPictureOfDayUseCase()!!
        }
    }

    fun clickOnPicture() {

    }

    fun clickOnSeeAlso(pictureOfDay: PictureOfDay) {

    }

    fun changeDate(date: String) {

    }

    fun sendLink() {

    }





//    fun getData(): LiveData<ResponseResult> {
//        sendServerRequest(null)
//        return liveDataForViewToObserve
//    }
//
//    private val callback = object : Callback<ResponseData> {
//        override fun onResponse(
//            call: Call<ResponseData>,
//            response: Response<ResponseData>
//        ) {
//            if (response.isSuccessful && response.body() != null) {
//                liveDataForViewToObserve.value = ResponseResult.Success(response.body()!!)
//            } else {
//                val message = response.message()
//                if (message.isNullOrEmpty()) {
//                    liveDataForViewToObserve.value =
//                        ResponseResult.Error(Throwable("Unidentified error"))
//                } else {
//                    liveDataForViewToObserve.value = ResponseResult.Error(Throwable(message))
//                }
//            }
//        }
//
//
//        override fun onFailure(call: Call<ResponseData>, t: Throwable) {
//            liveDataForViewToObserve.value = ResponseResult.Error(t)
//        }
//    }
//
//    fun getList() {
//        viewModelScope.launch {
//            val list = detailRepositoryImpl.getListPictures().body()
//            liveDataForViewToObserve.postValue(list?.let { ResponseResult.SuccessList(it) })
//        }
//    }
//
//    fun sendServerRequest(date: String?) {
//        liveDataForViewToObserve.value = ResponseResult.Loading(null)
//        val apiKey: String = BuildConfig.nasa_api_key
//        if (apiKey.isBlank()) {
//            ResponseResult.Error(Throwable("You need API key"))
//        } else {
//            detailRepositoryImpl.getPictureOfDay(date, callback)
//        }
//    }

}