package com.example.akademiaandroida.features.character.all.presentation.model

import android.os.Parcelable
import com.example.akademiaandroida.features.character.domain.model.Character
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterDisplayable(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val characterOrigin: CharacterOriginDisplayable,
    val characterLocation: CharacterLocationDisplayable,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
) : Parcelable {

    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        characterOrigin = CharacterOriginDisplayable(character.characterOrigin),
        characterLocation = CharacterLocationDisplayable(character.characterLocation),
        image = character.image,
        episode = character.episode,
        url = character.url,
        created = character.created
    )

    companion object
}


