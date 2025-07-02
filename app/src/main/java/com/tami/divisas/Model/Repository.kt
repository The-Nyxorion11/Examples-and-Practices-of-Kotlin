package com.tami.divisas.Model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

//paso 6 hace la corrutina
private fun searchByName(query: String){
    CoroutineScope(Dispatchers.IO).launch{
        val call = getRetrofit().create(ApiService::class.java).getDivisas("$query")
        val puppies = call.body()

        if (call.isSuccessful){
            //Show RecyclerView
        }else{
            //Show Error
        }
    }
}