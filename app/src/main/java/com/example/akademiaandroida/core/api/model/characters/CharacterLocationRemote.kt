package com.example.akademiaandroida.core.api.model.characters

import com.example.akademiaandroida.features.character.domain.model.CharacterLocation
import com.google.gson.annotations.SerializedName

data class CharacterLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    companion object

    fun toCharacterLocation() =
        CharacterLocation(
            name = name,
            url = url
        )
}