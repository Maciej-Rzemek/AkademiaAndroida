package com.example.akademiaandroida.features.episodes

import com.example.akademiaandroida.features.episodes.domain.model.Episode

interface EpisodesRepository {
    suspend fun getEpisodes(): List<Episode>
}