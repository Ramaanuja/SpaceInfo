package com.example.spaceinfo.domain.usecases

import com.example.spaceinfo.domain.PictureRepository
import com.example.spaceinfo.domain.entities.PictureOfDay
import javax.inject.Inject


class GetPictureOfDayUseCase @Inject constructor(
    private val repository: PictureRepository
) {

    suspend operator fun invoke(date: String? = null): PictureOfDay = repository.getPictureOfDay()

}

//fun main() {
//    val getPictureOfDayUseCase = GetPictureOfDayUseCase()
//    getPictureOfDayUseCase.getPictureOfDayUseCase()
//}