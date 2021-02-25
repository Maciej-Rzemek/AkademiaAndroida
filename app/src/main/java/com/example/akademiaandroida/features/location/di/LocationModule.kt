package com.example.akademiaandroida.features.location.di

import com.example.akademiaandroida.features.location.data.repository.LocationsRepositoryImpl
import com.example.akademiaandroida.features.location.domain.GetLocationsUseCase
import com.example.akademiaandroida.features.location.domain.LocationsRepository
import com.example.akademiaandroida.features.location.presentation.LocationFragment
import com.example.akademiaandroida.features.location.presentation.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {

    //data
    factory<LocationsRepository> { LocationsRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetLocationsUseCase(get()) }

    //presentation
    viewModel { LocationViewModel(get(), get()) }
    factory { LocationFragment() }
}