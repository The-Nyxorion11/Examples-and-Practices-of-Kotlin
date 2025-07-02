package com.tami.divisas.view


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import kotlinx.coroutines.launch
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tami.divisas.ViewModel.operation
import kotlinx.coroutines.Dispatchers

@Preview
@Composable
fun UI(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.background(color = Color.Black).fillMaxSize()) {
            Divisas()
        }
    }
}

@Composable
fun Divisas(){
    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        var textValueFirst by remember { mutableStateOf("") }
        var textValueSecond by remember { mutableStateOf("") }
        var cantidad by remember { mutableDoubleStateOf(0.0) }
        var cantidadInString by remember { mutableStateOf("") }

        var waitResult by remember { mutableDoubleStateOf(0.0) }
        val coroutineScope = rememberCoroutineScope()
        var isLoading by remember { mutableStateOf(false) }

        Text(
            text = "Conversor de moneda",
            fontSize = 30.sp,
            color = Color.White
        )

        OutlinedTextField(
            value = textValueFirst,
            onValueChange = { newValue -> textValueFirst = newValue },
            singleLine  = true,
            label = { Text(text = "Divisa") },
            placeholder = { Text("Ingresa una divisa") },
        )

        OutlinedTextField(
            value = cantidadInString,
            onValueChange = { newValue -> cantidadInString = newValue },
            singleLine  = true,
            label = {Text(text= "Cantidad")},
            placeholder = { Text("Ingresa una cantidad")},
        )
        cantidad = cantidadInString.toDoubleOrNull()?: 0.0

        Spacer(modifier = Modifier.width(20.dp))

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Icono de cambio1",
            tint = Color.White,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Icono de cambio2",
            tint = Color.White,
        )

        Spacer(modifier = Modifier.width(20.dp))

        OutlinedTextField(
            value = textValueSecond,
            onValueChange = { newValue -> textValueSecond = newValue },
            singleLine  = true,
            label = {Text(text= "Divisa")},
            placeholder = { Text("Ingresa una divisa")},
        )

        Spacer(modifier = Modifier.width(100.dp))

        Button(onClick = {
            coroutineScope.launch(Dispatchers.IO){
                isLoading = true
                try {
                    val result = operation(textValueFirst, textValueSecond, cantidad)
                    waitResult = result
                    Log.d("Divisa", "Exito absoluto")
                }catch (e: Exception){
                    Log.e("Divisa", "error al realizar una operacion: ${e.message}", e)
                    waitResult = 0.0
                }finally {
                    isLoading = false
                }
            }


        }) {
            Text(text = "Total: ")
        }

        Text(
            text= "$waitResult",
            fontSize = 50.sp,
            color = Color.White
        )


    }
}

