package com.tami.divisas.Model

import retrofit2.Response
import retrofit2.http.Url
import retrofit2.http.GET

interface ApiService{
    @GET
    //el suspend es para la corrutina
    //paso 4 llama la api
    suspend fun getDivisas(@Url url: String): Response<DataResponse>
}