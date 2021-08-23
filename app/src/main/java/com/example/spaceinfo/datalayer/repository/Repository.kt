package com.example.spaceinfo.datalayer.repository


import com.example.spaceinfo.datalayer.remotedatasource.dto.Picture
import com.example.spaceinfo.datalayer.remotedatasource.dto.ResponseData
import retrofit2.Callback
import retrofit2.Response

interface Repository {

    fun getPictureOfDay(date: String?, callback: Callback<ResponseData>)

    suspend fun getListPictures(): Response<List<Picture>>

//    fun getSpaceWeatherInfo(
//        startDate: String,
//        endDate: String,
//        type: String
//    ): Single<List<SpaceWeatherResponse>>
//
//    fun getMarsPhoto(date: String): Single<MarsListPhoto>
//
//    fun getEarthPhoto(date: String): Single<List<EarthPhoto>>
//
//    fun addSpaceWeather(spaceWeatherResponse: SpaceWeatherResponse)
//
//    fun getAllFavorites(): List<Any>



}