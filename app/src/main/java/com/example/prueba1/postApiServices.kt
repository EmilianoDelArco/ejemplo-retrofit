package com.example.prueba1

import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Definición de la interfaz ApiService que describe las operaciones de la API.
interface ApiService {

    // Anotación @GET que indica una solicitud HTTP GET con la ruta "posts".
    @GET("posts")
    // Función suspend que realiza la solicitud GET y devuelve una lista de objetos PostModel de manera asíncrona.
    suspend fun getPost(): List<PostModel>

    // Bloque companion object que contiene métodos y propiedades estáticas asociadas a la interfaz.
    companion object {

        // Declaración de una variable nullable 'apiService' que representa una instancia de ApiService.
        private var apiService: ApiService? = null

        // Declaración de una variable constante 'urlBase' que contiene la URL base de la API.
        private var urlBase = "https://jsonplaceholder.typicode.com/"

        // Método estático que devuelve una instancia de ApiService.
        fun getInstace(): ApiService {
            // Verifica si apiService es nulo.
            if (apiService == null) {
                // Si es nulo, crea una nueva instancia de Retrofit y asigna a apiService.
                apiService = Retrofit.Builder()
                    .baseUrl(urlBase)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            // Devuelve la instancia de apiService.
            return apiService!!
        }
    }
}
