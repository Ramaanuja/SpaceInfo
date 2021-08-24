//package com.example.spaceinfo.datalayer.repository
//
//import com.example.spaceinfo.datalayer.remotedatasource.RemoteDataSource
//import com.example.spaceinfo.domain.PictureRepository
//import retrofit2.Callback
//import retrofit2.Response
//
//class RepositoryImpl(
//    private val remoteDataSource: RemoteDataSource,
//) : PictureRepository {
//
//    override fun getPictureOfDay(date: String?, callback: Callback<ResponseData>) {
//        remoteDataSource.getPictureOfDay(date, callback)
//    }
//
//    override suspend fun getListPictures(): Response<List<Picture>> {
//        return remoteDataSource.getListPictures()
//    }

//    override fun getSpaceWeatherInfo(
//        startDate: String,
//        endDate: String,
//        type: String,
//    ): Single<List<SpaceWeatherResponse>> =
//        remoteDataSource.getSpaceWhetherInfo(startDate, endDate, type)
//
//    override fun getMarsPhoto(date: String): Single<MarsListPhoto> =
//        remoteDataSource.getMarsPhoto(date)
//
//    override fun getEarthPhoto(date: String): Single<List<EarthPhoto>> =
//        remoteDataSource.getEarthPhoto(date)
//
//    override fun addSpaceWeather(spaceWeatherResponse: SpaceWeatherResponse) {
//        localDataSource.insert(spaceWeatherResponse)
//    }
//
//    override fun getAllFavorites(): List<Any> {
//        val all = mutableListOf<Any>()
//        all.addAll(localDataSource.allSpaceWeatherResponse())
//        all.addAll(localDataSource.allEarthPhoto())
//        all.addAll(localDataSource.allMarsPhoto())
//        return all
//    }


//}