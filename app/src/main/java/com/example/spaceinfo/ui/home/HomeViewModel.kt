package com.example.spaceinfo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceinfo.domain.entities.PictureOfDay
import com.example.spaceinfo.domain.usecases.GetListPicturesOfDayUseCase
import com.example.spaceinfo.domain.usecases.GetPictureOfDayUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPictureOfDayUseCase: GetPictureOfDayUseCase,
    private val getListPicturesOfDayUseCase: GetListPicturesOfDayUseCase
) : ViewModel() {

    private val _pictureLiveData = MutableLiveData<PictureOfDay>()
    val pictureLiveData: LiveData<PictureOfDay> =  _pictureLiveData

    private val _seeAlsoLiveData = MutableLiveData<List<PictureOfDay>>()
    val seeAlsoLiveData: LiveData<List<PictureOfDay>> = _seeAlsoLiveData


    fun getListSeeAlso() {
        viewModelScope.launch {
            _seeAlsoLiveData.value = getListPicturesOfDayUseCase.invoke()
        }
    }


    fun getStartPicture() {
        viewModelScope.launch {
            _pictureLiveData.value = getPictureOfDayUseCase.invoke()
        }
    }

    fun clickOnPicture() {

    }

    fun clickOnSeeAlso(pictureOfDay: PictureOfDay) {
        viewModelScope.launch {
            _pictureLiveData.value = getPictureOfDayUseCase.invoke(pictureOfDay.date)
        }

    }

    fun changeDate(date: String) {

    }

    fun sendLink() {

    }


}