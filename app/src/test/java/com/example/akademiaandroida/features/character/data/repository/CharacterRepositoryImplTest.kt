package com.example.akademiaandroida.features.character.data.repository

import com.example.akademiaandroida.core.api.RickAndMortyApi
import com.example.akademiaandroida.core.api.model.characters.CharacterResponse
import com.example.akademiaandroida.core.network.NetworkStateProvider
import com.example.akademiaandroida.features.character.data.local.CharactersDao
import com.example.akademiaandroida.features.character.data.local.model.CharacterCached
import com.example.akademiaandroida.features.character.domain.CharactersRepository
import com.example.akademiaandroida.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class CharacterRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN characters request THEN fetch characters from API`() {
        val api = mockk<RickAndMortyApi>() {
            coEvery { getCharacter() } returns CharacterResponse.mock()
        }

        val characterDao = mockk<CharactersDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: CharactersRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { api.getCharacter() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN characters request THEN save characters to local database`() {
        val api = mockk<RickAndMortyApi>() {
            coEvery { getCharacter() } returns CharacterResponse.mock()
        }

        val characterDao = mockk<CharactersDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: CharactersRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider)


        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { characterDao.saveCharacters(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN characters request THEN fetch characters from local database`() {
        //given
        val api = mockk<RickAndMortyApi>(relaxed = true)

        val characterDao = mockk<CharactersDao> {
            coEvery { getCharacters() } returns listOf(
                CharacterCached.mock(),
                CharacterCached.mock()
            )
        }

        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }

        val repository: CharactersRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider)


        //when
        runBlocking { repository.getCharacters() }

        //then

        coVerify { characterDao.getCharacters() }
    }
}