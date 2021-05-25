package com.droiddaemon.libapi.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor:Interceptor {

    companion object {
        // TODO: Ideally better if it comes from BuildConfig.java
        private const val CLIENT_ID = "2583831f4866fd1"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Client-ID $CLIENT_ID")
            .build()


        val response = chain.proceed(request)
        return response
    }
}