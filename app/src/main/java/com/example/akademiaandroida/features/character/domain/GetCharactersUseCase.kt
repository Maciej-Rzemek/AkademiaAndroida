package com.example.akademiaandroida.features.character.domain

import com.example.akademiaandroida.core.base.UseCase
import com.example.akademiaandroida.features.character.domain.model.Character

class GetCharactersUseCase(private val charactersRepository: CharactersRepository) :
    UseCase<List<Character>, Unit>() {
    override suspend fun action(params: Unit): List<Character> =
        charactersRepository.getCharacters()


}