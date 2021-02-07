package com.example.akademiaandroida.core.api.model.characters

import com.example.akademiaandroida.features.character.domain.model.Character
import com.google.gson.annotations.SerializedName


data class CharacterRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val characterOriginRemote: CharacterOriginRemote,
    @SerializedName("location") val characterLocationRemote: CharacterLocationRemote,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<Any>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) {
    companion object

    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        characterOrigin = characterOriginRemote.toCharacterOrigin(),
        characterLocation = characterLocationRemote.toCharacterLocation(),
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}


