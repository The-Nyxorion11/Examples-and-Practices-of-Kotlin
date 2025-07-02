package com.tami.divisas.ViewModel

import android.util.Log
import com.tami.divisas.Model.ApiService
import com.tami.divisas.Model.getRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

//paso 6 hace la corrutina y detecta el error
private fun searchByName(query: String){
    CoroutineScope(Dispatchers.IO).launch{
        try {

            val call = getRetrofit().create(ApiService::class.java).getDivisas("$query")
            val puppies = call.body()

            if (call.isSuccessful) {
                //muestra que funciona
                val response = call.body()
                Log.i("API_CALL", "llamada exitosa: $response")
            } else {
                //muestra error
                val errorResponse = call.errorBody()
                Log.i("API_CALL", "Error de HTTP: ${call.code()} - $errorResponse")
            }

        }catch (e : Exception){
            Log.i("API_CALL", "Error de conexion o inesperado: ${e.message}", e)
        }
    }
}