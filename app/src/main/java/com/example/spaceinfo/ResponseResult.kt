package com.example.spaceinfo


//sealed class ResponseResult {
//
//    data class Success(val serverResponseData: ResponseData) : ResponseResult()
//    data class SuccessList(val serverResponseData: List<Picture>) : ResponseResult()
//    data class Error(val error: Throwable) : ResponseResult()
//    data class Loading(val progress: Int?) : ResponseResult()
//
//}

sealed class ResponseResult<out R> {
    data class Success<T>(val data: T) : ResponseResult<T>()
    data class Error(val error: Throwable) : ResponseResult<Nothing>()
    data class Loading(val progress: Int? = null) : ResponseResult<Nothing>()
}