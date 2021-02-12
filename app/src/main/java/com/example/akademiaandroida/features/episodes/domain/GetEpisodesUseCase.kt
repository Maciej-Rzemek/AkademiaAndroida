package com.example.akademiaandroida.features.episodes.domain

import com.example.akademiaandroida.core.base.UseCase
import com.example.akademiaandroida.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodesRepository: EpisodesRepository) :
    UseCase<List<Episode>, Unit>() {

    override suspend fun action(params: Unit): List<Episode> {
        return episodesRepository.getEpisodes()
    }


}