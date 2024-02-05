package com.example.prueba1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// Clase ProductViewModel que extiende ViewModel, utilizada para manejar la lógica de la interfaz de usuario y las interacciones con la API.
class ProductViewModel : ViewModel() {

    // Utiliza la delegación de propiedad mutableStateOf para gestionar el estado de ProductState.
    var state by mutableStateOf(ProductState())
        private set

    // Utiliza la delegación de propiedad mutableStateOf para gestionar la lista de respuestas de la API.
    var response: List<PostModel> by mutableStateOf(listOf())
        private set

    // Inicialización, donde se realiza la llamada a la API para obtener la lista de productos.
    init {
        // Utiliza viewModelScope para lanzar una corrutina en el ámbito del ViewModel.
        viewModelScope.launch {

            // Actualiza el estado para indicar que la carga está en curso.
            state = state.copy(
                isLoading = true
            )

            // Obtiene una instancia de ApiService utilizando el método estático de la interfaz.
            val apiService = ApiService.getInstace()

            // Realiza la llamada a la API para obtener la lista de productos.
            val productList = apiService.getPost()

            // Actualiza la lista de respuestas con los datos obtenidos de la API.
            response = productList

            // Actualiza el estado para indicar que la carga ha finalizado y asigna la lista de productos al estado.
            state = state.copy(
                isLoading = false,
                products = response
            )
        }
    }
}
