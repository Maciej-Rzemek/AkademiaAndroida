package com.example.akademiaandroida.features.character.presentation.model

import com.example.akademiaandroida.features.character.domain.model.Character
import com.example.akademiaandroida.features.character.domain.model.CharacterLocation
import com.example.akademiaandroida.features.character.domain.model.CharacterOrigin

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
        characterOrigin = CharacterOriginDisplayable(character.characterOrigin),
        characterLocation = CharacterLocationDisplayable(character.characterLocation),
        image = character.image,
        episode = character.episode,
        url = character.url,
        created = character.created
    )
}

data class CharacterOriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(characterOrigin: CharacterOrigin) : this(
        name = characterOrigin.name,
        url = characterOrigin.url
    )
}

data class CharacterLocationDisplayable(
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )
}