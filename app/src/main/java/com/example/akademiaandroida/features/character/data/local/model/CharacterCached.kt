package com.example.akademiaandroida.features.character.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.akademiaandroida.features.character.domain.model.Character

@Entity
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val characterOriginCached: CharacterOriginCached,
    val characterLocationCached: CharacterLocationCached,
    val image: String,
    val episode: List<Any>,
    val url: String,
    val created: String
) {
    constructor(character: Character) : this(
        character.id,
        character.name,
        character.status,
        character.species,
        character.type,
        character.gender,
        CharacterOriginCached(character.characterOrigin),
        CharacterLocationCached(character.characterLocation),
        character.image,
        character.episode,
        character.url,
        character.created
    )

    companion object

    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        characterOrigin = characterOriginCached.toCharacterOrigin(),
        characterLocation = characterLocationCached.toCharacterLocation(),
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}