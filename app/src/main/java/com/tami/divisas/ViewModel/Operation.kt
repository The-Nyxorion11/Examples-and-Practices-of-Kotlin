package com.tami.divisas.ViewModel

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

//hace la operacion para saber el rasultado
suspend fun operation(Divisa1: String, Divisa2: String, ValorQuerido: Double): Double {

    val result1 = searchByName1(Divisa1)
    val result2 = searchByName2(Divisa2)
    val Divisa1 = result1[Divisa1]
    val Divisa2 = result2[Divisa2]

    if (Divisa1 != null && Divisa2 != null && Divisa2 != 0.0) {
        val total = Divisa1 / Divisa2 * ValorQuerido
        return total

    } else {
        Log.e("OPERATION", "Error inesperado")
        val total = 0.0
        return total
    }


}