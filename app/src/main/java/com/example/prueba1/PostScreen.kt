package com.example.prueba1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
// Función PostScreen que representa la interfaz de usuario para mostrar una lista de elementos obtenidos a través de un ProductViewModel.
fun PostScreen(productViewModel: ProductViewModel) {
    // Obtiene el estado actual del ProductViewModel.
    val state = productViewModel.state

    // Verifica si el estado indica que se está cargando.
    if (state.isLoading) {
        // Si está cargando, muestra un indicador de progreso en un cuadro centrado.
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

    // Utiliza LazyColumn para mostrar la lista de elementos de manera eficiente.
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        // Mapea y muestra cada elemento de la lista de respuesta del productViewModel.
        itemsIndexed(items = productViewModel.response) { index, item ->
            // Crea un Card que contiene un Column con Texto para cada propiedad del elemento.
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    // Muestra las propiedades del elemento en Texto.
                    Text(text = "UserID: ${item.userId}")
                    Text(text = "ID: ${item.id}")
                    Text(text = "Title: ${item.title}")
                    Text(text = "Body: ${item.body}")
                }
            }
        }
    }
}

