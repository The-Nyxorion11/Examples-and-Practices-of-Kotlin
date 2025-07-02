package com.tami.divisas.Model

import com.google.gson.annotations.SerializedName

/*tienen que ser igual a como esta en el json
*como este caso que result = el mensaje (seccess)
* y rates = la url o la lista en este caso
 */
                        //este es para el mensaje //esta es la lista
//data class DataResponse(var result: String, var rates: List<String>) {}

//paso 3 pasa de json a dataClass
data class DataResponse(
    //pero ojito puedo cambiar el nombre de las variables
    @SerializedName("result") var status : String,
    @SerializedName("rates") var divisa: Map<String, Double>
)
