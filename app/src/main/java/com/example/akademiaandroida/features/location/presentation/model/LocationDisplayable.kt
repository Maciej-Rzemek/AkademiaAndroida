package com.example.akademiaandroida.features.location.presentation.model


data class LocationDisplayable(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<Any>,
    val url: String,
    val created: String
) {
    constructor(locationDisplayable: LocationDisplayable) : this(
        id = locationDisplayable.id,
        name = locationDisplayable.name,
        type = locationDisplayable.type,
        dimension = locationDisplayable.dimension,
        residents = locationDisplayable.residents,
        url = locationDisplayable.url,
        created = locationDisplayable.created
    )
}