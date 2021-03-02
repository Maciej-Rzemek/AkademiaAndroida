package com.example.akademiaandroida.core.di

import org.koin.core.module.Module

var koinInjector: List<Module> = featureModules
    .plus(appModule)
    .plus(networkModule)
    .plus(databaseModule)
