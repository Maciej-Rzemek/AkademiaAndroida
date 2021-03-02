package com.example.akademiaandroida.features.episodes.di

import com.example.akademiaandroida.features.episodes.all.presentation.EpisodeAdapter
import com.example.akademiaandroida.features.episodes.all.presentation.EpisodeFragment
import com.example.akademiaandroida.features.episodes.all.presentation.EpisodeViewModel
import com.example.akademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import com.example.akademiaandroida.features.episodes.details.presentation.EpisodeDetailsFragment
import com.example.akademiaandroida.features.episodes.details.presentation.EpisodeDetailsViewModel
import com.example.akademiaandroida.features.episodes.domain.EpisodesRepository
import com.example.akademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.example.akademiaandroida.features.episodes.navigation.EpisodeNavigator
import com.example.akademiaandroida.features.episodes.navigation.EpisodeNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {

    // data
    factory<EpisodesRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { GetEpisodesUseCase(get()) }

    // navigation
    factory<EpisodeNavigator> { EpisodeNavigatorImpl(get()) }

    // presentation
    viewModel { EpisodeViewModel(get(), get(), get()) }
    factory { EpisodeFragment() }
    viewModel { EpisodeDetailsViewModel() }
    factory { EpisodeDetailsFragment() }
    factory { EpisodeAdapter() }
}