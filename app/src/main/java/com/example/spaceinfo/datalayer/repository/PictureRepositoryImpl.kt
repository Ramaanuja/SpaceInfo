package com.example.spaceinfo.datalayer.repository

import com.example.spaceinfo.datalayer.localdatasource.RoomDataSource
import com.example.spaceinfo.datalayer.remotedatasource.RemoteDataSource
import com.example.spaceinfo.datalayer.remotedatasource.dto.PictureFromApi
import com.example.spaceinfo.domain.PictureRepository
import com.example.spaceinfo.domain.entities.PictureOfDay
import javax.inject.Inject

class PictureRepositoryImpl @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val localDataSource: RoomDataSource
    ) : PictureRepository {

    override suspend fun getPictureOfDay(date: String?): PictureOfDay {
        val pictureFromApi = dataSource.getPictureOfDay(date)
        val isFavorite = if (date == null)
            localDataSource.isTodayPictureFavorite()
        else
            localDataSource.isPictureFavorite(date)
        return pictureFromApiConvert(pictureFromApi, isFavorite)
    }

    fun pictureFromApiConvert(pictureFromApi: PictureFromApi, inFavorite: Boolean): PictureOfDay =
        PictureOfDay(
            date = pictureFromApi.date,
            explanation = pictureFromApi.explanation,
            hdurl = pictureFromApi.hdurl,
            mediaType = pictureFromApi.mediaType,
            serviceVersion = pictureFromApi.serviceVersion,
            title = pictureFromApi.title,
            url = pictureFromApi.url,
            inFavorite = inFavorite
        )
}