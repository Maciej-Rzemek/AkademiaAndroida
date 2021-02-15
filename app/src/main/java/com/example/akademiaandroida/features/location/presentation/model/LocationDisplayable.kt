package com.example.akademiaandroida.features.location.presentation.model

import com.example.akademiaandroida.features.location.domain.model.Location


data class LocationDisplayable(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<Any>,
    val url: String
) {
    constructor(location: Location) : this(
        id = location.id,
        name = location.name,
        type = location.type,
        dimension = location.dimension,
        residents = location.residents,
        url = location.url
    )

}