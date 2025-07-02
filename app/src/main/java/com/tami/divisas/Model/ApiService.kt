package com.tami.divisas.Model

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url
import retrofit2.http.GET

const val API_KEY = "a9d26db2d6msh66af67e9f3082c3p101795jsnd0ed325f471b"
const val API_KEY_HEADER_NAME = "x-rapidapi-key"
const val RAPIDAPI_HOST = "exchangerate-api.p.rapidapi.com"

//esto es solo cuando la api pide una key header
object RetrofiClient {
    fun getRetrofit(): Retrofit {
        val authInterceptor = Interceptor{
            chain -> val originalRequest = chain.request()

            val newRequest = originalRequest.newBuilder()
                .header(API_KEY_HEADER_NAME, API_KEY)
                .header("x-rapidapi-host", RAPIDAPI_HOST)
                .build()

            chain.proceed(newRequest)
        }


        val httpClient = OkHttpClient.Builder().apply {
            addInterceptor (authInterceptor)
        }.build()

        return Retrofit.Builder()
            .baseUrl("https://exchangerate-api.p.rapidapi.com/rapid/latest/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

//esto si es obligatorio
interface ApiService{
    @GET
    //el suspend es para la corrutina
    //paso 4 llama la api
    suspend fun getDivisas(@Url url: String): Response<DataResponse>
}
