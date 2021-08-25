package com.example.spaceinfo.domain


import com.example.spaceinfo.domain.entities.PictureOfDay

interface PictureRepository {

    suspend fun getPictureOfDay(date: String? = null): PictureOfDay

    suspend fun getListPictures(): List<PictureOfDay>




}