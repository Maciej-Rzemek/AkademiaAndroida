package com.example.akademiaandroida.features.location.presentation.model


data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<Any>,
    val url: String,
    val created: String
) {
    constructor(location: Location) : this(
        id = location.id,
        name = location.name,
        type = location.type,
        dimension = location.dimension,
        residents = location.residents,
        url = location.url,
        created = location.created
    )
}