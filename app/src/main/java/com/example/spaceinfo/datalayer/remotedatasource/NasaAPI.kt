package com.example.spaceinfo.datalayer.remotedatasource

import com.example.spaceinfo.datalayer.remotedatasource.dto.Picture
import com.example.spaceinfo.datalayer.remotedatasource.dto.ResponseData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NasaAPI {

    @GET("planetary/apod")
    fun getPictureOfTheDay(
        @Query("date") date: String?,
        @Query("api_key") apiKey: String
    ): Call<ResponseData>

    @GET("planetary/apod")
    suspend fun getListPicturesOfTheDay(
        @Query("count") count: Int = 10,
        @Query("thumbs") thumbs: Boolean = false,
        @Query("api_key") apiKey: String
    ): Response<List<Picture>>





//    @GET("DONKI/notifications")
//    fun getSpaceWeatherInfo(
//        @Query("startDate") date: String?,
//        @Query("endDate") endDate: String?,
//        @Query("type") type: String = "all",
//        @Query("api_key") apiKey: String
//    ): Single<List<SpaceWeatherResponse>>
//
//    @GET("mars-photos/api/v1/rovers/curiosity/photos")
//    fun getMarsPhoto(
//        @Query("earth_date") date: String?,
//        @Query("api_key") apiKey: String
//    ): Single<MarsListPhoto>
//
//    @GET("EPIC/api/natural/date/{date}")
//    fun getEarthPhoto(
//        @Path("date") date: String?,
//        @Query("api_key") apiKey: String
//    ): Single<List<EarthPhoto>>


}