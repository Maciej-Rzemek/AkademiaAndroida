package com.example.akademiaandroida.features.episodes.navigation

import com.example.akademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

interface EpisodeNavigator {
    fun openEpisodeDetailsScreen(episode: EpisodeDisplayable)
    fun goBack()
}