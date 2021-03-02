package com.example.akademiaandroida.core.di

import com.example.akademiaandroida.features.character.di.characterModule
import com.example.akademiaandroida.features.episodes.di.episodeModule
import com.example.akademiaandroida.features.location.di.locationModule

val featureModules = listOf(
    episodeModule,
    locationModule,
    characterModule
)