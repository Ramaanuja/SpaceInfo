package com.example.spaceinfo.domain.entities

import com.google.gson.annotations.SerializedName

data class PictureOfDay(
    val date: String? = null,
    val explanation: String? = null,
    val hdurl: String? = null,
    val mediaType: String? = null,
    val serviceVersion: String? = null,
    val title: String? = null,
    val url: String? = null,
    val inFavorite: Boolean
)