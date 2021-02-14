package com.gehad.eslamy.api

import com.gehad.eslamy.data.RadiosResponse
import retrofit2.Call
import retrofit2.http.GET

interface WebServices {
    //"http://mp3quran.net/api/radio/radio_ar.json"
    @GET("radio/radio_ar.json")
    fun getRadiosChannels(): Call<RadiosResponse>

}