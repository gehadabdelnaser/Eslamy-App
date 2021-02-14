package com.gehad.eslamy.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    companion object{
        private var retrofit : Retrofit
        init {
            retrofit = Retrofit.Builder()
                .baseUrl("http://mp3quran.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        private fun getInstance(): Retrofit{
            return retrofit
        }

        fun getWebServices():WebServices{
            return getInstance().create(WebServices::class.java)
        }
    }
}