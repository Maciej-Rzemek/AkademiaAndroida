package com.example.akademiaandroida.features.character.domain.model

import com.example.akademiaandroida.features.data.remote.model.CharacterLocationRemote
import com.example.akademiaandroida.features.data.remote.model.CharacterOriginRemote

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val characterOrigin: CharacterOriginRemote,
    val characterLocationRemote: CharacterLocationRemote,
    val image: String,
    val episode: List<Any>,
    val url: String,
    val created: String
)

class CharacterLocation(
    val name: String,
    val url: String
)

class CharacterOrigin(
    val name: String,
    val url: String
)