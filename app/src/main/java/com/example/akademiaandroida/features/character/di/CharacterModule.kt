package com.example.akademiaandroida.features.character.di

import com.example.akademiaandroida.features.character.data.repository.CharacterRepositoryImpl
import com.example.akademiaandroida.features.character.domain.CharactersRepository
import com.example.akademiaandroida.features.character.domain.GetCharactersUseCase
import com.example.akademiaandroida.features.character.presentation.CharacterFragment
import com.example.akademiaandroida.features.character.presentation.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {

    //data
    factory<CharactersRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetCharactersUseCase(get()) }

    //presentation
    viewModel { CharacterViewModel(get(), get()) }
    factory { CharacterFragment() }
}