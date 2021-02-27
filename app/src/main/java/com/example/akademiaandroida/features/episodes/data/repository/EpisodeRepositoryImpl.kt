package com.example.akademiaandroida.features.episodes.data.repository

import com.example.akademiaandroida.core.api.RickAndMortyApi
import com.example.akademiaandroida.core.exeption.ErrorWrapper
import com.example.akademiaandroida.core.exeption.callOrThrow
import com.example.akademiaandroida.core.network.NetworkStateProvider
import com.example.akademiaandroida.features.episodes.data.local.EpisodeDao
import com.example.akademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.example.akademiaandroida.features.episodes.domain.EpisodesRepository
import com.example.akademiaandroida.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val episodeDao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : EpisodesRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) {
                getEpisodesFromRemote()
            }
                .also { saveEpisodesToLocal(it) }
        } else {
            getEpisodesFromLocal()
        }
    }

    private suspend fun getEpisodesFromRemote(): List<Episode> {
        return rickAndMortyApi.getEpisodes()
            .results
            .map { it.toEpisode() }
            .also { saveEpisodesToLocal(it) }
    }

    private suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { episodeDao.saveEpisodes(*it) }
    }

    private suspend fun getEpisodesFromLocal(): List<Episode> {
        return episodeDao.getEpisodes()
            .map { it.toEpisode() }
    }


}