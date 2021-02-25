package com.example.akademiaandroida.features.episodes.di

import com.example.akademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import com.example.akademiaandroida.features.episodes.domain.EpisodesRepository
import com.example.akademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.example.akademiaandroida.features.episodes.presentation.EpisodeFragment
import com.example.akademiaandroida.features.episodes.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {

    //data
    factory<EpisodesRepository> { EpisodeRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodeViewModel(get()) }
    factory { EpisodeFragment() }
}
