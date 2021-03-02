package com.example.akademiaandroida.features.character.di

import com.example.akademiaandroida.features.character.all.presentation.CharacterAdapter
import com.example.akademiaandroida.features.character.all.presentation.CharacterFragment
import com.example.akademiaandroida.features.character.all.presentation.CharacterViewModel
import com.example.akademiaandroida.features.character.data.repository.CharacterRepositoryImpl
import com.example.akademiaandroida.features.character.details.presentation.CharacterDetailsFragment
import com.example.akademiaandroida.features.character.details.presentation.CharacterDetailsViewModel
import com.example.akademiaandroida.features.character.domain.CharactersRepository
import com.example.akademiaandroida.features.character.domain.GetCharactersUseCase
import com.example.akademiaandroida.features.character.navigation.CharacterNavigator
import com.example.akademiaandroida.features.character.navigation.CharacterNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {

    //data
    factory<CharactersRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetCharactersUseCase(get()) }

    // navigation
    factory<CharacterNavigator> { CharacterNavigatorImpl(get()) }

    //presentation
    viewModel { CharacterViewModel(get(), get(), get()) }
    factory { CharacterFragment() }
    viewModel { CharacterDetailsViewModel() }
    factory { CharacterDetailsFragment() }
    factory { CharacterAdapter() }
}