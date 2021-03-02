package com.example.akademiaandroida.features.episodes.details.presentation

import android.os.Bundle
import androidx.lifecycle.observe
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import com.example.akademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import kotlinx.android.synthetic.main.fragment_episode_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeDetailsFragment :
    BaseFragment<EpisodeDetailsViewModel>(R.layout.fragment_episode_details) {

    override val viewModel: EpisodeDetailsViewModel by viewModel()

    companion object {
        const val EPISODE_DETAILS_KEY = "episode_details_key"
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisode()
    }

    private fun observeEpisode() {
        viewModel.episode.observe(this) { displayEpisode(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutEpisodeData()
    }

    private fun displayEpisode(episode: EpisodeDisplayable) {
        episode_title.text = episode.name
        episode_per_season.text = episode.code
    }

    private fun notifyAboutEpisodeData() {
        arguments
            ?.getParcelable<EpisodeDisplayable>(EPISODE_DETAILS_KEY)
            ?.let { viewModel.onEpisodeDataPassed(it) }
    }
}