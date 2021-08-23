package com.example.nasaapp.Utils

import android.util.Log
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


//fun dataSettings(countOfDay: Int, viewModel: StartViewModel) {
//    val cal = Calendar.getInstance()
//    cal.add(Calendar.DATE, -countOfDay)
//    viewModel.sendServerRequest(SimpleDateFormat("yyyy-MM-dd").format(cal.time))
//}
//
//fun createUrl(earthPhoto: EarthPhoto): String {
//    var splitData= ""
//    try {
//        splitData = earthPhoto.date?.split(" ")?.get(0)?.replace("-", "/").toString()
//    } catch (e: Exception) {
//        Log.i(CREATE_URL_ERROR, "createUrl: Exception")
//    }
//    return "https://epic.gsfc.nasa.gov/archive/natural/$splitData/png/${earthPhoto.image}.png"
//}
