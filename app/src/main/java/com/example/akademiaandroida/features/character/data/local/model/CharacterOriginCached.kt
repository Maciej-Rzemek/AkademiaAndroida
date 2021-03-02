package com.example.akademiaandroida.features.character.data.local.model

import com.example.akademiaandroida.features.character.domain.model.CharacterOrigin


data class CharacterOriginCached(
    val originName: String,
    val originUrl: String
) {
    constructor(characterOrigin: CharacterOrigin) : this(
        characterOrigin.name,
        characterOrigin.url
    )

    companion object

    fun toCharacterOrigin() = CharacterOrigin(
        name = originName,
        url = originUrl
    )

}