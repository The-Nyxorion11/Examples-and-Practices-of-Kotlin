package com.tami.divisas.View

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun UI(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.background(color = Color.Black).fillMaxSize()) {
            divisas()
        }
    }
}

@Composable
fun divisas(){
    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        var textValueFirst by remember { mutableStateOf("") }
        var textValueSecond by remember { mutableStateOf("") }

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

        Spacer(modifier = Modifier.width(20.dp))

        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Icono de cambio1",
            tint = Color.White,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            imageVector = Icons.Filled.ArrowForward,
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
        Spacer(modifier = Modifier.width(50.dp))

        Button() {

        }


    }
}