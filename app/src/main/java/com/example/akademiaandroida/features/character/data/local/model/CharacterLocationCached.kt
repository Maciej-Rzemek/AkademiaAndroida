package com.example.akademiaandroida.features.character.data.local.model

import com.example.akademiaandroida.features.character.domain.model.CharacterLocation

data class CharacterLocationCached(
    val locationName: String,
    val locationUrl: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        characterLocation.name,
        characterLocation.url
    )

    companion object

    fun toCharacterLocation() = CharacterLocation(
        name = locationName,
        url = locationUrl
    )

}