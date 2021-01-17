package com.example.akademiaandroida.features.location.domain.model


data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<Any>,
    val url: String,
    val created: String
)