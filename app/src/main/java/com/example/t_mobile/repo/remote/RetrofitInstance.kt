package com.example.t_mobile.repo.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://private-8ce77c-tmobiletest.apiary-mock.com/test/"

    private val client = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }.let { loginIntercept -> OkHttpClient.Builder().addInterceptor(loginIntercept).build() }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    val TMOBILE_SERVICE: TmobileService by lazy { retrofit.create(TmobileService::class.java) }
}