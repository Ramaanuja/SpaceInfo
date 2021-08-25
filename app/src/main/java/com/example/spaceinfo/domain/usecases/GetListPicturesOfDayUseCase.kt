package com.example.spaceinfo.domain.usecases

import com.example.spaceinfo.domain.PictureRepository
import com.example.spaceinfo.domain.entities.PictureOfDay
import javax.inject.Inject

class GetListPicturesOfDayUseCase @Inject constructor(private val repository: PictureRepository) {
    suspend operator fun invoke(): List<PictureOfDay> = repository.getListPictures()
}