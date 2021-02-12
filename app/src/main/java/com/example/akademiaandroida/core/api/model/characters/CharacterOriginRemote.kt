package com.example.akademiaandroida.core.api.model.characters

import com.example.akademiaandroida.features.character.domain.model.CharacterOrigin
import com.google.gson.annotations.SerializedName

data class CharacterOriginRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    companion object

    fun toCharacterOrigin() =
        CharacterOrigin(
            name = name,
            url = url
        )
}