package com.example.t_mobile.repo

import com.example.t_mobile.repo.remote.RetrofitInstance


object TmobileRepo {

    private val tmobileService = RetrofitInstance.TMOBILE_SERVICE

    suspend fun getTmobileResponse() = tmobileService.getTmobileResponse()
}