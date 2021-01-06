package com.example.akademiaandroida.features.character.domain.model

import com.example.akademiaandroida.features.data.remote.model.Location
import com.example.akademiaandroida.features.data.remote.model.Origin

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<Any>,
    val url: String,
    val created: String
)