package com.example.spaceinfo.datalayer.remotedatasource


import com.example.spaceinfo.datalayer.remotedatasource.dto.ResponseData
import com.example.spaceinfo.BuildConfig
import com.example.spaceinfo.Utils.BASE_URL
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class RemoteDataSource {

    private val nasaAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create(GsonBuilder().setLenient().create())
        )
        .client(createOkHttpClient(PODInterceptor()))
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NasaAPI::class.java)

    fun getPictureOfDay(date: String?, callback: Callback<ResponseData>) {
        nasaAPI.getPictureOfTheDay(date, BuildConfig.nasa_api_key).enqueue(callback)
    }

    suspend fun getListPictures() = nasaAPI.getListPicturesOfTheDay(apiKey = BuildConfig.nasa_api_key)

//    fun getSpaceWhetherInfo(startDate: String, endDate: String, type: String) =
//        nasaAPI.getSpaceWeatherInfo(startDate, endDate, type, BuildConfig.nasa_api_key)
//
//    fun getMarsPhoto(date: String) = nasaAPI.getMarsPhoto(date, BuildConfig.nasa_api_key)
//
//    fun getEarthPhoto(date: String) = nasaAPI.getEarthPhoto(date, BuildConfig.nasa_api_key)


    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return httpClient.build()
    }

    inner class PODInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            return chain.proceed(chain.request())
        }
    }
}