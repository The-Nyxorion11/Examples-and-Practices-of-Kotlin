package com.tami.divisas.ViewModel

import android.util.Log
import com.tami.divisas.Model.ApiService
import com.tami.divisas.Model.getRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//paso 6 hace la corrutina y detecta el error
//llama a la divisa 1
suspend fun searchByName1(query: String): Map<String, Double>{
    return withContext(Dispatchers.IO){
        try {
            val call = getRetrofit().create(ApiService::class.java).getDivisas("$query")
            //es para recuperar resultado
            val puppies = call.body()

            if (call.isSuccessful) {
                //muestra que funciona
                val response = call.body()
                Log.i("API_CALL", "llamada exitosa: $response")
                //recupera el resultado
                if (puppies != null){
                    return@withContext puppies.divisa
                }else{
                    return@withContext emptyMap()
                }

            } else {
                //muestra error
                val errorResponse = call.errorBody()
                Log.e("API_CALL", "Error de HTTP: ${call.code()} - $errorResponse")
                return@withContext emptyMap()
            }

        } catch (e: Exception) {
            Log.e("API_CALL", "Error de conexion o inesperado: ${e.message}", e)
            return@withContext emptyMap()
        }
    }
}

// es lo mismo que la otra
//llama a la divisa 2
suspend fun searchByName2(query: String): Map<String, Double>{
    return withContext(Dispatchers.IO){
        try {
            val call = getRetrofit().create(ApiService::class.java).getDivisas("$query")
            val puppies = call.body()

            if (call.isSuccessful) {
                //muestra que funciona
                val response = call.body()
                Log.i("API_CALL", "llamada exitosa: $response")
                if (puppies != null){
                    return@withContext puppies.divisa
                }else{
                    return@withContext emptyMap()
                }

            } else {
                //muestra error
                val errorResponse = call.errorBody()
                Log.e("API_CALL", "Error de HTTP: ${call.code()} - $errorResponse")
                return@withContext emptyMap()
            }

        } catch (e: Exception) {
            Log.e("API_CALL", "Error de conexion o inesperado: ${e.message}", e)
            return@withContext emptyMap()
        }
    }
}