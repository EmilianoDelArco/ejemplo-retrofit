package com.example.prueba1

import com.google.gson.annotations.SerializedName

// Declaración de la clase PostModel con la palabra clave "data", que automáticamente genera los métodos toString(), equals(), hashCode(), y copy().
data class PostModel (
    // Anotación que especifica el nombre del campo en JSON correspondiente a esta propiedad.
    @SerializedName("userId")
    // Declaración de una propiedad 'userId' de tipo entero (Int).
    var userId: Int,

    // Anotación que especifica el nombre del campo en JSON correspondiente a esta propiedad.
    @SerializedName("id")
    // Declaración de una propiedad 'id' de tipo entero (Int).
    var id: Int,

    // Anotación que especifica el nombre del campo en JSON correspondiente a esta propiedad.
    @SerializedName("title")
    // Declaración de una propiedad 'title' de tipo String.
    var title: String,

    // Anotación que especifica el nombre del campo en JSON correspondiente a esta propiedad.
    @SerializedName("body")
    // Declaración de una propiedad 'body' de tipo String.
    var body: String
)