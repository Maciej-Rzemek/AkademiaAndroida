package com.example.akademiaandroida.features.character

import com.example.akademiaandroida.features.character.domain.model.Character

interface CharactersRepository {
    suspend fun getCharacters(): List<Character>
}