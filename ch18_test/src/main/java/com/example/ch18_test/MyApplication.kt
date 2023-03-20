package com.example.ch18_test

import android.app.Application

import com.example.ch18_test.retrofit.NetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application() {

    companion object {
        val QUERY = "travel"
        val API_KEY = "ySW6Ei6Oncs0opwRU%2FDIeWdmLYyXDK7LXEybY0cGhExFc10LY76oPuVHH5nXFB0FM7A3I1QKOvuiIbtAkIirhw%3D%3D"
        val BASE_URL = "http://apis.data.go.kr/6260000/WalkingService"
        val USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36"


        //add....................................
        var networkService: NetworkService
        val retrofit: Retrofit
            get() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        init {
            networkService = retrofit.create(NetworkService::class.java)
        }
    }

}