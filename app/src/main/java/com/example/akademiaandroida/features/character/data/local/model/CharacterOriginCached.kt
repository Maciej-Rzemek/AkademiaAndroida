package com.example.akademiaandroida.features.character.data.local.model

import com.example.akademiaandroida.features.character.domain.model.CharacterOrigin


data class CharacterOriginCached(
    val name: String,
    val url: String
) {
    constructor(characterOrigin: CharacterOrigin) : this(
        characterOrigin.name,
        characterOrigin.url
    )

    companion object

    fun toCharacterOrigin() = CharacterOrigin(
        name = name,
        url = url
    )

}