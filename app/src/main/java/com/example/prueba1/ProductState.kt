package com.example.prueba1

// Clase de datos ProductState que representa el estado de la aplicación en relación con la obtención y carga de productos.
data class ProductState(
    // Lista de productos, inicializada como una lista vacía por defecto.
    val products: List<PostModel> = emptyList(),
    // Indicador de carga, inicializado como falso por defecto.
    val isLoading: Boolean = false
)
