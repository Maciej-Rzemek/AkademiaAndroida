package com.example.akademiaandroida.features.location.di

import com.example.akademiaandroida.features.location.all.presentation.LocationAdapter
import com.example.akademiaandroida.features.location.all.presentation.LocationFragment
import com.example.akademiaandroida.features.location.all.presentation.LocationViewModel
import com.example.akademiaandroida.features.location.data.repository.LocationsRepositoryImpl
import com.example.akademiaandroida.features.location.details.presentation.LocationDetailsFragment
import com.example.akademiaandroida.features.location.details.presentation.LocationDetailsViewModel
import com.example.akademiaandroida.features.location.domain.GetLocationsUseCase
import com.example.akademiaandroida.features.location.domain.LocationsRepository
import com.example.akademiaandroida.features.location.navigation.LocationNavigator
import com.example.akademiaandroida.features.location.navigation.LocationNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {

    //data
    factory<LocationsRepository> { LocationsRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetLocationsUseCase(get()) }

    // navigation
    factory<LocationNavigator> { LocationNavigatorImpl(get()) }

    //presentation
    viewModel {
        LocationViewModel(
            get(),
            get(),
            get()
        )
    }
    factory { LocationFragment() }
    viewModel { LocationDetailsViewModel() }
    factory { LocationDetailsFragment() }
    factory { LocationAdapter() }
}