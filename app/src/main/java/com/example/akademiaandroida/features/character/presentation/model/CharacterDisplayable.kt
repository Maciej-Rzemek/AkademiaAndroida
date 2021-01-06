package com.example.akademiaandroida.features.character.presentation.model

import com.example.akademiaandroida.features.character.domain.model.Character
import com.example.akademiaandroida.features.data.remote.model.Location
import com.example.akademiaandroida.features.data.remote.model.Origin

data class CharacterDisplayable(
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
) {
    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        origin = character.origin,
        location = character.location,
        image = character.image,
        episode = character.episode,
        url = character.url,
        created = character.created
    )
}
