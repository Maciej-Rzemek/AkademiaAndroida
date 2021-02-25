package com.example.akademiaandroida.core.DI

import com.example.akademiaandroida.features.episodes.di.episodeModule
import org.koin.core.module.Module

var featureModules = listOf<Module>(
    episodeModule
)