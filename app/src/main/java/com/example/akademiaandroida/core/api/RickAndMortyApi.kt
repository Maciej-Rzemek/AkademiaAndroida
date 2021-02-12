package com.example.akademiaandroida.core.api

import com.example.akademiaandroida.core.api.model.characters.CharacterResponse
import com.example.akademiaandroida.core.api.model.episodes.EpisodeResponse
import com.example.akademiaandroida.core.api.model.locations.LocationsResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodeResponse

    @GET("location")
    suspend fun getLocations(): LocationsResponse

    @GET("character")
    suspend fun getCharacter(): CharacterResponse
}