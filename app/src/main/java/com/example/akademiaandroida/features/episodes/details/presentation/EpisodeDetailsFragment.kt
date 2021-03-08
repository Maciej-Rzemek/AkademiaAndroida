package com.example.akademiaandroida.features.episodes.details.presentation

import android.os.Bundle
import com.example.akademiaandroida.BR
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import com.example.akademiaandroida.databinding.FragmentEpisodeBinding
import com.example.akademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeDetailsFragment :
    BaseFragment<EpisodeDetailsViewModel, FragmentEpisodeBinding>(
        BR.viewModel,
        R.layout.fragment_episode_details
    ) {

    override val viewModel: EpisodeDetailsViewModel by viewModel()

    companion object {
        const val EPISODE_DETAILS_KEY = "episode_details_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutEpisodeData()
    }

    private fun notifyAboutEpisodeData() {
        arguments
            ?.getParcelable<EpisodeDisplayable>(EPISODE_DETAILS_KEY)
            ?.let { viewModel.onEpisodeDataPassed(it) }
    }
}