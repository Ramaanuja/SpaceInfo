package com.example.spaceinfo

import com.example.spaceinfo.datalayer.remotedatasource.dto.Picture
import com.example.spaceinfo.datalayer.remotedatasource.dto.ResponseData

sealed class AppState {

    data class Success(val serverResponseData: ResponseData) : AppState()
    data class SuccessList(val serverResponseData: List<Picture>) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()

}