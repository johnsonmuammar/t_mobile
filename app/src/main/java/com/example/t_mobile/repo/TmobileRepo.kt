package com.example.t_mobile.repo

import com.example.t_mobile.remote.RetrofitInstance


object TmobileRepo {

    val tmobileService = RetrofitInstance.TMOBILE_SERVICE

    suspend fun getTmobileResponse() = tmobileService.getTmobileResponse()
}