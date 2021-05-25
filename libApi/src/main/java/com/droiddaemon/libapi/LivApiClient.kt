package com.droiddaemon.libapi

import com.droiddaemon.libapi.api.ApiInterface
import com.droiddaemon.libapi.interceptors.AuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object LivApiClient {

    private val okHttp = OkHttpClient.Builder()
        .addNetworkInterceptor(AuthInterceptor())
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttp)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.imgur.com/3/")
        .build()

    val api = retrofit.create(ApiInterface::class.java)
}