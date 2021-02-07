package com.example.akademiaandroida.features.character.domain.model

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val characterOrigin: CharacterOrigin,
    val characterLocation: CharacterLocation,
    val image: String,
    val episode: List<Any>,
    val url: String,
    val created: String
) {
    companion object
}


