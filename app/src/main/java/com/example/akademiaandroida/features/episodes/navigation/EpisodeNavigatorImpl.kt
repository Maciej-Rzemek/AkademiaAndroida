package com.example.akademiaandroida.features.episodes.navigation

import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.navigation.FragmentNavigator
import com.example.akademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import com.example.akademiaandroida.features.episodes.details.presentation.EpisodeDetailsFragment

class EpisodeNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : EpisodeNavigator {

    override fun openEpisodeDetailsScreen(episode: EpisodeDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_episodes_screen_to_episode_details_screen,
            EpisodeDetailsFragment.EPISODE_DETAILS_KEY to episode
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}