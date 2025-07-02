package com.tami.divisas.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//paso 5 es el combersor de json a kotlin
internal fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        //tiene que terminar en / la url
        .baseUrl("https://exchangerate-api.p.rapidapi.com/rapid/latest/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}