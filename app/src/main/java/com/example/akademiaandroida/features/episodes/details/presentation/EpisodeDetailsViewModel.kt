package com.example.akademiaandroida.features.episodes.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.akademiaandroida.core.base.BaseViewModel
import com.example.akademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeDetailsViewModel : BaseViewModel() {

    private val _episode by lazy { MutableLiveData<EpisodeDisplayable>() }
    val episode: LiveData<EpisodeDisplayable> by lazy { _episode }

    fun onEpisodeDataPassed(episodeDisplayable: EpisodeDisplayable) {
        _episode.value = episodeDisplayable
    }
}