package com.example.akademiaandroida.features.character.data.repository

import com.example.akademiaandroida.core.api.RickAndMortyApi
import com.example.akademiaandroida.core.exeption.ErrorWrapper
import com.example.akademiaandroida.core.exeption.callOrThrow
import com.example.akademiaandroida.core.network.NetworkStateProvider
import com.example.akademiaandroida.features.character.data.local.CharactersDao
import com.example.akademiaandroida.features.character.data.local.model.CharacterCached
import com.example.akademiaandroida.features.character.domain.CharactersRepository
import com.example.akademiaandroida.features.character.domain.model.Character

class CharacterRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val charactersDao: CharactersDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper

) : CharactersRepository {

    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) {
                getCharactersFromRemote()
            }
                .also { saveCharactersToLocal(it) }
        } else {
            getCharactersFromLocal()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return rickAndMortyApi.getCharacter()
            .results
            .map { it.toCharacter() }
            .also { saveCharactersToLocal(it) }
    }

    private suspend fun saveCharactersToLocal(characters: List<Character>) {
        characters.map { CharacterCached(it) }
            .toTypedArray()
            .let { charactersDao.saveCharacters(*it) }
    }

    private suspend fun getCharactersFromLocal(): List<Character> {
        return charactersDao.getCharacters()
            .map { it.toCharacter() }
    }

}