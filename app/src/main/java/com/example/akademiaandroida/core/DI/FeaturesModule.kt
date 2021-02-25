package com.example.akademiaandroida.core.DI

import com.example.akademiaandroida.features.character.di.characterModule
import com.example.akademiaandroida.features.episodes.di.episodeModule
import com.example.akademiaandroida.features.location.di.locationModule
import org.koin.core.module.Module

var featureModules = listOf<Module>(
    episodeModule,
    locationModule,
    characterModule
)