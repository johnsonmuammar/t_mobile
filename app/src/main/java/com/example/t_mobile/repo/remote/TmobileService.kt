package com.example.t_mobile.remote


import com.example.t_mobile.model.TmobileResponse
import retrofit2.http.GET


interface TmobileService {

    @GET("home")
    suspend fun getTmobileResponse(): TmobileResponse

}